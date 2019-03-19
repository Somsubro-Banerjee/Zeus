package com.project.reloaded.zeus;

public class MoneyDatabase {
    private String Balance;
    private String Userid;



    public MoneyDatabase(String balance, String userid) {
        Balance = balance;
        Userid = userid;
    }

    public String getBalance() {
        return Balance;
    }
    public String getUserid() {
        return Userid;
    }
}
