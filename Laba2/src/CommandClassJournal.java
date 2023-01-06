import java.util.ArrayList;

public class CommandClassJournal {
    private IAdditionService commandAdd;
    private IShowService commandShow;

    public CommandClassJournal(IAdditionService command, IShowService commandShow) {
        this.commandAdd = command;
        this.commandShow = commandShow;
    }

    public void addCom(ArrayList<JournalDataClass> jrnl, WriteDB wrt) {
        commandAdd.execute(jrnl, wrt);
        System.out.println("New note add\n------------------");
    }

    public void showCom(ArrayList<JournalDataClass> jrnl) {
        commandShow.showJournal(jrnl);
        System.out.println("List size journal is: " + jrnl.size() + "\n------------------");

    }

    public void listAllCommand() {
        System.out.println("All command: \n 1.ListCom \n 2.Add\n 3.Show \n 4.End \n------------------");
    }

    public void stopCommand() {
        System.out.println("Stop program\n------------------");

    }
}
