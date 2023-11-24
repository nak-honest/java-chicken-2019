package domain;

import domain.table.OrderMenus;
import domain.menu.Category;
import domain.menu.Menu;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OrderMenusTest {
    @Test
    void 주어진_카테고리의_총_메뉴_개수를_계산할_수_있다() {
        Menu saladChicken = new Menu(1, "샐러드치킨", Category.CHICKEN, 18000);
        Menu friedChicken = new Menu(2, "후라이드치킨", Category.CHICKEN, 18000);
        Menu coke = new Menu(21, "콜라", Category.BEVERAGE, 1000);

        OrderMenus orderMenus = new OrderMenus();
        orderMenus.order(saladChicken, 3);
        orderMenus.order(friedChicken, 2);
        orderMenus.order(coke, 4);

        assertThat(orderMenus.countMenuByCategory(Category.CHICKEN)).isEqualTo(5);
    }
}
