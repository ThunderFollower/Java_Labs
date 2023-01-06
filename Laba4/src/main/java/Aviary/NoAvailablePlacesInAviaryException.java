package main.java.Aviary;

public class NoAvailablePlacesInAviaryException extends Exception {
    public NoAvailablePlacesInAviaryException(String errorMessage) {
        super(errorMessage);
    }
}
