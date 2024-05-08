package creditOperations;

import model.credit.CreditCardSavings;

public class CreditCardSavingsOperations {
    public static void main(String[] args) {
        CreditCardSavings card = new CreditCardSavings(0);

        //пополнение
        card.topUp(10000);//AvailableSum after top-up:    20000.5
        //используем кредит
        card.pay(15000.5);//AvailableSum after payment:   5000.0
        card.pay(1000);//AvailableSum after payment:   4000.0
        //пополнение
        card.topUp(10000);//AvailableSum after top-up:    14000.5

        //Общая информация
        System.out.println(card.getInfoAvailableFunds());
    }
}
