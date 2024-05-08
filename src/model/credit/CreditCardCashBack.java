package model.credit;

/**
 * Класс кредитной карты с потенциальным кешбэком.
 * Начисляется кешбэк 5% от покупок при условии покупки больше 5 000 (Пять тысяч) у.е.
 */
public class CreditCardCashBack extends CreditCard {
    private static final double CASHBACK_THRESHOLD = 5000.0;
    private static final double CASHBACK_RATE = 0.05;
    private double cashbackAccrued = 0;

    public CreditCardCashBack(double balance) {
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
        return "\n_Credit_CashBack_Card______________\n"
//                + "CreditLimit:     " + DEFAULT_CREDIT_LIMIT + "\n"
                + "AvailableSum:    " + getAvailableCredit() + "\n"
                + "CreditUsed:      " + getCreditUsed() + "\n"
                + "Balance:         " + getBalance() + "\n"
                + "TotalCashBack:   " + getCashbackAccrued() + "\n"
                + "___________________________________\n"
                ;
    }

    public double getCashbackAccrued() {
        return cashbackAccrued;
    }
}
