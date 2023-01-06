import java.util.concurrent.ThreadLocalRandom;

public class Transfer implements Runnable {
    private IBank.Bank bank;
    private int sum;

    public Transfer(IBank.Bank bank, int sum) {
        this.bank = bank;
        this.sum = sum;
    }

    @Override
    public void run() {
        try {
            bank.transfer(bank.takeAccNum().get(ThreadLocalRandom.current().nextInt(bank.takeAccNum().size())), bank.takeAccNum().get(ThreadLocalRandom.current().nextInt(bank.takeAccNum().size())), (int) (Math.random() * sum));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
