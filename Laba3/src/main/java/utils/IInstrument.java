package main.java.utils;

import java.util.Scanner;

public interface IInstrument {
    public String changeColorForString(String color, String output);

    public int inputIntInRange(int lowerBorder, int uppedBorder);

    public static class Instrument implements IInstrument {
        @Override
        public String changeColorForString(String color, String output) {
            String colorReset = "\033[0m";
            String colorIdentifier = "\033[0m";
            switch (color) {
                case "black":
                    colorIdentifier = "\033[0;30m";
                    break;
                case "red":
                    colorIdentifier = "\033[0;31m";
                    break;
                case "green":
                    colorIdentifier = "\033[0;32m";
                    break;
                case "yellow":
                    colorIdentifier = "\033[0;33m";
                    break;
                case "blue":
                    colorIdentifier = "\033[0;34m";
                    break;
                case "purple":
                    colorIdentifier = "\033[0;35m";
                    break;
                case "cyan":
                    colorIdentifier = "\033[0;36m";
                    break;
                case "white":
                    colorIdentifier = "\033[0;37m";
                    break;
                default:
                    break;
            }
            return colorIdentifier + output + colorReset;
        }

        @Override
        public int inputIntInRange(int lowerBorder, int uppedBorder) {
            Scanner reader = new Scanner(System.in);
            boolean checkInput;
            int input;
            do {
                checkInput = true;
                System.out.print("Enter int in range " + lowerBorder + " to " + uppedBorder + ": ");
                while (!reader.hasNextInt()) {
                    System.out.print("That's not a number! Try again: ");
                    reader.next();
                }
                input = reader.nextInt();
                if (input < lowerBorder || input > uppedBorder) {
                    checkInput = false;
                }
            } while (!checkInput);


            return input;
        }
    }

}

