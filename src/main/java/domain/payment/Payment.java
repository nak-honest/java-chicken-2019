package domain.payment;

import domain.Money;
import domain.table.Table;

public class Payment {
    private final Table table;
    private final PaymentMethod paymentMethod;
    private final Money fee;

    public Payment(final Table table, final PaymentMethod paymentMethod) {
        this.table = table;
        this.paymentMethod = paymentMethod;
    }

    public boolean isPaymentMethod(PaymentMethod paymentMethod) {
        return paymentMethod.equals(this.paymentMethod);
    }
}
