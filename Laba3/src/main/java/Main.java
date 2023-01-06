package main.java;


import main.java.bookstore.controller.IBookControlTarget;
import main.java.shapes.controller.IShapeControlTarget;

public class Main {
    public static void main(String[] args) {
        // Comment useless task 

        // 1st Task
        final IShapeControlTarget.ShapeController shapeController = new IShapeControlTarget.ShapeController();
        shapeController.executeActionsWithShapes();
        // 2nd Task
        final IBookControlTarget.BookController controller = new IBookControlTarget.BookController();
        controller.executeActionsWithBooks();
    }
}
