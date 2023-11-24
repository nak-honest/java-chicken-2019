package domain.payment;

import domain.table.Table;

public class Payment {
    private final Table table;
    private final PaymentMethod paymentMethod;

    public Payment(final Table table, final PaymentMethod paymentMethod) {
        this.table = table;
        this.paymentMethod = paymentMethod;
    }
}
