package com.myshop.order;

public enum OrderState {
    PAYMENT_WAITING {
        public boolean isShippingChangeable() {
            return true;
        }
    },
    SHIPPED;

    public boolean isShippingChangeable() {
        return false;
    }
}

