package view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final InputView inputView = new InputView();

    private InputView() {}

    public static InputView getInstance() {
        return inputView;
    }

    public int inputCommandNumber() {
        System.out.println("## 원하는 기능을 선택하세요.");
        int command = scanner.nextInt();
        System.out.println();

        return command;
    }

    public int inputTableNumber() {
        System.out.println("## 테이블을 선택하세요.");
        int tableNumber = scanner.nextInt();
        System.out.println();

        return tableNumber;
    }

    public int inputMenuNumber() {
        System.out.println("## 등록할 메뉴를 선택하세요.");
        int menuNumber = scanner.nextInt();
        System.out.println();

        return menuNumber;
    }
}
