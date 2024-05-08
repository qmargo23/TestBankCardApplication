package model.credit;

import model.BankCard;

/**
 * Класс, представляющий кредитную карту.
 */
public class CreditCard extends BankCard {
    private static final double DEFAULT_CREDIT_LIMIT = 10000.0; // Константа для кредитного лимита по умолчанию
    private double creditUsed = 0;//Кредитные средства
    protected double balance;//Собственные средства

    public CreditCard(double balance) {
        super(balance);
        this.balance = balance;
        System.out.println(getInfoAvailableFunds());
    }

    @Override
    public void topUp(double amount) {
        double remainingAmount = amount;
        if (creditUsed > 0) {
            double amountToPayDebt = Math.min(remainingAmount, creditUsed);
            creditUsed -= amountToPayDebt;
            remainingAmount -= amountToPayDebt;
        }
        balance += remainingAmount;
        System.out.println("AvailableSum after top-up:    " + getAvailableCredit());
    }

    @Override
    public boolean pay(double amount) {
        if (amount <= getAvailableCredit()) {
            if (balance >= amount) {
                balance -= amount;
            } else {
                double debtAmount = amount - balance;
                balance = 0;
                creditUsed += debtAmount;
            }
            System.out.println("AvailableSum after payment:   " + getAvailableCredit());
            return true;
        } else {
            System.out.println("Not enough funds to pay");
            return false;
        }
    }

    public String getInfoAvailableFunds() {
        return "\n_Credit_Card_________________________\n"
//                + "CreditLimit:     " + DEFAULT_CREDIT_LIMIT + "\n"
                + "AvailableSum:    " + getAvailableCredit() + "\n"
                + "CreditUsed:      " + getCreditUsed() + "\n"
                + "Balance:         " + getBalance() + "\n"
                + "___________________________________\n"
                ;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    public double getCreditUsed() {
        return creditUsed;
    }
    /**
     * Возвращает доступный кредитный лимит.
     *
     * @return доступный кредитный лимит
     */
    public double getAvailableCredit() {
        return balance + (DEFAULT_CREDIT_LIMIT - creditUsed);
    }
}
