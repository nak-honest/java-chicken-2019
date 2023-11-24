package view;

import domain.menu.Menu;
import domain.table.Table;

import java.util.List;
import java.util.Map;

public class OutputView {
    private static final String TOP_LINE = "┌ ─ ┐";
    private static final String TABLE_FORMAT = "| %s |";
    private static final String BOTTOM_LINE_WITHOUT_ORDER = "└ ─ ┘";
    private static final String BOTTOM_LINE_WITH_ORDER = "└ ₩ ┘";

    private final Writer writer;

    public OutputView(final Writer writer) {
        this.writer = writer;
    }

    public void printMainScreen() {
        writer.writeLine("## 메인화면");
        writer.writeLine("1 - 주문등록");
        writer.writeLine("2 - 결제하기");
        writer.writeLine("3 - 프로그램 종료");
        writer.writeLine("");
    }

    public void printTables(final List<Table> tables) {
        writer.writeLine("## 테이블 목록");
        final int size = tables.size();
        printLine(TOP_LINE, size);
        printTableNumbers(tables);
    }

    public void printMenus(final List<Menu> menus) {
        for (final Menu menu : menus) {
            writer.writeLine(menu.toString());
        }

        writer.writeLine("");
    }

    private void printLine(final String line, final int count) {
        for (int index = 0; index < count; index++) {
            writer.write(line);
        }

        writer.writeLine("");
    }

    private void printTableNumbers(final List<Table> tables) {
        for (final Table table : tables) {
            writer.write(String.format(TABLE_FORMAT, table));
        }
        writer.writeLine("");

        for (final Table table : tables) {
            printBottomLine(table);
        }
        writer.writeLine("");
        writer.writeLine("");
    }

    private void printBottomLine(final Table table) {
        if (table.hasOrder()) {
            writer.write(BOTTOM_LINE_WITH_ORDER);
            return;
        }

        writer.write(BOTTOM_LINE_WITHOUT_ORDER);
    }

    public void printOrderTable(final Map<Menu, Integer> orderTable) {
        writer.writeLine("## 주문 내역");
        writer.writeLine("메뉴 수량 금액");

        orderTable.forEach((menu, count) ->
            writer.writeLine(String.format("%s %d %d", menu.getName(), count, menu.getPrice().getAmount()))
        );

        writer.writeLine("");
    }

    public void printPaymentTableNumber(final int number) {
        writer.writeLine(String.format("## %d번 테이블의 결제를 진행합니다.", number));
    }

    public void printPayment(final int fee) {
        writer.writeLine("## 최종 결제할 금액");
        writer.writeLine(String.format("%d원", fee));
        writer.writeLine("");
    }
}
