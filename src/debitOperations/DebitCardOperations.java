package debitOperations;

import model.debit.DebitCard;

class DebitCardOperations {
    public static void main(String[] args) {
        DebitCard debitCard = new DebitCard(10000);

        //пополнение
        debitCard.topUp(1000);
        debitCard.topUp(2000);
        debitCard.topUp(3000);//16000
        //оплата
        debitCard.pay(10000);
        debitCard.pay(6000);//0
        boolean pay = debitCard.pay(1000);
        System.out.println(pay);

        //баланс проверка
        System.out.println("Balance:    " + debitCard.getBalance());

        //Общая информация
        System.out.println(debitCard.getInfoAvailableFunds());
    }
}
