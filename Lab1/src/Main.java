import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final ISimpleNumberService.SimpleNumberService service = new ISimpleNumberService.SimpleNumberService();
        final int input = service.fetchConsoleInput();
        System.out.println("You entered: " + input);
        final ArrayList<Integer> primeNumbersList = service.fetchPrimeNumbersList(input);
        final ArrayList<Integer> superPrimeNumbersList = service.fetchSuperPrimesFormList(primeNumbersList);
        service.printNumbersAmount(superPrimeNumbersList);
    }
}

abstract class ISimpleNumberService {
    private static int START_OF_THE_SEQUENCE = 2;
    private static int MAXIMUM_NUMBER_LIMIT = 1000;

    abstract public int fetchConsoleInput();

    abstract public void printNumbersAmount(ArrayList<Integer> numbers);

    abstract ArrayList<Integer> fetchPrimeNumbersList(int number);

    abstract ArrayList<Integer> fetchSuperPrimesFormList(List<Integer> primeNumbers);

    public static class SimpleNumberService extends ISimpleNumberService {
        @Override
        public int fetchConsoleInput() {
            final Scanner scanner = new Scanner(System.in);
            int input = 0;
            try {
                System.out.print("Enter number (n < " + MAXIMUM_NUMBER_LIMIT +"): ");
                input = scanner.nextInt();

                if (input > MAXIMUM_NUMBER_LIMIT) {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Incorrect input!");
                System.exit(1);
            }
            scanner.close();

            return input;
        }

        @Override
        public ArrayList<Integer> fetchPrimeNumbersList(int number) {
            final ArrayList<Integer> result = new ArrayList<>();
            for (int i = START_OF_THE_SEQUENCE; i < number; i++) {
                if (isPrime(i)) {
                    result.add(i);
                }
            }
            return result;
        }

        @Override
        public ArrayList<Integer> fetchSuperPrimesFormList(List<Integer> primeNumbers) {
            final ArrayList<Integer> result = new ArrayList<>();
            System.out.print("\nSuper Prime numbers: ");
            for (int i = 0; i < primeNumbers.size(); i++) {
                final int start = primeNumbers.get(i) % 10;
                final int end = primeNumbers.get(i) - start * 10;
                final int actualNumber = start * 10 + end;
//                System.out.println("Actual number" + actualNumber);
                if (isPrime(actualNumber)) {
                    System.out.print(actualNumber + ", ");
                    result.add(actualNumber);
                }
            }
            return result;
        }

        private static boolean isPrime(Integer number) {
            final BigInteger bigInt = BigInteger.valueOf(number);
            return bigInt.isProbablePrime((int) Math.log(number));
        }

        @Override
        public void printNumbersAmount(ArrayList<Integer> numbers) {
            final int amount = numbers.size();
            System.out.println("\nAmount of super prime numbers is: " + amount);
        }
    }
}
