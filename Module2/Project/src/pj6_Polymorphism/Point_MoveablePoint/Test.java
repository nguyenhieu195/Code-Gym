package pj6_Polymorphism.Point_MoveablePoint;

public class Test {
    public static void main(String[] args) {
        MoveablePoint mp = new MoveablePoint(1.5f, 2.5f, 0.5f, 1.0f);
        System.out.println(mp);      // (1.5,2.5), speed=(0.5,1.0)

        mp.move();
        System.out.println(mp);      // (2.0,3.5), speed=(0.5,1.0)
    }
}