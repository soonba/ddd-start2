package com.myshop.order;

public class Money {
    private final int won;

    public Money(int won) {
        this.won = won;
    }

    public int getWon() {
        return won;
    }

    public Money multiply(int quantity) {
        return new Money(won * quantity);
    }
}
