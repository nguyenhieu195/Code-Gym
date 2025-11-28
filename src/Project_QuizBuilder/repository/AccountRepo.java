package Project_QuizBuilder.repository;

import Project_QuizBuilder.entity.Account;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AccountRepo {

    private static final String FILE_PATH = "src/Project_QuizBuilder/data/account.csv";

    private List<Account> listAccount;

    public AccountRepo() throws Exception {
        listAccount = new ArrayList<>();
        loadFromFile();
    }

    public List<Account> getListAccount() {
        return listAccount;
    }

    public void addAccount(Account account) {
        listAccount.add(account);
        try {
            saveToFile();
        } catch (Exception e) {
            System.out.println("Lỗi lưu file: " + e.getMessage());
        }
    }

    public void removeAccount(Account account) {
        listAccount.removeIf(a -> a.getId().equals(account.getId()));
        try {
            saveToFile();
        } catch (Exception e) {
            System.out.println("Lỗi lưu file: " + e.getMessage());
        }
    }


    private void loadFromFile() throws Exception {
        File file = new File(FILE_PATH);

        // Nếu file chưa tồn tại -> tạo file rỗng
        if (!file.exists()) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH))) {
                bw.write("id,username,password");
                bw.newLine();
            }
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {

            String line;
            boolean isFirst = true;
            int maxId = 0;

            while ((line = br.readLine()) != null) {

                if (isFirst) { // bỏ dòng tiêu đề
                    isFirst = false;
                    continue;
                }

                String[] data = line.split(",");
                if (data.length < 3) continue;

                Integer id;
                try {
                    id = Integer.parseInt(data[0].trim());
                } catch (Exception e) {
                    continue;
                }

                String username = data[1].trim();
                String password = data[2].trim();

                // load đúng constructor "load" (không tăng nextID)
                Account acc = new Account(id, username, password, null);

                listAccount.add(acc);

                if (id > maxId) maxId = id;
            }

            // cập nhật nextID theo ID lớn nhất trong file
            if (maxId > 0) {
                Account.setNextID(maxId);
            }

        } catch (IOException e) {
            throw new Exception("Lỗi đọc file account");
        }
    }

    private void saveToFile() throws Exception {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH))) {

            bw.write("id,username,password");
            bw.newLine();

            for (Account acc : listAccount) {
                bw.write(acc.getId() + "," +
                        acc.getUsername() + "," +
                        acc.getPassword());
                bw.newLine();
            }

        } catch (IOException e) {
            throw new Exception("Lỗi ghi file");
        }
    }
}
