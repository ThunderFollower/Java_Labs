package main.java.Aviary;


import main.java.Animal.Hoofed;

public class HoofedAviary<T extends Hoofed> extends MammalAviary<T>{
    public HoofedAviary(Double sizeInSquareM, int numberOfPlaces){
        super(sizeInSquareM, numberOfPlaces);
    }
}
