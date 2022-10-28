package com.myshop.order;

public class Order {
    private OrderState orderState;
    private ShippingInfo shippingInfo;

    public void changeShippingInfo(ShippingInfo shippingInfo) {
        if (!orderState.isShippingChangeable()) {
            throw new IllegalStateException("dd");
        }
        this.shippingInfo = shippingInfo;
    }
}

