package debitOperations;

import model.debit.DebitCardBonus;

class DebitCardBonusOperations {
    public static void main(String[] args) {
        DebitCardBonus card = new DebitCardBonus(10);

        //пополнение
        card.topUp(10000);
        card.topUp(5000);
        //оплата +1%
        card.pay(10000);
        card.pay(10000);
        //баланс
        System.out.println("Balance:    " + card.getBalance());

        //Общая информация
        System.out.println(card.getInfoAvailableFunds());
    }
}
