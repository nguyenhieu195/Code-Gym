document.addEventListener("DOMContentLoaded", function () {
  const chatbotContainer = document.getElementById("chatbot-container");
  const chatbotIcon = document.getElementById("chatbot-icon");
  const closeBtn = document.getElementById("close-btn");
  const sendBtn = document.getElementById("send-btn");
  const chatbotInput = document.getElementById("chatbot-input");
  const chatbotMessages = document.getElementById("chatbot-messages");

  chatbotIcon.onclick = () => {
    chatbotContainer.classList.remove("hidden");
    chatbotIcon.style.display = "none";
  };

  closeBtn.onclick = () => {
    chatbotContainer.classList.add("hidden");
    chatbotIcon.style.display = "flex";
  };

  sendBtn.onclick = sendMessage;
  chatbotInput.onkeypress = e => e.key === "Enter" && sendMessage();

  function sendMessage() {
    const msg = chatbotInput.value.trim();
    if (!msg) return;
    appendMessage("user", msg);
    chatbotInput.value = "";
    getBotResponse(msg);
  }

  function appendMessage(role, text) {
    const div = document.createElement("div");
    div.className = `message ${role}`;
    div.textContent = text;
    chatbotMessages.appendChild(div);
    chatbotMessages.scrollTop = chatbotMessages.scrollHeight;
  }

  async function getBotResponse(message) {
    try {
      const res = await fetch("/api/chat", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ message })
      });
      const data = await res.json();
      appendMessage("bot", data.reply || "No response");
    } catch {
      appendMessage("bot", "Server error");
    }
  }
});