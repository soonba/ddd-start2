package com.myshop.order;

import java.util.List;

public class Order {

    private String orderNumber;
    private List<OrderLine> orderLines;
    private ShippingInfo shippingInfo;
    private Money totalAmounts;
    private OrderState orderState;

    public Order(List<OrderLine> orderLines, ShippingInfo shippingInfo) {
        setOrderLines(orderLines);
        setShippingInfo(shippingInfo);
    }

    private void setShippingInfo(ShippingInfo shippingInfo) {
        if(shippingInfo == null) {
            throw new IllegalArgumentException("배송 정보가 존재하지 않습니다.");
        }
        this.shippingInfo = shippingInfo;
    }

    private void setOrderLines(List<OrderLine> orderLines) {
        verifyAtLeastOneOrMoreOrderLines(orderLines);
        this.orderLines = orderLines;
        calculateTotalAmounts();
    }

    private void verifyAtLeastOneOrMoreOrderLines(List<OrderLine> orderLines) {
        if(orderLines.isEmpty()) {
            throw new IllegalArgumentException("주문 목록이 존재하지 않습니다.");
        }
    }

    private void calculateTotalAmounts() {
        int sum = orderLines.stream()
                .mapToInt(OrderLine::getAmounts)
                .sum();
        this.totalAmounts = new Money(sum);
    }

    public void cancel() {
        verifyNotYetShipped();
        orderState = OrderState.CANCELED;
    }
    public void changeShippingInfo(ShippingInfo shippingInfo) {
        verifyNotYetShipped();
        this.shippingInfo = shippingInfo;
    }

    private void verifyNotYetShipped() {
        if(!(orderState.equals(OrderState.PAYMENT_WAITING) || orderState.equals(OrderState.PREPARING))) {
            throw new IllegalArgumentException("수정 불가능한 상태");
        }

    }
    public void changeShipped(){}
    public void completePayment() {}

}

