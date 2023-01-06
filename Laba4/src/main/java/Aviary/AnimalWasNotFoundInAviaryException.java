package main.java.Aviary;

public class AnimalWasNotFoundInAviaryException extends Exception {
    public AnimalWasNotFoundInAviaryException(String errorMessage) {
        super(errorMessage);
    }
}
