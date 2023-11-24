package domain.discount;

import domain.Money;
import domain.payment.PaymentMethod;

public class CashDiscount {
    private static final PaymentMethod DISCOUNT_METHOD = PaymentMethod.CASH;
    private static final double DISCOUNT_RATE = 0.95;

    public Money discount(Money fee, PaymentMethod paymentMethod) {
        if (!isSatisfied(paymentMethod)) {
            return fee;
        }

        return fee.multiply(DISCOUNT_RATE);
    }

    private boolean isSatisfied(PaymentMethod paymentMethod) {
        return paymentMethod.equals(DISCOUNT_METHOD);
    }
}
