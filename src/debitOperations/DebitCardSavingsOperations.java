package debitOperations;

import model.debit.DebitCardSavings;

class DebitCardSavingsOperations {
    public static void main(String[] args) {
        DebitCardSavings card = new DebitCardSavings(5000);

        //оплата
        card.pay(3000);
        card.pay(5000);//2000
        card.pay(2000);
        //пополнение
        card.topUp(100000);
        card.topUp(200000);

        //Общая информация
        System.out.println(card.getInfoAvailableFunds());
    }
}
