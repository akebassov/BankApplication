package bankaccountapp;

import java.util.concurrent.ThreadLocalRandom;

public class Checking extends Account {

    private long debitCardNumber;
    private int debitCardPIN;


    public Checking(String name, String sSN , double balance) {
        super(name, sSN, balance);
        setDebitCard();

    }

    public void setDebitCard(){
        debitCardNumber = ThreadLocalRandom.current().nextLong(100000000000l, 999999999999l);
        debitCardPIN = ThreadLocalRandom.current().nextInt(1000, 9999);
    }

    @Override
    public void setRate(){
        rate = getBaseRate() * .15;
    }

    @Override
    public void showInfo(){
        num = 2;
        super.showInfo();
        System.out.println("  Your Checking account features: " + "\n   Debit Card Number: " + debitCardNumber +
                "\n   Debit Card PIN: " + debitCardPIN);

    }


}
