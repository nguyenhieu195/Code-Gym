package pj7_AbstractClass.Resizeable.Entity;

public class Square extends Rectangle {
    public Square(String green, double v) {
        super(1.0, 1.0);
    }

    public Square(double side) {
        super(side, side);
    }

    public void setSide(double side) {
        setWidth(side);
        setLength(side);
    }

    public double getSide() {
        return getWidth();
    }

    @Override
    public void setWidth(double side) {
        super.setWidth(side);
        super.setLength(side);
    }

    @Override
    public void setLength(double side) {
        super.setLength(side);
        super.setWidth(side);
    }

    @Override
    public String toString() {
        return "A Square with side= " + getSide() +
                ", which is a subclass of " + super.toString();
    }
}
