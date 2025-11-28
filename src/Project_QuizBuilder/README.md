🎓 QuizBuilder – Java Console Application

QuizBuilder là ứng dụng quản lý Quiz + làm bài Quiz trên console (Java), được xây dựng theo mô hình MVC đầy đủ:
•	Model: Account, Quiz, Questions, QuizResult, YourAnswer
•	Repository: Lưu và tải dữ liệu CSV
•	Service: Kiểm tra ràng buộc nghiệp vụ
•	Controller: Điều phối logic giữa View – Repo – Service
•	View: Menu Console có màu, thân thiện

⸻

📌 1. Chức Năng Chính

🧩 1.1. Quản lý Quiz (Management Quiz)
•	Thêm Quiz
•	Xóa Quiz
•	Cập nhật Quiz
•	Tìm quiz theo ID
•	Hiển thị danh sách quiz
•	Trong mỗi quiz có thể:
•	Thêm câu hỏi
•	Sửa câu hỏi
•	Xóa câu hỏi
•	Xem câu hỏi theo Quiz
•	Tìm câu hỏi theo ID

⸻

📝 1.2. Làm bài Quiz (Work Quiz)
•	Người dùng nhập username
•	Chọn bài quiz muốn làm
•	Trả lời từng câu hỏi
•	Tự động tính điểm
•	Lưu kết quả vào file quiz_result.csv
•	Lưu lựa chọn người dùng vào file answer.csv

⸻

🧾 1.3. Xem kết quả quiz (Answer / Score)
•	Xem điểm số của chính mình
•	Xem tất cả các bài làm
•	Tìm bài làm theo username
•	Xóa bài làm

⸻

📁 2. Cấu Trúc Thư Mục

Project_QuizBuilder/
│
├── entity/
│   ├── Account.java
│   ├── Questions.java
│   ├── Quiz.java
│   ├── QuizResult.java
│   └── YourAnswer.java
│
├── repository/
│   ├── AccountRepo.java
│   ├── QuestionsRepo.java
│   ├── QuizRepo.java
│   ├── QuizResultRepo.java
│   └── AnswerManagerRepo.java
│
├── controller/
│   ├── AccountController.java
│   ├── QuestionsController.java
│   ├── QuizController.java
│   ├── QuizResultController.java
│   └── YourAnswerController.java
│
├── view/
│   ├── LoginView.java
│   ├── MainView.java
│   ├── QuizView.java
│   ├── QuesView.java
│   └── WorkQuizView.java
│
├── common/
│   ├── CheckInput.java
│   └── TryCatch.java
│
├── data/
│   ├── account.csv
│   ├── quiz.csv
│   ├── questions.csv
│   ├── quiz_result.csv
│   └── answer.csv
│
└── Main.java


⸻

🗄 3. Lưu Dữ Liệu Bằng CSV

Hệ thống sử dụng 5 file CSV:

File	Lưu gì?
account.csv	Tài khoản đăng nhập
quiz.csv	Danh sách Quiz
questions.csv	Danh sách câu hỏi
quiz_result.csv	Kết quả làm Quiz
answer.csv	Danh sách bài làm của user

Tất cả đều có:
•	Load từ file khi khởi động
•	Ghi file ngay sau mỗi lần sửa/xóa/thêm
•	Tự động cập nhật auto–increment ID bằng nextID

⸻

🔧 4. Mô Hình MVC (Đúng Chuẩn)

Model (entity/)

Lưu trữ dữ liệu thuần, không chứa logic nghiệp vụ.

Repository (repository/)

Đọc / Ghi CSV.

Controller (controller/)

Điều hướng: View → Repo → Service → Repo → View.

Service (service/)

Kiểm tra ràng buộc:
•	Check trùng ID
•	Check quiz tồn tại
•	Check câu hỏi hợp lệ
•	Check username tồn tại/không tồn tại

View (view/)

Menu console, hiển thị bảng bằng ASCII + màu sắc ANSI.

⸻

🧮 5. Quy Trình Làm Bài Quiz
1.	User đăng nhập
2.	Vào WorkQuiz
3.	App kiểm tra user đã làm quiz này chưa
4.	Cho trả lời từng câu
5.	Cộng điểm đúng
6.	Lưu QuizResult
7.	Lưu YourAnswer

⸻

🛑 6. Một Số Quy Tắc Bảo Toàn Logic
•	Không tạo biến trong View → toàn bộ logic xử lý nằm ở Controller
•	Không lưu List trong QuizResult → sửa lại thành chỉ lưu Quiz quiz
•	Tất cả Repo phải có load/save
•	ID tự tăng, không được cho user nhập
•	Không cho 1 user làm 1 quiz 2 lần



⸻

🌟 7. Điểm Mạnh của Project

✔ Có toàn bộ chức năng một hệ quiz hoàn chỉnh
✔ Có lưu trữ CSV (như database mini)
✔ Dễ mở rộng → thêm database thật (MySQL, Mongo…)
✔ UI đẹp bằng ASCII + màu console
✔ Mã chia theo MVC rõ ràng
✔ Xử lý ngoại lệ tốt (TryCatch wrapper)
✔ Code sạch – tách lớp hợp lý

⸻

🧑‍💻 Tác giả

Hieu Nguyen 
Sinh viên – Lập trình Java – Xây dựng hệ thống QuizBuilder Console App.

⸻

