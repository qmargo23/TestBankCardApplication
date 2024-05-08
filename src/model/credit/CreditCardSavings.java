package model.credit;

/**
 * Класс кредитной карты с накоплением в размере 0.005% от суммы пополнений
 */
public class CreditCardSavings extends CreditCard {
    private static final double THE_PERCENTAGE_OF_ACCUMULATION = 0.00005;
    private double savingsAccrued = 0;
    public CreditCardSavings(double balance) {
        super(balance);
    }

    @Override
    public void topUp(double amount) {
        double percent = amount * THE_PERCENTAGE_OF_ACCUMULATION;
        savingsAccrued += percent;
        super.topUp(amount + percent);
    }

    @Override
    public String getInfoAvailableFunds() {
        return "\n_Credit_Savings_Card_________________________________\n"
//                + "CreditLimit:     " + DEFAULT_CREDIT_LIMIT + "\n"
                + "AvailableSum:    " + getAvailableCredit() + "\n"
                + "CreditUsed:      " + getCreditUsed() + "\n"
                + "Balance:         " + getBalance() + "\n"
                + "TotalSavingsAccrued:   " + getSavingsAccrued() + "\n"
                + "_____________________________________________________\n"
                ;
    }

    public double getSavingsAccrued() {
        return savingsAccrued;
    }
}
