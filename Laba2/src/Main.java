
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<JournalDataClass> jrnl = new ArrayList<>();
        Scanner scn = new Scanner(System.in);
        WriteDB wrt = new WriteDB(new WriteImpl());
        CommandClassJournal ccj = new CommandClassJournal(new JournalImpl(), new JournalShowImpl());
        execute(scn, jrnl, wrt, ccj);
    }
    private static void execute
            (Scanner scn,
             ArrayList<JournalDataClass> jrnl,
             WriteDB db,
             CommandClassJournal ccj) {
        ccj.listAllCommand();
        label:
        while (true) {
            String command = scn.nextLine();
            switch (command) {
                case "Commands" -> ccj.listAllCommand();
                case "Add note" -> ccj.addCom(jrnl, db);
                case "Show notes" -> ccj.showCom(jrnl);
                case "End" -> {
                    ccj.stopCommand();
                    break label;
                }
            }
        }
    }
}
