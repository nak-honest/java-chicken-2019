package domain;

import java.util.HashMap;
import java.util.Map;

public class OrderMenus {
    private static final int MAX_COUNT = 99;

    private final Map<Menu, Integer> menus;

    public OrderMenus() {
        this.menus = new HashMap<>();
    }

    public void add(final Menu menu, final int count) {
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
}
