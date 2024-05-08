package creditOperations;

import model.credit.CreditCardBonus;

class CreditCardBonusOperations {
    public static void main(String[] args) {
        CreditCardBonus card = new CreditCardBonus(0);

        //пополнение
        card.topUp(5000);//AvailableSum after top-up:    15000.0
        //используем кредит//
        card.pay(15000);//AvailableSum after payment:   0.0,
                                //bonus = 150.0
        card.pay(1000);//Not enough funds to pay
        //пополнение
        card.topUp(25000);//AvailableSum after top-up:    25000.0
        //используем кредит
        card.pay(16000);//AvailableSum after payment:   9000.0
                                //bonus = 160.0
        //Общая информация
        System.out.println(card.getInfoAvailableFunds());
    }
}