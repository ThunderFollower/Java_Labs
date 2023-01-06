package main.java.Animal;

public class Animal {
    public String Name;
    public int Age;
    public String Breed;
    public String Gender;
    public Animal(String Name, int Age, String Breed, String Gender) {
        this.Name = Name;
        this.Age = Age;
        this.Breed = Breed;
        this.Gender = Gender;
    }

    @Override
    public String toString() {
        return String.format("%s (Age: %d, Breed: %s, Gender: %s)",
                this.Name,
                this.Age,
                this.Breed,
                this.Gender);
    }
}
