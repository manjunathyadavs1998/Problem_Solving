package Threads;

public class BankAccount {

    int balance;

    public BankAccount(int amount) {
        this.balance = amount;
    }

    public boolean deduct(int money) {
        synchronized (this) {
            if (balance >= money) {
                balance -= money;
                return true;
            }
        }
        return false;
    }

    public int addMoney(int money) {
        synchronized (this) {
            balance += money;
        }
        return balance;
    }

    public void transfer(BankAccount target, int amount) {

        synchronized (this) {

            System.out.println(
                    Thread.currentThread().getName()
                            + " locked source account"
            );

            // Just to make the deadlock easier to reproduce
            sleep();

            synchronized (target) {

                System.out.println(
                        Thread.currentThread().getName()
                                + " locked target account"
                );

                this.balance -= amount;
                target.balance += amount;
            }
        }
    }

    private void sleep() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}