package main.java.Aviary;


import main.java.Animal.Mammal;

public class MammalAviary<T extends Mammal> extends Aviary<T>{
    public MammalAviary(Double sizeInSquareM, int numberOfPlaces){
        super(sizeInSquareM, numberOfPlaces);
    }
}
