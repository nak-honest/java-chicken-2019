package domain.table;

import domain.Money;
import domain.discount.OrderMenusDiscount;

public class Table {
    private final int number;
    private final OrderMenus orderMenus;

    public Table(final int number) {
        this.number = number;
        this.orderMenus = new OrderMenus();
    }

    public boolean isNumber(int number) {
        return this.number == number;
    }

    public Money payment(OrderMenusDiscount orderMenusDiscount) {
        Money fee = orderMenus.calculateTotalPrice();
        fee = fee.minus(orderMenusDiscount.calculateDiscountAmount(orderMenus));
        orderMenus.clear();

        return fee;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
