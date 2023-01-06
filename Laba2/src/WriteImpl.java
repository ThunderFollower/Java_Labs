
import java.util.Scanner;

public class WriteImpl implements IWriteService {
    static final Scanner in = new Scanner(System.in);
    static final Checker checker = new Checker();

    @Override
    public String scanName() {
        System.out.println("Name:");
        return checker.validateNameSurname(in.nextLine());
    }

    @Override
    public String scanSurname() {
        System.out.println("Surname:");
        return checker.validateNameSurname(in.nextLine());
    }

    @Override
    public String scanBirthDate() {
        System.out.println("BirthDate: (Example: 2000-11-01)");
        return checker.validateData((in.nextLine()));
    }

    @Override
    public String scanPhone() {
        System.out.println("Phone:");
        return checker.validatePhone(in.nextLine());
    }

    @Override
    public String scanAddress() {
        System.out.println("Address:");
        return checker.validateAddress(in.nextLine());
    }


}



