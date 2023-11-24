package view;

import domain.menu.Menu;
import domain.table.Table;

import java.util.List;

public class OutputView {
    private static final String TOP_LINE = "┌ ─ ┐";
    private static final String TABLE_FORMAT = "| %s |";
    private static final String BOTTOM_LINE = "└ ─ ┘";

    private final Writer writer;

    public OutputView(final Writer writer) {
        this.writer = writer;
    }

    public void printMainScreen() {
        writer.writeLine("## 메인화면");
        writer.writeLine("1 - 주문등록");
        writer.writeLine("2 - 결제하기");
        writer.writeLine("3 - 프로그램 종료");
    }

    public void printTables(final List<Table> tables) {
        writer.writeLine("## 테이블 목록");
        final int size = tables.size();
        printLine(TOP_LINE, size);
        printTableNumbers(tables);
        printLine(BOTTOM_LINE, size);
    }

    public void printMenus(final List<Menu> menus) {
        for (final Menu menu : menus) {
            writer.writeLine(menu.toString());
        }
    }

    private void printLine(final String line, final int count) {
        for (int index = 0; index < count; index++) {
            writer.writeLine(line);
        }

        writer.writeLine("");
    }

    private void printTableNumbers(final List<Table> tables) {
        for (final Table table : tables) {
            writer.write(String.format(TABLE_FORMAT, table));
        }
        writer.writeLine("");
    }
}
