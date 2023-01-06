import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

abstract class IBank {

    abstract void transfer(IAccount.Account from, IAccount.Account to, int amount) throws Exception;

    abstract int allBankBalance();

    abstract void configureAccNum(List<IAccount.Account> accNum);

    abstract List<IAccount.Account> takeAccNum();

    public static class Bank extends IBank {
        private List<IAccount.Account> accNum = new ArrayList<>();
        private int BankBalance;
        private Condition condition;
        private Lock block;
        final static private int ran = 1_000_000;


        public Bank(int numAcc, int Balance) {
            for (int i = 0; i < numAcc; i++) {
                accNum.add(new IAccount.Account(("" + i), Balance));
            }
            block = new ReentrantLock();
            condition = block.newCondition();


        }

        @Override
        public void transfer(IAccount.Account from, IAccount.Account to, int amount) throws Exception {
            block.lock();
            try {
                while (from.takeBalance() < amount) {
                    condition.await();
                }
                from.configureBalance(from.takeBalance() - amount);
                to.configureBalance(to.takeBalance() + amount);
                System.out.println("From: " + from);
                System.out.println("To: " + to);
                System.out.println("AllBankBalance: " + allBankBalance());
                System.out.println("-------------------------------------------------------------------------------------------");
                condition.signalAll();

            } finally {
                block.unlock();
            }
        }

        @Override
        public int allBankBalance() {
            block.lock();
            try {
                BankBalance = accNum
                        .stream()
                        .parallel()
                        .mapToInt(IAccount.Account::takeBalance)
                        .sum();
            } finally {
                block.unlock();
            }
            return BankBalance;
        }

        @Override
        public List<IAccount.Account> takeAccNum() {
            return accNum;
        }

        @Override
        public void configureAccNum(List<IAccount.Account> accNum) {
            this.accNum = accNum;
        }
    }
}

