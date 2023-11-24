import controller.PosController;
import domain.table.Table;
import domain.menu.Menu;
import domain.menu.MenuRepository;
import domain.table.TableRepository;
import service.PaymentService;
import view.InputView;
import view.OutputView;
import view.Writer;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        Writer writer = new Writer(System.out::print, System.out::println);
        OutputView outputView = new OutputView(writer);
        InputView inputView = InputView.getInstance();
        PaymentService paymentService = new PaymentService();

        PosController posController = new PosController(inputView, outputView, paymentService);
        posController.run();
    }
}
