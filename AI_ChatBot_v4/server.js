import express from "express";
import path from "path";
import { fileURLToPath } from "url";
import "dotenv/config";

const app = express();
app.use(express.json());

const __filename = fileURLToPath(import.meta.url);
const __dirname = path.dirname(__filename);

app.use(express.static(path.join(__dirname, "public")));

app.post("/api/chat", async (req, res) => {
  try {
    const userMessage = req.body?.message ?? "";
    if (!userMessage) return res.json({ reply: "Bạn chưa nhập gì." });

    const GEMINI_MODEL = "gemini-2.5-flash"; // đổi nếu bạn muốn
    const url = `https://generativelanguage.googleapis.com/v1beta/models/${GEMINI_MODEL}:generateContent`;
    const response = await fetch(url, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
        "x-goog-api-key": process.env.GEMINI_API_KEY, // ✅ Gemini key
      },
      body: JSON.stringify({
        contents: [
          {
            parts: [{ text: userMessage }],
          },
        ],
      }),
    });

    const data = await response.json();

    if (!response.ok) {
      return res.status(response.status).json({
        reply: `Gemini error ${response.status}: ${data?.error?.message ?? "Unknown"}`,
      });
    }

    const reply =
      data?.candidates?.[0]?.content?.parts?.map(p => p.text).join("") ??
      "No response";

    res.json({ reply });
  } catch (err) {
    res.status(500).json({ reply: "Server error" });
  }
  console.log("GEMINI KEY:", process.env.GEMINI_API_KEY);
});

app.listen(3000, () => console.log("✅ Server running: http://localhost:3000"));