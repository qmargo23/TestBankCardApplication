package creditOperations;

import model.credit.CreditCard;

public class CreditCardOperations {
    public static void main(String[] args) {
        CreditCard card = new CreditCard(0);

        //пополнение
        card.topUp(5000);//AvailableSum after top-up:    15000.0
        //используем кредит
        card.pay(15000);//AvailableSum after payment:   0.0
        card.pay(1000);//Not enough funds to pay
        //пополнение
        card.topUp(5000);//AvailableSum after top-up:    5000.0
        card.topUp(6000);//AvailableSum after top-up:    11000.0
        //Общая информация
        System.out.println(card.getInfoAvailableFunds());
    }
}
