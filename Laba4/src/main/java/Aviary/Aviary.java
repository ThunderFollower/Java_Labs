package main.java.Aviary;

import java.util.ArrayList;

public abstract class Aviary<T> {
    public Double sizeInSquareM;
    public int numberOfPlaces;
    public ArrayList<T> animals = new ArrayList<T>();

    public Aviary(Double sizeInSquareM, int numberOfPlaces) {
        this.sizeInSquareM = sizeInSquareM;
        this.numberOfPlaces = numberOfPlaces;
    }

    public void Add(T animalToAdd) throws NoAvailablePlacesInAviaryException {
        if (this.isThereAvailablePlaces()) {
            animals.add(animalToAdd);
        } else {
            throw new NoAvailablePlacesInAviaryException(String.format("In %s is no available places",
                    this.getClass().getTypeName()));
        }
    }

    public int getNumberOfPlaces() {
        return this.numberOfPlaces;
    }

    public int getNumberOfOccupiedPlaces() {
        return this.animals.size();
    }

    public boolean isThereAvailablePlaces() {
        return this.getNumberOfOccupiedPlaces() != this.getNumberOfPlaces();
    }

    public void Delete(T animalToDelete) throws AnimalWasNotFoundInAviaryException {
        int indexOfAnimalToDelete = animals.indexOf(animalToDelete);
        if (indexOfAnimalToDelete != -1) {
            System.out.printf("%s %s has been set free",
                    animalToDelete.getClass().getSimpleName(),
                    animalToDelete);
            animals.remove(indexOfAnimalToDelete);
        } else {
            throw new AnimalWasNotFoundInAviaryException(String.format("%s wasn't found in %s",
                    animalToDelete.getClass().getTypeName(),
                    this.getClass().getTypeName()));
        }
    }
}
