package model.credit;

/**
 * Класс бонусной кредитной карты. Начисляются бонусы в размере 1% от покупок
 */
public class CreditCardBonus extends CreditCard {
    private static final double BONUS_RATE = 0.01;
    private double bonus = 0;

    public CreditCardBonus(double balance) {
        super(balance);
    }

    @Override
    public boolean pay(double amount) {
        boolean success = super.pay(amount);
        if (success) {
            double rate = amount * BONUS_RATE;// Расчёт бонус 1% от суммы оплаты
            bonus += rate;
            System.out.println("bonus = " + rate);
            return true;
        }
        return false;
    }

    public String getInfoAvailableFunds() {
        return "\n_Credit_Card_Bonus_________________\n"
//                + "CreditLimit:     " + DEFAULT_CREDIT_LIMIT + "\n"
                + "AvailableSum:    " + getAvailableCredit() + "\n"
                + "CreditUsed:      " + getCreditUsed() + "\n"
                + "Balance:         " + getBalance() + "\n"
                + "Bonus:           " + getBonus() + "\n"
                + "___________________________________\n"
                ;
    }

    public double getBonus() {
        return bonus;
    }
}
