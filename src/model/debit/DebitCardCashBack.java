package model.debit;

/**
 * Класс бонусной дебетовой карты "Потенциальный кэшбэк 5%"
 * Потенциальный кешбэк 5% начисляется при условии трат больше 5 000 тыс
 */
public class DebitCardCashBack extends DebitCard {
    private static final double CASHBACK_THRESHOLD = 5000.0;
    private static final double CASHBACK_RATE = 0.05;
    private double cashbackAccrued = 0;


    public DebitCardCashBack(double balance) {
        super(balance);
    }

    @Override
    public boolean pay(double amount) {
        if (super.pay(amount)) {
            if (amount > CASHBACK_THRESHOLD) {
                double cashBack = amount * CASHBACK_RATE;// Расчёт кешбэк 5% от суммы оплаты более 5000 не включительно
                cashbackAccrued += cashBack;
                super.topUp(cashBack);
            }
            return true;
        }
        return false;
    }

    @Override
    public String getInfoAvailableFunds() {
        return "___________________________________\n"
                + "Debit_CashBack_Card Balance:         "
                + super.getBalance()
                + "\nDebit_CashBack_Card TotalCashBack:   "
                + getCashbackAccrued() + "\n"
                + "___________________________________\n"
                ;
    }

    public double getCashbackAccrued() {
        return cashbackAccrued;
    }
}
