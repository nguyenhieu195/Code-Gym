package Project_QuizBuilder.common;

public class TryCatch {

    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    // Dùng cho hàm KHÔNG trả về giá trị (add, remove, update)
    public static boolean tryDo(Action action) {
        try {
            action.run();
            return true;
        } catch (Exception e) {
            System.out.println(RED+"ERROR: " + e.getMessage()+RESET);
            return false;
        }
    }

    // Dùng cho hàm CÓ trả về giá trị (findById, get...)
    public static <T> T tryCall(Callable<T> callable) {
        try {
            return callable.call();
        } catch (Exception e) {
            System.out.println(RED+"ERROR: " + e.getMessage()+RESET);
            return null;
        }
    }

    // Functional interface
    public interface Action {
        void run() throws Exception;
    }

    public interface Callable<T> {
        T call() throws Exception;
    }
}
