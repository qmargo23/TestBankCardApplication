package model.debit;

import model.BankCard;

/**
 * Класс, представляющий дебетовую карту.
 */
public class DebitCard extends BankCard {
    protected double balance;

    public DebitCard(double balance) {
        super(balance);
        this.balance = balance;
        System.out.println(getInfoAvailableFunds());
    }

    @Override
    public void topUp(double amount) {
        balance += amount;
        System.out.println("Balance after top-up:    " + balance);
    }

    @Override
    public boolean pay(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Balance after payment:   " + balance);
            return true;
        } else {
            System.out.println("Not enough funds to pay");
            return false;
        }
    }

    @Override
    public String getInfoAvailableFunds() {
        return "___________________________________\n"
                + "Debit_Card Balance:     " + getBalance() + "\n"
                + "___________________________________\n"
                ;
    }

    @Override
    public double getBalance() {
        return balance;
    }
}
