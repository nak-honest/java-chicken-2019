package domain.discount;

import domain.Money;
import domain.table.OrderMenus;

public abstract class OrderMenusDiscount {
    public Money calculateDiscountAmount(OrderMenus orderMenus) {
        if (!isSatisfiedBy(orderMenus)) {
            return Money.zero();
        }

        return getDiscountAmount(orderMenus);
    }

    abstract protected boolean isSatisfiedBy(OrderMenus orderMenus);
    abstract protected Money getDiscountAmount(OrderMenus orderMenus);
}
