import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface ITranslator {
    String translate(String in) throws IllegalAccessException;

    void addTrans(String firstInput, String secondInput);

    public class TranslateImpl implements ITranslator {
        static private Map<String, String> dictionary = new HashMap<>();

        final Pattern p2 = Pattern.compile("[A-z]");
        final Pattern p3 = Pattern.compile("[А-я]");

        // Late init
        Matcher mp2;
        // Late init
        Matcher mp3;

        @Override
        public String translate(String in) {

            final String[] c = in.split("\\s*[\\W]*[\\W]");

            try {
                for (String s : c) {
                    firstException(s.toLowerCase());
                    in = in.replace(s, this.dictionary.get(s.toLowerCase()));
                }
                return in;

            } catch (Exception e) {
                System.err.println(e.getMessage());

            }
            return "";
        }

        @Override
        public void addTrans(String in1, String in2) {
            try {
                secondException(in1, in2);
                dictionary.put(in1.toLowerCase(), in2.toLowerCase());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }

        private void firstException(String in) throws IllegalAccessException {
            if (!dictionary.containsKey(in)) {
                throw new IllegalAccessException("There is no such word in the dictionary!!!");
            }
        }

        private void secondException(String in1, String in2) throws IllegalAccessException {
            if (in1.equals("") | in2.equals("")) {
                throw new IllegalAccessException("Is null!!!");
            }
            mp2 = p2.matcher(in1);
            if (!mp2.find()) {
                throw new IllegalAccessException("Not English!!!");
            }
            mp3 = p3.matcher(in2);
            if (!mp3.find()) {
                throw new IllegalAccessException("Not Ukranian!!!");
            }
        }


    }
}
