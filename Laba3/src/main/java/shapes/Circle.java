package main.java.shapes;


import main.java.utils.IInstrument;

public class Circle extends Shape {
    private double radius;

    public Circle(String shapeColor, double radius) {
        super(shapeColor);
        this.radius = radius;
    }

    @Override
    public double calcArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public void draw() {
        final IInstrument.Instrument instrument = new IInstrument.Instrument();

        System.out.println(instrument.changeColorForString(this.shapeColor, "◯"));
    }

    @Override
    public String toString() {
        return String.format("Circle with radius: %f", radius);
    }
}
