const API_KEY = "AIzaSyAErvvb1Z54fLFqHTaGAehg1lX5COUewfQ";

const chatBox = document.getElementById("chat");
const userInput = document.getElementById("userInput");
const sendBtn = document.getElementById("sendBtn");

function addMessage(text, sender = "user") {
  const msgDiv = document.createElement("div");
  msgDiv.classList.add("message", sender);
  msgDiv.textContent = text;
  chatBox.appendChild(msgDiv);
  chatBox.scrollTop = chatBox.scrollHeight;
}

async function callGemini(prompt) {
const url = `https://generativelanguage.googleapis.com/v1/models/gemini-1.5-flash:generateContent?key=${API_KEY}`;
  const response = await fetch(url, {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify({
      contents: [
        {
          parts: [{ text: prompt }],
        },
      ],
    }),
  });

  if (!response.ok) {
    throw new Error("Lỗi API: " + response.status);
  }

  const data = await response.json();
  return data.candidates[0].content.parts[0].text;
}

async function sendMessage() {
  const text = userInput.value.trim();
  if (!text) return;

  addMessage(text, "user");
  userInput.value = "";

  // Hiển thị "đang suy nghĩ"
  const loadingMsg = document.createElement("div");
  loadingMsg.classList.add("message", "bot", "loading");
  loadingMsg.textContent = "Gemini đang suy nghĩ...";
  chatBox.appendChild(loadingMsg);
  chatBox.scrollTop = chatBox.scrollHeight;

  try {
    const reply = await callGemini(text);
    chatBox.removeChild(loadingMsg);
    addMessage(reply, "bot");
  } catch (err) {
    chatBox.removeChild(loadingMsg);
    addMessage(
      "Lỗi: Không thể kết nối tới Gemini. Kiểm tra API key hoặc mạng.",
      "bot"
    );
    console.error(err);
  }
}

// Gửi bằng nút
sendBtn.addEventListener("click", sendMessage);

// Gửi bằng phím Enter
userInput.addEventListener("keypress", (e) => {
  if (e.key === "Enter") {
    sendMessage();
  }
});

// Tin nhắn chào đầu tiên
addMessage("Xin chào! Mình là Gemini AI, bạn cần giúp gì hôm nay? 😊", "bot");

