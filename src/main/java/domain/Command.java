package domain;

import java.util.Arrays;

public enum Command {
    ORDER("주문등록", 1),
    PAYMENT("결제하기", 2),
    EXIT("프로그램 종료", 3);

    private final String command;
    private final int number;

    Command(String command, int number) {
        this.command = command;
        this.number = number;
    }

    public static Command of(int number) {
        return Arrays.stream(values())
                .filter(command -> command.number == number)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("해당하는 명령이 존재하지 않습니다."));
    }
}
