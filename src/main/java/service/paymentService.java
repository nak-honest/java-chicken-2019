package service;

import domain.Money;
import domain.discount.CashDiscount;
import domain.discount.ChickenCountDiscount;
import domain.discount.OrderMenusDiscount;
import domain.payment.PaymentMethod;
import domain.table.Table;

public class PaymentService {
    private final OrderMenusDiscount orderMenusDiscount = new ChickenCountDiscount();
    private final CashDiscount cashDiscount = new CashDiscount();

    public Money pay(Table table, PaymentMethod paymentMethod) {
        Money fee = table.payment(orderMenusDiscount);

        return cashDiscount.discount(fee, paymentMethod);
    }
}
