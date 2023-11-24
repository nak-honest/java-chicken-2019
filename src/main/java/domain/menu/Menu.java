package domain.menu;

import domain.Money;

public class Menu {
    private final int number;
    private final String name;
    private final Category category;
    private final Money price;

    public Menu(final int number, final String name, final Category category, final int price) {
        this.number = number;
        this.name = name;
        this.category = category;
        this.price = new Money(price);
    }

    public boolean isNumber(int number) {
        return this.number == number;
    }

    public boolean isCategory(Category category) {
        return this.category == category;
    }

    @Override
    public String toString() {
        return category + " " + number + " - " + name + " : " + price + "원";
    }

    public Money getPrice() {
        return price;
    }
}
