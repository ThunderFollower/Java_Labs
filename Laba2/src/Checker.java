
import java.time.LocalDate;

import java.util.Scanner;

public class Checker {
    static private final Scanner in = new Scanner(System.in);
    static private final LocalDate today = LocalDate.now();

    public String validateNameSurname(String str) {

        if (str.equals("") || isNumeric(str)) {
            System.err.println("Please write normal value!");
        } else {
            return str;
        }
        str = in.nextLine();

        return validateNameSurname(str);

    }

    public String validatePhone(String str) {
        if (isPhone(str) || str.equals("")) {
            System.err.println("Please write normal value!");
        } else {
            return str;
        }
        str = in.nextLine();
        return validatePhone(str);

    }

    public String validateData(String str) {
        if (isDate(str) || str.equals("")) {
            System.err.println("Please write normal value!");

        } else {
            return str;
        }
        str = in.nextLine();
        return validateData(str);

    }
    public String validateAddress(String str) {
        if (isAddress(str) || str.equals("")) {
            System.err.println("Please write normal value!");

        } else {
            String[] s = str.split(",");
            return "\nStreet: "+ s[0]+"\nHouse: "+s[1]+"\nFlat: "+s[2];
        }
        str = in.nextLine();
        return validateAddress(str);

    }

    public boolean isNumeric(String string) {
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) < 'A' || string.charAt(i) > 'z') {
                return true;

            }
        }
        return false;
    }

    private boolean isPhone(String phone) {
        return (!phone.matches("\\+\\d{12}"));
    }

    private boolean isDate(String date) {
        String[] checkDate;
        int monthCheck;
        LocalDate todayMount ;
        if ((!date.matches("\\d{4}-\\d{1,2}-\\d{1,2}"))) {
            return true;
        } else {
            checkDate = date.split("-");
        }
        if (Integer.parseInt(checkDate[0]) < 1991 || Integer.parseInt(checkDate[0]) > today.getYear()) {
            return true;
        }
//        todayMount = LocalDate.of(Integer.parseInt(checkDate[0]),Integer.parseInt(checkDate[1]),Integer.parseInt(checkDate[2]));
        if (Integer.parseInt(checkDate[1]) > 12 || Integer.parseInt(checkDate[1]) < 1) {
            return true;
        }
        todayMount = LocalDate.of(Integer.parseInt(checkDate[0]),Integer.parseInt(checkDate[1]),2);

        monthCheck = todayMount.lengthOfMonth();
        if (Integer.parseInt(checkDate[2]) > monthCheck || Integer.parseInt(checkDate[2]) < 1) {
            return true;
        }
        return false;
    }

    private boolean isAddress(String address) {
       return (!address.matches("[A-Z]{2},\\d{4},[A-Z]{2}"));
    }

}






