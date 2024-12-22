package com.api.pojo;

public class PurchaseUnits {

    private String reference_id;
    private Amount amount;
    public PurchaseUnits(String reference_id, String currency_code, String value) {
        this.reference_id = reference_id;
        this.amount = new Amount(currency_code,value);
    }

    public Amount getAmount() {
        return amount;
    }

    /*public void setAmount(Amount amount) {
        this.amount = amount;
    }*/

    public String getReference_id() {
        return reference_id;
    }

    /*public void setReference_id(String reference_id) {
        this.reference_id = reference_id;
    }*/
}
