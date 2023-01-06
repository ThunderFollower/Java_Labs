package main.java.shapes;

public abstract class Shape implements IDrawable {
    public String shapeColor;

    public Shape(String shapeColor) {
        this.shapeColor = shapeColor;
    }

    @Override
    public abstract void draw();

    public abstract double calcArea();

    @Override
    public String toString() {
        return "this is some of these shapes: ▢, △, ◯";
    }
}
