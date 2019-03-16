package com.project.reloaded.zeus;

public class Database {
    private String UserId;
    private String Name;
    private String Email;
    private String PhoneNumber;
    private String Amount;


    public Database(String userId, String name, String email, String phoneNumber, String amount) {
        UserId = userId;
        Name = name;
        Email = email;
        PhoneNumber = phoneNumber;
        Amount = amount;
    }

    public String getUserId() {
        return UserId;
    }

    public String getName() {
        return Name;
    }

    public String getEmail() {
        return Email;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public String getAmount() {
        return Amount;
    }
}
