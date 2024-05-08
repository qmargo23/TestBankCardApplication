package creditOperations;

import model.credit.CreditCardCashBack;

class CreditCardCashBackOperation {
    public static void main(String[] args) {
        CreditCardCashBack card = new CreditCardCashBack(0);

        //используем кредит
        card.pay(10000);//AvailableSum after payment:   0.0
                                //+500.0
        //пополнение
        card.topUp(10500);//AvailableSum after top-up:    11000.0

        //используем кредит
        card.pay(10000);//AvailableSum after payment:   1000.0
                                //+500
        card.pay(1500);//AvailableSum after payment:   0.0
        //Общая информация
        System.out.println(card.getInfoAvailableFunds());
    }
}