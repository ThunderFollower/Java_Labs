package main.java.Aviary;


import main.java.Animal.Lion;

public class LionAviary<T extends Lion> extends MammalAviary<T>{
    public LionAviary(Double sizeInSquareM, int numberOfPlaces){
        super(sizeInSquareM, numberOfPlaces);
    }
}
