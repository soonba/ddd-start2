package com.myshop.order;

public class Order {
    private OrderState orderState;
    private ShippingInfo shippingInfo;

    public void changeShippingInfo(ShippingInfo shippingInfo) {
        if (!isShippingChangeable()) {
            throw new IllegalStateException("dd");
        }
        this.shippingInfo = shippingInfo;
    }

    public void changeShipped(){}
    public void cancel() {}
    public void completePayment() {}


    public boolean isShippingChangeable() {
        return orderState == OrderState.PAYMENT_WAITING;
    }
}

