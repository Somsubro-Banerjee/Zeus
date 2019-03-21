package com.project.reloaded.zeus;

public class MoneyDatabase {
    private String Balance;
    private String Userid;
    private String Email;


    public MoneyDatabase(String balance, String userid, String email) {
        Balance = balance;
        Userid = userid;
        Email = email;
    }

    public String getBalance() {
        return Balance;
    }
    public String getUserid() {
        return Userid;
    }
    public String getEmail() { return Email; }
}
