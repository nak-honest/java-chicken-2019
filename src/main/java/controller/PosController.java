package controller;

import domain.Command;
import domain.Money;
import domain.menu.Menu;
import domain.menu.MenuRepository;
import domain.payment.PaymentMethod;
import domain.table.Table;
import domain.table.TableRepository;
import service.PaymentService;
import util.ExceptionRetryHandler;
import view.InputView;
import view.OutputView;

import java.util.List;

public class PosController {
    private final InputView inputView;
    private final OutputView outputView;
    private final PaymentService paymentService;

    public PosController(InputView inputView, OutputView outputView, PaymentService paymentService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.paymentService = paymentService;
    }

    public void run() {
        do {
            Command command = startMainScreen();
            if (command.equals(Command.EXIT)) {
                break;
            }

            process(command);
        } while (true);
    }

    private Command startMainScreen() {
        outputView.printMainScreen();
        int commandNumber = inputView.inputCommandNumber();

        return Command.of(commandNumber);
    }

    private void process(Command command) {
        if (command.equals(Command.ORDER)) {
            order();
            return;
        }

        payment();
    }

    private void order() {
        Table table = ExceptionRetryHandler.retryUntilValid(() -> selectTable());
        Menu menu = ExceptionRetryHandler.retryUntilValid(() -> selectMenu());
        ExceptionRetryHandler.retryUntilValid(() -> selectMenuCount(table, menu));
    }

    private Table selectTable() {
        outputView.printTables(TableRepository.tables());
        int tableNumber = inputView.inputTableNumber();

        return TableRepository.of(tableNumber);
    }

    private Menu selectMenu() {
        outputView.printMenus(MenuRepository.menus());
        int menuNumber = inputView.inputMenuNumber();

        return MenuRepository.of(menuNumber);
    }

    private void selectMenuCount(Table table, Menu menu) {
        int menuCount = inputView.inputMenuCount();
        table.order(menu, menuCount);
    }

    private void payment() {
        Table table = ExceptionRetryHandler.retryUntilValid(() -> selectTable());
        outputView.printOrderTable(table.getOrderMenus());
        outputView.printPaymentTableNumber(table.getNumber());

        PaymentMethod paymentMethod = ExceptionRetryHandler.retryUntilValid(() -> selectPaymentMethod());
        outputView.printPayment(paymentService.pay(table, paymentMethod).getAmount());
    }

    private PaymentMethod selectPaymentMethod() {
        int paymentMethod = inputView.inputPaymentMethod();

        return PaymentMethod.of(paymentMethod);
    }
}
