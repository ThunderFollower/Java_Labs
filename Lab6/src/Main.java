import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IllegalAccessException {
        final Scanner scanner = new Scanner(System.in);
        final ITranslator.TranslateImpl translator = new ITranslator.TranslateImpl();

        // Not OOP code
        setupData(translator);
        menu(scanner, translator);

    }

    private static void menu(Scanner scanner, ITranslator trns) throws IllegalAccessException {
        label:
        while (true) {
            String command = scanner.nextLine();
            switch (command) {
                case ("Add") -> {
                    printer("Print english first! ");
                    trns.addTrans(scanner.nextLine(), scanner.nextLine());
                }
                case ("tr") -> {
                    printer(trns.translate(scanner.nextLine()));
                }
                case ("End") -> {
                    printer("End");
                    break label;
                }
            }

        }
    }

    private static void printer(String t) {
        System.out.println(t);
    }

    private static void setupData(ITranslator translator) {
        translator.addTrans("hello", "привіт");
        translator.addTrans("world", "cвіт");
        translator.addTrans("badger", "борсук");
        translator.addTrans("bat", " летюча миша");
        translator.addTrans("rat", "щур");
        translator.addTrans("deer", "борсук");
        translator.addTrans("fox", "лисиця");
        translator.addTrans("hedgehog", "їжак");

    }
}