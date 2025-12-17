const input = document.getElementById("input");
const send = document.getElementById("send");
const messages = document.getElementById("messages");

send.onclick = sendMessage;
input.onkeypress = e => e.key === "Enter" && sendMessage();

function addMessage(text, cls) {
  const div = document.createElement("div");
  div.className = cls;
  div.textContent = text;
  messages.appendChild(div);
}

async function sendMessage() {
  const text = input.value.trim();
  if (!text) return;

  addMessage("You: " + text, "user");
  input.value = "";

  const res = await fetch("/api/chat", {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({ message: text })
  });

  const data = await res.json();
  addMessage("Bot: " + data.reply, "bot");
}