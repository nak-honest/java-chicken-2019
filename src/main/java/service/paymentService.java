package service;

import domain.Money;
import domain.discount.CashDiscount;
import domain.discount.ChickenCountDiscount;
import domain.payment.PaymentMethod;
import domain.table.Table;

public class paymentService {
    private final ChickenCountDiscount chickenCountDiscount = new ChickenCountDiscount();
    private final CashDiscount cashDiscount = new CashDiscount();

    public Money payment(Table table, PaymentMethod paymentMethod) {
        Money fee = table.calculateTotalPrice();
        fee = chickenCountDiscount.discount(fee, table);
        return cashDiscount.discount(fee, paymentMethod);
    }
}
