package main.java.shapes.controller;

import main.java.shapes.Circle;
import main.java.shapes.Rectangle;
import main.java.shapes.Shape;
import main.java.shapes.Triangle;
import main.java.shapes.view.ShapeView;
import main.java.utils.IInstrument;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public interface IShapeControlTarget {
    public double calculateSumOfAreas();

    public void showShapes();

    public double calculateSumOrAreasForConcreteShape(Class<?> concreteShape);

    public void sortShapesByArea();

    public void sortShapesByColor();

    public void executeActionsWithShapes();

    static final Shape[] shapes = {new Circle("red", 7), new Triangle("yellow", 3.5, 4.5, 5), new Rectangle("purple", 12, 7), new Circle("white", 12.7), new Circle("blue", 34), new Rectangle("cyan", 23.7, 16), new Triangle("black", 6.7, 4.3, 9), new Triangle("red", 61, 37, 29), new Rectangle("red", 234, 152), new Circle("yellow", 91), new Rectangle("cyan", 14.9, 21.3)};


    public class ShapeController implements IShapeControlTarget {

        final ShapeView shapeView = new ShapeView(shapes);

        public void showShapes() {
            this.shapeView.showShapes();
        }

        public double calculateSumOfAreas() {
            double sumOfAreas = 0;
            for (int i = 0; i < shapes.length; i++) {
                sumOfAreas += shapes[i].calcArea();
            }

            return sumOfAreas;
        }

        public double calculateSumOrAreasForConcreteShape(Class<?> concreteShape) {
            if (!(concreteShape != Shape.class && Shape.class.isAssignableFrom(concreteShape))) {
                System.out.println("There is no such shape");
                return 0;
            }

            double sumOfAreas = 0;
            for (int i = 0; i < shapes.length; i++) {
                if (concreteShape.isInstance(shapes[i])) sumOfAreas += shapes[i].calcArea();
            }

            return sumOfAreas;
        }

        public void sortShapesByArea() {
            Arrays.sort(shapes, new Comparator<Shape>() {
                public int compare(Shape firstShape, Shape secondShape) {
                    if (firstShape.calcArea() == secondShape.calcArea()) {
                        return 0;
                    }
                    return firstShape.calcArea() < secondShape.calcArea() ? -1 : 1;
                }
            });
        }

        public void sortShapesByColor() {
            Arrays.sort(shapes, new Comparator<Shape>() {
                public int compare(Shape firstShape, Shape secondShape) {
                    return firstShape.shapeColor.compareTo(secondShape.shapeColor);
                }
            });
        }

        public void executeActionsWithShapes() {
            final Scanner reader = new Scanner(System.in);
            final IInstrument.Instrument instrument = new IInstrument.Instrument();
            do {
                System.out.println("1 - Show shapes\n2 - Calculate sum of areas of all shapes\n" + "3 - Calculate sum of areas of concentrate shapes\n4 - Sort by areas\n" + "5 - Sort by shape color\nYour choice: ");
                switch (instrument.inputIntInRange(1, 5)) {
                    case 1:
                        this.shapeView.showShapes();
                        break;

                    case 2:
                        System.out.println("Sum of areas of all shapes: " + this.calculateSumOfAreas());
                        break;

                    case 3:
                        System.out.println("1 - Rectangle\n2 - Triangle\n3 - Circle\n" + "Your choice: ");
                        double sumOfAreasForConcreteShape = 0;
                        switch (instrument.inputIntInRange(1, 3)) {
                            case 1:
                                sumOfAreasForConcreteShape = this.calculateSumOrAreasForConcreteShape(Rectangle.class);
                                break;
                            case 2:
                                sumOfAreasForConcreteShape = this.calculateSumOrAreasForConcreteShape(Triangle.class);
                                break;
                            case 3:
                                sumOfAreasForConcreteShape = this.calculateSumOrAreasForConcreteShape(Circle.class);
                                break;
                        }
                        System.out.println("Sum of areas for 1 type of shapes: " + sumOfAreasForConcreteShape);
                        break;

                    case 4:
                        this.sortShapesByArea();
                        break;

                    case 5:
                        this.sortShapesByColor();
                        break;

                    default:
                        break;
                }
                System.out.print("Enter n to stop working with shapes " + "or any other input to continue\nYour choice: ");
            } while (reader.next().charAt(0) != 'n');
        }

    }

}
