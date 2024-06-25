package com.example.cd.dto;

public class DonationDTO {
    private String donorName;
    private String donorProfession;  
    private double amount;

    public String getDonorName() {
        return donorName;
    }

    public void setDonorName(String donorName) {
        this.donorName = donorName;
    }

    public String getDonorProfession() {
        return donorProfession;
    }

    public void setDonorProfession(String donorProfession) {
        this.donorProfession = donorProfession;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}