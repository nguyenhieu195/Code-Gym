// Lấy các phần tử DOM
const promptInput = document.getElementById('prompt');
const languageSelect = document.getElementById('language');
const generateBtn = document.getElementById('generateBtn');
const codeOutput = document.getElementById('codeOutput');
const codeHeader = document.getElementById('codeHeader');
const outputLanguage = document.getElementById('outputLanguage');
const copyBtn = document.getElementById('copyBtn');
const historyList = document.getElementById('historyList');
const errorContainer = document.getElementById('errorContainer');

// Load lịch sử khi trang tải
window.addEventListener('load', () => {
    loadHistory();
});

// Xử lý sinh code
generateBtn.addEventListener('click', async () => {
    const prompt = promptInput.value.trim();
    const language = languageSelect.value;

    // Xóa thông báo lỗi cũ
    errorContainer.innerHTML = '';

    // Validate input
    if (!prompt) {
        showError('Vui lòng nhập mô tả bài toán!');
        return;
    }

    // Disable button và hiển thị loading
    generateBtn.disabled = true;
    generateBtn.textContent = '⏳ Đang sinh code...';
    codeOutput.innerHTML = `
        <div class="loading">
            <div class="spinner"></div>
            <div>Đang xử lý yêu cầu của bạn...</div>
        </div>
    `;
    codeHeader.style.display = 'none';

    try {
        // Gọi API từ server
        const response = await fetch('/api/generate-code', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({ prompt, language })
        });

        const data = await response.json();

        if (!response.ok) {
            throw new Error(data.error || 'Lỗi từ server');
        }

        const code = data.code;

        // Hiển thị code
        displayCode(code, language);

        // Lưu vào lịch sử
        saveToHistory(prompt, language, code);

    } catch (error) {
        showError('Lỗi: ' + error.message);
        codeOutput.innerHTML = `<div style="color: #f44336; padding: 20px;">❌ ${error.message}</div>`;
    } finally {
        generateBtn.disabled = false;
        generateBtn.textContent = '✨ Sinh Code';
    }
});

// Hiển thị code
function displayCode(code, language) {
    codeOutput.textContent = code;
    outputLanguage.textContent = language;
    codeHeader.style.display = 'flex';
}

// Copy code
copyBtn.addEventListener('click', () => {
    const code = codeOutput.textContent;
    navigator.clipboard.writeText(code).then(() => {
        copyBtn.textContent = '✅ Đã copy!';
        setTimeout(() => {
            copyBtn.textContent = '📋 Copy Code';
        }, 2000);
    });
});

// Lưu lịch sử
function saveToHistory(prompt, language, code) {
    let history = JSON.parse(localStorage.getItem('codeHistory') || '[]');

    const item = {
        id: Date.now(),
        prompt: prompt,
        language: language,
        code: code,
        timestamp: new Date().toLocaleString('vi-VN')
    };

    history.unshift(item);

    // Giới hạn 20 item
    if (history.length > 20) {
        history = history.slice(0, 20);
    }

    localStorage.setItem('codeHistory', JSON.stringify(history));
    loadHistory();
}

// Load lịch sử
function loadHistory() {
    const history = JSON.parse(localStorage.getItem('codeHistory') || '[]');

    if (history.length === 0) {
        historyList.innerHTML = '<div style="color: #999; text-align: center; padding: 30px;">Chưa có lịch sử nào</div>';
        return;
    }

    historyList.innerHTML = history.map(item => `
        <div class="history-item" onclick="loadHistoryItem(${item.id})">
            <div class="history-item-header">
                <span class="history-prompt">${item.prompt.substring(0, 60)}${item.prompt.length > 60 ? '...' : ''}</span>
                <span class="history-lang">${item.language}</span>
                <span class="history-time">${item.timestamp}</span>
                <button class="btn btn-delete" onclick="deleteHistory(${item.id}, event)">🗑️</button>
            </div>
        </div>
    `).join('');
}

// Load lại code từ lịch sử
window.loadHistoryItem = function (id) {
    const history = JSON.parse(localStorage.getItem('codeHistory') || '[]');
    const item = history.find(h => h.id === id);

    if (item) {
        promptInput.value = item.prompt;
        languageSelect.value = item.language;
        displayCode(item.code, item.language);
    }
};

// Xóa lịch sử
window.deleteHistory = function (id, event) {
    event.stopPropagation();

    let history = JSON.parse(localStorage.getItem('codeHistory') || '[]');
    history = history.filter(h => h.id !== id);
    localStorage.setItem('codeHistory', JSON.stringify(history));
    loadHistory();
};

// Hiển thị lỗi
function showError(message) {
    errorContainer.innerHTML = `<div class="error-message">⚠️ ${message}</div>`;
}
