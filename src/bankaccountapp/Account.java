package bankaccountapp;

import java.util.concurrent.ThreadLocalRandom;

public abstract class Account implements IBaseRate {

    private String name;
    private String sSN;
    private double balance;
    private static int index = 10000;
    protected String accountNumber;
    protected double rate;

    public Account(String name, String sSN, double balance) {
        this.name = name;
        this.sSN = sSN;
        this.balance = balance;
        index++;
        this.accountNumber = setAccountNumber();
        setRate();
    }

    private String setAccountNumber() {
        String lastTwoOfSSN = sSN.substring(sSN.length() - 2);
        int uniqueID = index;
        int randomNumber = ThreadLocalRandom.current().nextInt(100,999);
        return lastTwoOfSSN + uniqueID + randomNumber;
    }

    public abstract void setRate();

    public void deposit(double amount){
        balance = balance + amount;
        System.out.println("Depositing: $" + amount);
        printBalance();
    }

    public void withdraw(double amount) {
        balance = balance - amount;
        System.out.println("Withdrawing: $" + amount);
        printBalance();
    }

    public void tranfer(String toWhere, double amount){
        balance = balance - amount;
        System.out.println("Transfering: $ " + amount + " to " + toWhere);
        printBalance();
    }

    public void compound(){
        double accruedInterest = balance * (rate/100);
        System.out.println("Accurued Interest: $" + accruedInterest);
        balance = balance + accruedInterest;
        printBalance();
    }

    public void printBalance(){
        System.out.println("Your balance is now: $" + balance);
    }

    String str = "\nACCOUNT NUMBER: %s";
    int num = 0;
    public void showInfo() {
        System.out.println("*************"  + "\nNAME: " + name + String.format(str, num) + accountNumber +
                            "\nBALANCE: $" + balance + "\nRATE: " + rate + "%");

    }

}
