package domain;

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

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
