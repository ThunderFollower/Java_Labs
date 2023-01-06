
import java.util.ArrayList;

public class AnotherShowImpl implements IShowService {
    @Override
    public void showJournal(ArrayList<JournalDataClass> journal) {
        for (JournalDataClass o : journal) {
            System.out.println("Name :"+o.name+
                    "\nSurname: "+ o.surname+
                    "\nBirthDate: "+ o.birthDate+
                    "\nAddress: "+o.address +
                    "\nPhone: "+ o.phone+
                    "\n------------------------");

        }
    }
}
