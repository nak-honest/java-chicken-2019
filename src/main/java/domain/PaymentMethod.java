package domain;

import java.util.Arrays;

public enum PaymentMethod {
    CARD("신용 카드", 1),
    CASH("현금", 2);

    private final String name;
    private final int number;

    PaymentMethod(final String name, final int number) {
        this.name = name;
        this.number = number;
    }

    public static PaymentMethod of(int number) {
        return Arrays.stream(PaymentMethod.values())
                .filter(paymentMethod -> paymentMethod.number == number)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("해당 번호의 결제 수단이 존재하지 않습니다."));
    }
}
