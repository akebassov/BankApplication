package bankaccountapp;

import java.util.concurrent.ThreadLocalRandom;

public class Savings extends Account {

    private int safetyDepositBoxID;
    private long safetyDepositBoxKey;


    public Savings(String name, String sSN , double balance) {
        super(name, sSN, balance);
        setSafetyDepositBox();
    }

    public void setSafetyDepositBox(){
        safetyDepositBoxID = ThreadLocalRandom.current().nextInt(100, 999);
        safetyDepositBoxKey = ThreadLocalRandom.current().nextInt(1000, 9999);
    }

    @Override
    public void setRate(){
        rate = getBaseRate() - .25;
    }
    @Override
    public void showInfo() {
        num = 1;
        super.showInfo();
        System.out.println("  Your savings account features: " + "\n    Safety Deposit Box ID: " + safetyDepositBoxID +
                            "\n    Safety Deposit Box Key: " + safetyDepositBoxKey);
    }



}
