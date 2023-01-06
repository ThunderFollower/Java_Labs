package main.java.shapes;


import main.java.utils.IInstrument;

public class Triangle extends Shape {
    private double firstSide;
    private double secondSide;
    private double thirdSide;

    public Triangle(String shapeColor, double firstSide, double secondSide, double thirdSide) {
        super(shapeColor);
        this.firstSide = firstSide;
        this.secondSide = secondSide;
        this.thirdSide = thirdSide;
    }

    @Override
    public double calcArea() {
        double halfPerimeter = 0.5 * (firstSide + secondSide + thirdSide);
        return Math.sqrt(halfPerimeter * (halfPerimeter - firstSide) * (halfPerimeter - secondSide) * (halfPerimeter - thirdSide));
    }

    @Override
    public void draw() {
        final IInstrument.Instrument instrument = new IInstrument.Instrument();
        System.out.println(instrument.changeColorForString(this.shapeColor, "△"));
    }

    @Override
    public String toString() {
        return String.format("Triangle with sides: %f, %f, %f", firstSide, secondSide, thirdSide);
    }
}
