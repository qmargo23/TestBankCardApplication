package model.debit;

/**
 * Класс дебетовой карты "Накопление в размере 0.005% от суммы пополнений"
 */
public class DebitCardSavings extends DebitCard {
    private static final double THE_PERCENTAGE_OF_ACCUMULATION = 0.00005;
    private double savingsAccrued = 0;

    public DebitCardSavings(double balance) {
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
        return "_____________________________________________________\n"
                + "Debit_Savings_Card    Balance:               "
                + super.getBalance()
                + "\nDebit_Savings_Card    TotalSavingsAccrued:   "
                + getSavingsAccrued() + "\n"
                + "_____________________________________________________\n"
                ;
    }

    public double getSavingsAccrued() {
        return savingsAccrued;
    }
}
