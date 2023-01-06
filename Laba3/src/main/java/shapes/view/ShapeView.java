package main.java.shapes.view;

import main.java.shapes.Shape;

public class ShapeView {
    Shape[] shapesView;

    public ShapeView(Shape[] shapesView) {
        this.shapesView = shapesView;
    }

    public void showShapes() {
        for (Shape currentShape : shapesView) {
            currentShape.draw();
            System.out.println(currentShape.toString());
        }
    }
}
