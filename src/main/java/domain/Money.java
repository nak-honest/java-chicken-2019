package domain;

import java.util.Objects;

public class Money {
    private static final int MIN_AMOUNT = 0;
    public static final Money ZERO_AMOUNT = new Money(0);

    private final int amount;

    public Money(final int amount) {
        validateAmount(amount);
        this.amount = amount;
    }

    private void validateAmount(final int amount) {
        if (amount < MIN_AMOUNT) {
            throw new IllegalArgumentException(String.format("금액은 %d원 이상이어야 합니다.", MIN_AMOUNT));
        }
    }

    public static Money zero() {
        return ZERO_AMOUNT;
    }

    public Money add(final Money money) {
        return new Money(amount + money.amount);
    }

    public Money multiply(final int count) {
        return new Money(amount * count);
    }

    @Override
    public String toString() {
        return Integer.toString(amount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Money)) {
            return false;
        }

        Money money = (Money) o;
        return amount == money.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }
}
