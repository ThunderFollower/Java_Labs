
import java.util.ArrayList;



public class JournalShowImpl implements IShowService {
    public void showJournal(ArrayList<JournalDataClass> journal) {
        for (JournalDataClass o : journal) {
            System.out.println(o);
        }
    }
}

