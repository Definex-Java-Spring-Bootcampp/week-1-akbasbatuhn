package com.patika.onlinealisveris.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Bill {

    private BigDecimal totalAmount;
    private LocalDateTime issuedDate;
    private Order order; // order id?

    public Bill(Order order) {
        this.totalAmount = calculateBillPrice(order);
        this.issuedDate = LocalDateTime.now();
        this.order = order;
    }

    private BigDecimal calculateBillPrice(Order order) {
        if(order == null)
            return BigDecimal.ZERO;

        return order.calculateOrderTotalAmount();
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public LocalDateTime getIssuedDate() {
        return issuedDate;
    }

    public void setIssuedDate(LocalDateTime issuedDate) {
        this.issuedDate = issuedDate;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "totalAmount=" + totalAmount +
                ", issuedDate=" + issuedDate +
                ", order=" + order +
                '}';
    }
}
