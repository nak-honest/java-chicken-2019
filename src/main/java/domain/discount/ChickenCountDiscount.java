package domain.discount;

import domain.Money;
import domain.menu.Category;
import domain.table.Table;

public class ChickenCountDiscount {
    private static final Category DISCOUNT_CATEGORY = Category.CHICKEN;
    private static final int DISCOUNT_UNIT_COUNT = 10;
    private static final Money DISCOUNT_AMOUNT = new Money(10_000);

    public Money discount(Money fee, Table table) {
        int chickenMenuCount = table.countMenuByCategory(DISCOUNT_CATEGORY);
        int discountCount = chickenMenuCount / DISCOUNT_UNIT_COUNT;

        return fee.minus(DISCOUNT_AMOUNT.multiply(discountCount));
    }
}
