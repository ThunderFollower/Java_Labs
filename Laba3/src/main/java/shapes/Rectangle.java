package main.java.shapes;


import main.java.utils.IInstrument;

public class Rectangle extends Shape {
    private double firstSide;
    private double secondSide;

    public Rectangle(String shapeColor, double firstSide, double secondSide) {
        super(shapeColor);
        this.firstSide = firstSide;
        this.secondSide = secondSide;
    }

    @Override
    public double calcArea() {
        return firstSide * secondSide;
    }

    @Override
    public void draw() {
        final IInstrument.Instrument instrument = new IInstrument.Instrument();
        System.out.println(instrument.changeColorForString(this.shapeColor, "▢"));
    }

    @Override
    public String toString() {
        return String.format("Rectangle with sides: %f, %f", firstSide, secondSide);
    }
}
