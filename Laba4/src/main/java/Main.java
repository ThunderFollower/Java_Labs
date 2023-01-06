package main.java;


import main.java.Animal.Bird;
import main.java.Animal.Zebra;
import main.java.Aviary.AnimalWasNotFoundInAviaryException;
import main.java.Aviary.BirdAviary;
import main.java.Aviary.HoofedAviary;
import main.java.Aviary.NoAvailablePlacesInAviaryException;

public class Main {
    public static void main(String[] args) throws AnimalWasNotFoundInAviaryException, NoAvailablePlacesInAviaryException {
        final HoofedAviary<Zebra> zebraAviary = new HoofedAviary<Zebra>(100.00, 1);
        zebraAviary.Add(new Zebra("car", 4, "papuga", "female"));
        final BirdAviary<Bird> birdAviary = new BirdAviary<Bird>(100.00, 3);
        birdAviary.Add(new Bird("car", 4, "papuga", "female"));
        birdAviary.Add(new Bird("car", 4, "papuga", "female"));


        final Zoo testZoo = new Zoo();
        testZoo.addCage(birdAviary);
        testZoo.addCage(zebraAviary);

        System.out.println(testZoo.getCountOfAnimals());
    }
}