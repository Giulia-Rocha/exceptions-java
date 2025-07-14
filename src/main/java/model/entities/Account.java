package model.entities;

import model.exceptions.OutOfLimitException;

public class Account {
    private int number;
    private String holder;
    private double  balance;
    private double withdrawLimit;

    public Account(int number, String holder, double balance, double withdrawLimit) {
        this.number = number;
        this.holder = holder;
        this.balance = balance;
        this.withdrawLimit = withdrawLimit;
    }

    public void deposit(double amount){
        balance += amount;
    }
    public void withdraw(double amount){
        if(balance <= amount || withdrawLimit <= amount){
            throw new OutOfLimitException("Does not have enough money or limit");
        }
        balance -= amount;
    }

    @Override
    public String toString() {
        return "Account{" +
                "number =" + number +
                ", holder ='" + holder + '\'' +
                ", balance =" + balance +

                '}';
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getWithdrawLimit() {
        return withdrawLimit;
    }

    public void setWithdrawLimit(double withdrawLimit) {
        this.withdrawLimit = withdrawLimit;
    }


}
