package main.java.Aviary;


import main.java.Animal.Bird;

public class BirdAviary<T extends Bird> extends Aviary<T> {
    public BirdAviary(Double sizeInSquareM, int numberOfPlaces) {
        super(sizeInSquareM, numberOfPlaces);
    }
}
