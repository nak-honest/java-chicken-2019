package domain.table;

import domain.Money;
import domain.discount.OrderMenusDiscount;
import domain.menu.Menu;

import java.util.Map;

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

    public void order(Menu menu, int count) {
        orderMenus.order(menu, count);
    }

    public Money payment(OrderMenusDiscount orderMenusDiscount) {
        Money fee = orderMenus.calculateTotalPrice();
        fee = fee.minus(orderMenusDiscount.calculateDiscountAmount(orderMenus));
        orderMenus.clear();

        return fee;
    }

    public boolean hasOrder() {
        return orderMenus.hasOrder();
    }

    public Map<Menu, Integer> getOrderMenus() {
        return orderMenus.getMenus();
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }

    public int getNumber() {
        return number;
    }
}
