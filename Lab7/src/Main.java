
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.IntStream;


public class Main {
    static Map<Integer, Integer> result = new HashMap<>();

    public static void main(String[] args) {


        List<Integer> listWithSimpleNum;
        List<Integer> listWithNum;
        List<String> listWith2Num;


        listWithSimpleNum = ListWithSimpleNum(100);
        listWith2Num = ListWith2Num(listWithSimpleNum);
        listWithNum = ListWithNum(listWith2Num);

        Mapp(listWithSimpleNum, listWithNum);


    }

    public static List<Integer> ListWithSimpleNum(int n) {
        return IntStream.range(3, n)
                .filter(e -> ((Math.pow(2, e - 1) % e) == 1))
                .sorted()
                .mapToObj(Integer::toString)
                .map(Integer::parseInt)
                .toList();
    }

    public static List<String> ListWith2Num(List<Integer> listWithSimpleNum) {
        return listWithSimpleNum
                .stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public static List<Integer> ListWithNum(List<String> listWith2Num) {
        return listWith2Num
                .stream()
                .map(Integer::parseInt)
                .map(Main::plusNumber)
                .toList();
    }

    public static void Mapp(List<Integer> listKey, List<Integer> listValue) {
        int i = 1;
        result.put(2, 1);
        while (i < listValue.size()) {
            result.put(listKey.get(i), listValue.get(i));
            i++;

        }
        print(result);
    }

    public static Integer plusNumber(Integer n) {
        int sum = 0;
        while (n != 0) {
            sum += (n % 10);
            n /= 10;
        }

        return sum;
    }

    public static void print(Map<Integer, Integer> result) {

//        int maxx = result
//                .entrySet()
//                .stream()
//                .max(Map.Entry.comparingByValue())
//                .get()
//                .getValue();
        result
                .entrySet()
                .stream()
                .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
                .filter(c -> Objects.equals(c.getValue(), result
                        .entrySet()
                        .stream()
                        .max(Map.Entry.comparingByValue())
                        .get()
                        .getValue()))
                .forEach(System.out::println);
    }

}