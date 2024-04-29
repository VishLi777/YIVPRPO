package com.example.demo.Pr7;

public class Card {

    private String number;
    private String cvv;
    private String date;
    private Long amount;

    public Card(String number, String cvv, String date, Long amount) {
        this.number = number;
        this.cvv = cvv;
        this.date = date;
        this.amount = amount;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }
}
