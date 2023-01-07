import java.util.List;
import java.util.Random;
import java.util.concurrent.RecursiveTask;
import java.util.stream.IntStream;

public class Main {
    static final private int MAX_NUMBER = 100;

    public static void main(String[] args) {
        final List<Integer> list = IntStream.generate(() -> new Random().nextInt(MAX_NUMBER)).limit(MAX_NUMBER + 1).boxed().toList();
        final RecursiveTask recursiveTask = new RecursiveTargetImpl(list);
        System.out.println(((RecursiveTargetImpl) recursiveTask).compute());
    }
}