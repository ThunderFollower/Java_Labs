import java.util.Scanner;

public class Main {
    public static final String HARDCODED_CHANGE_OPTION = "hardcode";
    public static final String MANUAL_CHANGE_OPTION = "manual";

    public static void main(String[] args) throws Exception {
        final IPrintTargetService printer = new IPrintTargetService.Printer();
        final IReflectionService reflection = new IReflectionService.StringReflectionService(printer);

        final Scanner scanner = new Scanner(System.in);
        final String inputString = takeInputString(printer, scanner);
        changeStringValue(printer, reflection, scanner, inputString);
    }

    private static String takeInputString(IPrintTargetService printer, Scanner scanner) {
        printer.print("Choose how to create a String (" + HARDCODED_CHANGE_OPTION + "/" + MANUAL_CHANGE_OPTION + "): ");

        final String input = scanner.nextLine().trim();

        String inputString = "";
        if (input.equals(HARDCODED_CHANGE_OPTION)) {
            inputString = "Glory to Ukraine!";
        } else {
            printer.print("Write: ");
            inputString = scanner.nextLine().trim();
        }

        return inputString;
    }

    private static void changeStringValue(IPrintTargetService printer, IReflectionService reflection, Scanner scanner, String inputString) throws Exception {
        printer.print("Choose how to change a value (" + HARDCODED_CHANGE_OPTION + "/" + MANUAL_CHANGE_OPTION + "): ");
        final String stringToReplace = "Hello there ;)";
        final String input = scanner.nextLine().trim();

        if (input.equals(HARDCODED_CHANGE_OPTION)) {
            reflection.execute(inputString, stringToReplace);
        } else {
            printer.print("Write: ");
            final String changedString = scanner.nextLine().trim();
            reflection.execute(inputString, changedString);
        }
    }
}