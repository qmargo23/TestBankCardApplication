package model.debit;

/**
 * Класс бонусной дебетовой карты "Бонусные баллы в размере 1% от покупок"
 */
public class DebitCardBonus extends DebitCard {
    private double bonus = 0;

    public DebitCardBonus(double balance) {
        super(balance);
    }

    @Override
    public boolean pay(double amount) {
        boolean success = super.pay(amount);
        if (success) {
            bonus += amount * 1 / 100; // Расчёт бонус 1% от суммы оплаты
            return true;
        }
        return false;
    }

    @Override
    public String getInfoAvailableFunds() {
        return "___________________________________\n"
                + "Debit_Bonus_Card Balance:  "
                + super.getBalance()
                + "\nDebit_Bonus_Card Bonus:    "
                + getBonus() + "\n"
                + "___________________________________\n";
    }

    public double getBonus() {
        return bonus;
    }
}
