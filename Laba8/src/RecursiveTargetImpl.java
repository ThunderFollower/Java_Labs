import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;


public class RecursiveTargetImpl extends RecursiveTask<Integer> {
    private static final int THRESHOLD = 20;
    private final List<Integer> array;


    public RecursiveTargetImpl(List<Integer> arr) {
        this.array = arr;
    }

    @Override
    protected Integer compute() {
        if (array.size() > THRESHOLD) {
            return ForkJoinTask.invokeAll(createSubtasks()).stream().mapToInt(ForkJoinTask::join).sum();
        } else {
            return processing(array);
        }
    }

    private Collection<RecursiveTargetImpl> createSubtasks() {
        final List<RecursiveTargetImpl> dividedTasks = new ArrayList<>();
        final List<Integer> partOne = array.subList(0, array.size() / 2);
        final List<Integer> partTwo = array.subList(array.size() / 2, array.size());

        dividedTasks.add(new RecursiveTargetImpl(partOne));
        dividedTasks.add(new RecursiveTargetImpl(partTwo));

        return dividedTasks;
    }

    private Integer processing(List<Integer> arr) {
        System.out.println(arr);
        return arr.stream().mapToInt(Integer::intValue).sum();
    }
}


