package test.java;

import main.java.Animal.*;
import main.java.Aviary.*;
import main.java.Zoo;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class ZooTest {
    @Test
    public void testNoAvailablePlacesInAviaryException() {
        assertThrows(NoAvailablePlacesInAviaryException.class, () -> {
            final BirdAviary<Bird> birdAviary = new BirdAviary<Bird>(100.00, 1);
            birdAviary.Add(new Bird("testBird_1", 3, "testBreed", "male"));
            birdAviary.Add(new Bird("testBird_2", 4, "testBreed", "male"));
        });
    }

    @Test
    public void testAnimalWasNotFoundInAviaryException() {
        assertThrows(AnimalWasNotFoundInAviaryException.class, () -> {
            final BirdAviary<Bird> birdAviary = new BirdAviary<Bird>(100.00, 1);
            birdAviary.Add(new Bird("testBird_1", 3, "testBreed", "male"));
            birdAviary.Delete(new Bird("testBird_2", 4, "testBreed", "male"));
        });
    }

    @Test
    public void testAddToAviary() {
        assertDoesNotThrow(() -> {
            final BirdAviary<Bird> birdAviary = new BirdAviary<Bird>(100.00, 2);
            birdAviary.Add(new Bird("testBird_1", 3, "testBreed", "male"));
            birdAviary.Add(new Bird("testBird_2", 4, "testBreed", "male"));

            final MammalAviary<Mammal> mammalAviary = new MammalAviary<Mammal>(150.00, 4);
            mammalAviary.Add(new Giraffe("testGiraffe_1", 3, "testBreed", "male"));
            mammalAviary.Add(new Lion("testLion_2", 5, "testBreed", "male"));
            mammalAviary.Add(new Zebra("testZebra_3", 4, "testBreed", "female"));
            mammalAviary.Add(new Giraffe("testGiraffe_4", 4, "testBreed", "female"));

            HoofedAviary<Hoofed> hoofedAviary = new HoofedAviary<>(100.00, 3);
            hoofedAviary.Add(new Giraffe("testHoofed_1", 3, "testBreed", "male"));
            hoofedAviary.Add(new Zebra("testZebra_2", 4, "testBreed", "female"));
            hoofedAviary.Add(new Giraffe("testGiraffe_3", 4, "testBreed", "male"));

            LionAviary<Lion> lionAviary = new LionAviary<>(100.00, 1);
            lionAviary.Add(new Lion("testLion_1", 5, "testBreed", "male"));
        });
    }

    @Test
    public void testDeleteFromAviary() throws NoAvailablePlacesInAviaryException, AnimalWasNotFoundInAviaryException {
        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        final HoofedAviary<Hoofed> hoofedAviary = new HoofedAviary<>(100.00, 3);
        final Zebra testZebra_2 = new Zebra("testZebra_2", 4, "testBreed", "female");
        String consoleOutput = String.format("%s %s has been set free",
                testZebra_2.getClass().getSimpleName(),
                testZebra_2);
        //assertDoesNotThrow(() -> {
        hoofedAviary.Add(new Giraffe("testHoofed_1", 3, "testBreed", "male"));
        hoofedAviary.Add(testZebra_2);
        hoofedAviary.Add(new Giraffe("testGiraffe_3", 4, "testBreed", "male"));

        hoofedAviary.Delete(testZebra_2);
        //    });

        assertEquals(consoleOutput, out.toString());
    }

    @Test
    public void testGetCountOfAnimals() throws NoAvailablePlacesInAviaryException {
        final Zoo testZoo = new Zoo();
        BirdAviary<Bird> birdAviary = new BirdAviary<Bird>(100.00, 2);
        birdAviary.Add(new Bird("testBird_1", 3, "testBreed", "male"));
        birdAviary.Add(new Bird("testBird_2", 4, "testBreed", "male"));
        testZoo.addCage(birdAviary);

        final MammalAviary<Mammal> mammalAviary = new MammalAviary<Mammal>(150.00, 4);
        mammalAviary.Add(new Giraffe("testGiraffe_1", 3, "testBreed", "male"));
        mammalAviary.Add(new Lion("testLion_2", 5, "testBreed", "male"));
        mammalAviary.Add(new Zebra("testZebra_3", 4, "testBreed", "female"));
        mammalAviary.Add(new Giraffe("testGiraffe_4", 4, "testBreed", "female"));
        testZoo.addCage(mammalAviary);

        final HoofedAviary<Hoofed> hoofedAviary = new HoofedAviary<>(100.00, 3);
        hoofedAviary.Add(new Giraffe("testHoofed_1", 3, "testBreed", "male"));
        hoofedAviary.Add(new Zebra("testZebra_2", 4, "testBreed", "female"));
        hoofedAviary.Add(new Giraffe("testGiraffe_3", 4, "testBreed", "male"));
        testZoo.addCage(hoofedAviary);

        final LionAviary<Lion> lionAviary = new LionAviary<>(100.00, 1);
        lionAviary.Add(new Lion("testLion_1", 5, "testBreed", "male"));
        testZoo.addCage(lionAviary);

        assertEquals(10, testZoo.getCountOfAnimals());
    }
}
