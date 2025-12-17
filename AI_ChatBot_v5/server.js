import express from "express";
import path from "path";
import { fileURLToPath } from "url";
import "dotenv/config";

const app = express();
app.use(express.json());

const __filename = fileURLToPath(import.meta.url);
const __dirname = path.dirname(__filename);

// Serve static files từ thư mục public
app.use(express.static(path.join(__dirname, "public")));

// Route chính để serve index.html
app.get("/", (req, res) => {
  res.sendFile(path.join(__dirname, "public", "index.html"));
});

// API endpoint sinh code
app.post("/api/generate-code", async (req, res) => {
  try {
    const { prompt, language } = req.body;

    if (!prompt || !language) {
      return res.status(400).json({ error: "Thiếu prompt hoặc language" });
    }

    const GEMINI_API_KEY = process.env.GEMINI_API_KEY;
    if (!GEMINI_API_KEY) {
      return res.status(500).json({ error: "API key không được cấu hình" });
    }

    const systemPrompt = `Bạn là AI lập trình viên chuyên nghiệp. Hãy sinh code ${language} theo yêu cầu sau:
"${prompt}"

YÊU CẦU:
- Code ngắn gọn, rõ ràng, chạy được
- Có comment tiếng Việt giải thích
- KHÔNG giải thích dài dòng
- CHỈ TRẢ VỀ CODE, KHÔNG THÊM MARKDOWN hay text khác
- Không thêm \`\`\`${language.toLowerCase()} ở đầu
- Format code đúng chuẩn ${language}`;

    // Thử các model theo thứ tự ưu tiên
    const models = ["gemini-2.0-flash", "gemini-1.5-flash", "gemini-pro"];
    let lastError = null;
    for (const model of models) {
      try {
        const apiUrl = `https://generativelanguage.googleapis.com/v1beta/models/gemini-2.5-flash:generateContent?key=${GEMINI_API_KEY}`;

        const response = await fetch(apiUrl, {
          method: "POST",
          headers: {
            "Content-Type": "application/json",
          },
          body: JSON.stringify({
            contents: [
              {
                parts: [
                  {
                    text: systemPrompt,
                  },
                ],
              },
            ],
          }),
        });

        if (!response.ok) {
          const errorData = await response.json();
          lastError = errorData.error?.message || `Model ${model} thất bại`;
          console.warn(`Model ${model} failed:`, lastError);
          continue;
        }

        const data = await response.json();
        let code = data?.candidates?.[0]?.content?.parts?.[0]?.text;

        if (!code) {
          lastError = "Model trả về dữ liệu không hợp lệ";
          continue;
        }

        // Làm sạch code (loại bỏ markdown)
        code = code.replace(/```[\w\-]*\n?/g, "").trim();

        return res.json({ code });
      } catch (err) {
        lastError = err.message;
        console.warn(`Model ${model} error:`, err.message);
        continue;
      }
    }

    // Nếu tất cả model đều thất bại
    return res.status(503).json({
      error: lastError || "Không thể sinh code với các model có sẵn",
    });
  } catch (err) {
    console.error("Lỗi:", err);
    res.status(500).json({ error: err.message || "Lỗi server" });
  }
});

// Lắng nghe port 3000
const PORT = process.env.PORT || 3000;
app.listen(PORT, () => {
  console.log(`🚀 Server chạy tại http://localhost:${PORT}`);
});
