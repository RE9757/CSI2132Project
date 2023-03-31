package sql;

import java.util.Date;

public class Payment {

    private Integer Payment_ID;

    private Integer Amount;

    private Date Date;
    private String PaymentMethod;

    public Payment(Integer Payment_ID, Integer Amount, Date Date, String PaymentMethod){
        this.Payment_ID = Payment_ID;
        this.Amount = Amount;
        this.Date = Date;
        this.PaymentMethod = PaymentMethod;
    }

    public Integer getPayment_ID() {
        return Payment_ID;
    }

    public Integer getAmount() {
        return Amount;
    }

    public Date getDate() {
        return Date;
    }

    public String getPaymentMethod() {
        return PaymentMethod;
    }

    public void setPayment_ID(Integer payment_ID) {
        Payment_ID = payment_ID;
    }

    public void setAmount(Integer amount) {
        Amount = amount;
    }

    public void setDate(java.util.Date date) {
        Date = date;
    }

    public void setPaymentMethod(String paymentMethod) {
        PaymentMethod = paymentMethod;
    }

    @Override
    public String toString() {
        return "<ul>"
                + "<li>Payment_ID= " + Payment_ID + "</li>"
                + "<li>Amount= " + Amount + "</li>"
                + "<li>Date= " + Date + "</li>"
                + "<li>PaymentMethod= " + PaymentMethod + "</li>";
    }
}
