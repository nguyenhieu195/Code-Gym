package pj6_Polymorphism.Point;

public class Main {
    public static void main(String[] args) {
        Point2D p1 = new Point2D();
        Point3D p2 = new Point3D();

        p1.setXY(1,2);
        p2.setXYZ(2,3, 4);

        System.out.println("point2d: " + p1.toString());
        System.out.println("point3d: " + p2.toString());
    }
}
