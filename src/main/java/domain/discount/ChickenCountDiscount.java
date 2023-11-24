package domain.discount;

import domain.Money;
import domain.menu.Category;
import domain.table.OrderMenus;

public class ChickenCountDiscount extends OrderMenusDiscount {
    private static final Category DISCOUNT_CATEGORY = Category.CHICKEN;
    private static final int DISCOUNT_UNIT_COUNT = 10;
    private static final Money DISCOUNT_AMOUNT = new Money(10_000);

    @Override
    protected boolean isSatisfiedBy(OrderMenus orderMenus) {
        return orderMenus.countMenuByCategory(DISCOUNT_CATEGORY) >= DISCOUNT_UNIT_COUNT;
    }

    @Override
    protected Money getDiscountAmount(OrderMenus orderMenus) {
        int discountCount = orderMenus.countMenuByCategory(DISCOUNT_CATEGORY) / DISCOUNT_UNIT_COUNT;

        return DISCOUNT_AMOUNT.multiply(discountCount);
    }
}
