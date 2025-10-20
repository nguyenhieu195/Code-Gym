package pj6_Polymorphism.Shape;

public class Test {
    public static void main(String[] args) {
        Shape shape = new Shape();
        System.out.println(shape);

        shape = new Shape("red", false);
        System.out.println(shape);

        System.out.println();
        Circle circle = new Circle();
        System.out.println(circle);

        circle = new Circle("blue", false, 2.0);
        System.out.println(circle);

        System.out.println();
        Rectangle rectangle = new Rectangle();
        System.out.println(rectangle);

        rectangle = new Rectangle("white", false, 2.0, 3.0);
        System.out.println(rectangle);

        System.out.println();
        Square square = new Square();
        System.out.println(square);

        square = new Square("black", false, 3);
        System.out.println(square);
    }
}
