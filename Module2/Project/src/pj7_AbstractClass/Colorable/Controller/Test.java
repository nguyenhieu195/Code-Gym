package pj7_AbstractClass.Colorable.Controller;

import pj7_AbstractClass.Resizeable.Entity.Circle;
import pj7_AbstractClass.Resizeable.Entity.Rectangle;
import pj7_AbstractClass.Colorable.Entity.Square;
import pj7_AbstractClass.Colorable.Service.Colorable;

public class Test {
    public static void main(String[] args) {
        Object[] shapes = {
                new Rectangle(2.3, 5.6),
                new Square("red", 2.2f),
                new Circle(1.3),
                new Circle(2.3),
                new Square("green", 2.2f)
        };

        for (Object object : shapes) {
            System.out.println("---------------------");
            System.out.println(object.toString());

            // In diện tích tùy loại hình
            if (object instanceof Rectangle) {
                Rectangle r = (Rectangle) object;
                System.out.println("Area: " + r.getAra());
            } else if (object instanceof Circle) {
                Circle c = (Circle) object;
                System.out.println("Area: " + c.getAra());
            } else if (object instanceof Square) {
                Square s = (Square) object;
                System.out.println("Area: " + s.getArea());
            }

            // Nếu là Colorable thì gọi howToColor()
            if (object instanceof Colorable) {
                ((Colorable) object).howToColor();
            }
        }
    }
}