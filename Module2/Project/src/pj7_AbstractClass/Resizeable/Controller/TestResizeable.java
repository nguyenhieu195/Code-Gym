package pj7_AbstractClass.Resizeable.Controller;
import pj7_AbstractClass.Resizeable.Entity.Circle;
import pj7_AbstractClass.Resizeable.Entity.Rectangle;
import pj7_AbstractClass.Resizeable.Entity.Square;
import pj7_AbstractClass.Resizeable.Service.Resizeable;
import java.util.Random;
public class TestResizeable {
    public static void main(String[] args) {
        Random rand = new Random();

        // Tạo mảng chứa các hình (Resizeable)
        Resizeable[] shapes = new Resizeable[3];
        shapes[0] = new Circle(5);
        shapes[1] = new Rectangle(3, 4);
        shapes[2] = new Square(6);

        // Duyệt mảng, resize từng phần tử
        for (Resizeable shape : shapes) {
            double percent = rand.nextInt(100) + 1; // 1-100%

            System.out.println("---------------");
            System.out.println("Trước khi resize:");
            printArea(shape);

            shape.resize(percent);

            System.out.println("Sau khi resize (+" + percent + "%):");
            printArea(shape);
        }
    }

    // Hàm phụ để in diện tích tùy loại hình
    private static void printArea(Resizeable shape) {
        if (shape instanceof Circle) {
            Circle c = (Circle) shape;
            System.out.println("Hình tròn – diện tích = " + c.getAra());
        } else if (shape instanceof Rectangle && !(shape instanceof Square)) {
            Rectangle r = (Rectangle) shape;
            System.out.println("Hình chữ nhật – diện tích = " + r.getAra());
        } else if (shape instanceof Square) {
            Square s = (Square) shape;
            System.out.println("Hình vuông – diện tích = " + s.getAra());
        }
    }
}
