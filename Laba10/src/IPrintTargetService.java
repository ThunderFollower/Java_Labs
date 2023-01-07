public interface IPrintTargetService {
    public void print(Object o);

    public class Printer implements IPrintTargetService {
        @Override
        public void print(Object object) {
            System.out.print(object);
        }
    }
}
