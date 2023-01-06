public class Main {
    public static final int COUNT = 100;
    public static final int BALANCE = 1000;

    public static void main(String[] args) throws Exception {
        final IBank.Bank b = new IBank.Bank(COUNT, BALANCE);
        for (int i = 0; i < COUNT; i++) {
            final Transfer transfer = new Transfer(b, BALANCE);
            final Thread thread = new Thread(transfer);
            thread.start();
        }
    }
}