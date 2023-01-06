abstract class IAccount {
    abstract String takeName();

    abstract void configureName(String name);

    abstract int takeBalance();

    abstract void configureBalance(int balance);

    public static class Account extends IAccount {
        String name;

        int balance;

        public Account(String name, int balance) {
            this.name = name;
            this.balance = balance;
        }

        @Override
        public String takeName() {
            return name;
        }

        public void configureName(String name) {
            this.name = name;
        }

        @Override
        public int takeBalance() {
            return balance;
        }

        @Override
        public void configureBalance(int balance) {
            this.balance = balance;
        }

        @Override
        public String toString() {
            return "Account{" + "name='" + name + '\'' + ", balance=" + balance + '}';
        }
    }

}

