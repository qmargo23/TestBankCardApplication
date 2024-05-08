package model;

/**
 * Абстрактный класс, представляющий банковскую карту.
 */
public abstract class BankCard {

    protected double balance;

    public BankCard(double balance) {
        this.balance = balance;
    }

    /**
     * Пополняет карту на указанную сумму.
     *
     * @param amount сумма пополнения
     */
    public abstract void topUp(double amount);

    /**
     * Оплачивает указанную сумму с карты.
     *
     * @param amount сумма для оплаты
     * @return true, если оплата успешна, false в противном случае
     */
    public abstract boolean pay(double amount);

    /**
     * возвращает информацию о балансе, кредитном лимите и любых других средствах
     *
     * @return доступные средства
     */
    public abstract String getInfoAvailableFunds();

    /**
     * Возвращает текущий баланс карты.
     */
    public abstract double getBalance();

}
