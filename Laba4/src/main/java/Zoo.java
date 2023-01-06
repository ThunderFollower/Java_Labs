package main.java;

import main.java.Aviary.Aviary;

import java.util.ArrayList;

public class Zoo {
    public ArrayList<Aviary<?>> cages = new ArrayList<>();

    public int getCountOfAnimals (){
        return cages.stream().mapToInt(s -> s.getNumberOfOccupiedPlaces()).sum();
    }

    public void addCage(Aviary<?> cageToAdd){
        cages.add(cageToAdd);
    }

}
