package domain;

import java.util.HashMap;
import java.util.Map;

public class OrderMenus {
    private static final int MAX_COUNT = 99;

    private final Map<Menu, Integer> menus;

    public OrderMenus() {
        this.menus = new HashMap<>();
    }

    public void order(final Menu menu, final int count) {
        validateMenuCount(menu, count);
        menus.merge(menu, count, Integer::sum);
    }

    private void validateMenuCount(final Menu menu, final int count) {
        if (accumulatedMenuCount(menu) + count > MAX_COUNT) {
            throw new IllegalArgumentException("한 메뉴의 최대 주문 가능 수량은 " + MAX_COUNT + "개 입니다.");
        }
    }

    private int accumulatedMenuCount(final Menu menu) {
        return menus.getOrDefault(menu, 0);
    }

    public Money calculateTotalPrice() {
        return menus.entrySet().stream()
                .map(entry -> calculateMenuPrice(entry.getKey(), entry.getValue()))
                .reduce(Money.zero(), Money::add);
    }

    private Money calculateMenuPrice(final Menu menu, final int count) {
        Money menuPrice = menu.getPrice();

        return menuPrice.multiply(count);
    }

    public int countMenuByCategory(Category category) {
        return menus.entrySet().stream()
                .filter(entry -> entry.getKey().isCategory(category))
                .mapToInt(Map.Entry::getValue)
                .sum();
    }
}
