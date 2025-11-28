package Project_QuizBuilder.view;

import Project_QuizBuilder.common.CheckInput;
import Project_QuizBuilder.controller.AccountController;
import Project_QuizBuilder.entity.Account;

public class LoginView {
    public static final String RESET = "\u001B[0m";
    public static final String PINK = "\u001B[35m";
    public static final String BOLD = "\u001B[1m";
    private CheckInput input;

    private MainView mainView;
    private AccountController accountController;

    public LoginView(MainView mainView) {
        this.mainView = mainView;
        try {
            accountController = new AccountController();
        } catch (Exception e) {
            System.out.println("Cannot initialize AccountController: " + e.getMessage());
        }
        input = new CheckInput();
    }

    public void menuLogin() {
        while (true) {

            System.out.println("╔══════════════════════════════════════════════╗");
            System.out.println("║" + BOLD + PINK + "                  HELLO WORLD                 " + RESET + "║");
            System.out.println("╠══════════════════════════════════════════════╣");
            System.out.println("║ 1. Login                                     ║");
            System.out.println("║ 2. Create an account                         ║");
            System.out.println("║ 0. Exit                                      ║");
            System.out.println("╚══════════════════════════════════════════════╝");

            int choice = input.inputInt("Enter choice: ");

            switch (choice) {
                case 1 -> {
                    String username = login();
                    if (username != null) {
                        mainView.menu(username);
                    }
                }
                case 2 -> register();
                case 0 -> System.exit(0);
                default -> System.out.println("Invalid choice!");

            }
        }
    }


    public String login() {

        System.out.println("====== LOGIN ======");

        try {
            String username = input.inputString("Username: ");
            String password = input.inputString("Password: ");

            Account acc = null;

            for (Account a : accountController.getListAccount()) {
                if (a.getUsername().equals(username) &&
                        a.getPassword().equals(password)) {
                    acc = a;
                    break;
                }
            }

            if (acc == null) {
                throw new Exception("Wrong username or password!");
            }

            System.out.println("Login success! Welcome " + acc.getUsername());

            return acc.getUsername();

        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
            return null;
        }

    }

    public void register() {

        System.out.println("====== REGISTER ======");

        while (true) {
            try {
                String username = input.inputString("New username: ");
                String password = input.inputString("New password: ");

                // KIỂM TRA TRÙNG USERNAME bằng getListAccount()
                for (Account existing : accountController.getListAccount()) {
                    if (existing.getUsername().equalsIgnoreCase(username)) {
                        throw new Exception("Username already exists!");
                    }
                }

                Account newAcc = new Account(username, password);

                accountController.add(newAcc);

                System.out.println("Account created successfully!");
                break;

            } catch (Exception e) {
                System.out.println("ERROR: " + e.getMessage());
            }
        }
    }
}