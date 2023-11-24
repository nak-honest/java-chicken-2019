package domain.table;

import domain.Money;
import domain.menu.Category;

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

    public Money calculateTotalPrice() {
        return orderMenus.calculateTotalPrice();
    }

    public int countMenuByCategory(Category category) {
        return orderMenus.countMenuByCategory(category);
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
