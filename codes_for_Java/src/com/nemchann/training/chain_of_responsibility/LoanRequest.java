package com.nemchann.training.chain_of_responsibility;

public class LoanRequest {
    private final int amount;
    private final int creditStore; // от 0 до 5: 0 - плохо, 5 - отлична история
    private final String purpose;
    private boolean approved;
    private boolean rejected;
    private String rejectionReason;

    public LoanRequest(int amount, int creditStore, String purpose){
        this.amount = amount;
        this.creditStore = creditStore;
        this.purpose = purpose;
        this.approved = false;
        this.rejected = false;
    }

    public void approve() {
        this.approved = true;
        this.rejected = false;
    }

    public void reject(String rejectionReason){
        this.approved = false;
        this.rejected = true;
        this.rejectionReason = rejectionReason;
    }

    public boolean isRejected(){
        return rejected;
    }

    public int getAmount(){
        return amount;
    }

    public int getCreditStore() {
        return creditStore;
    }

    public String getPurpose() {
        return purpose;
    }

    public String getRejectionReason() {
        return rejectionReason;
    }
}
