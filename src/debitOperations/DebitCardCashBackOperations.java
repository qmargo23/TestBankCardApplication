package debitOperations;

import model.debit.DebitCardCashBack;

class DebitCardCashBackOperations {
    public static void main(String[] args) {
        DebitCardCashBack card = new DebitCardCashBack(0);

        //пополнение
        card.topUp(15000);
        //оплата без кешбека
        card.pay(2000);
        //оплата покупка более 5000
        card.pay(10000);
        card.pay(10000);

        //Общая информация
        System.out.println(card.getInfoAvailableFunds());
    }
}
