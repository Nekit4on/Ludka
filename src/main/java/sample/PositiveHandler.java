package sample;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;

import java.util.Optional;

public class PositiveHandler extends Handler {

    public static final int SUCCESS = 1;

    public static int vyigryshSumma = 0;

    public PositiveHandler(Handler processor) {
        super(processor);
    }

    @Override
    public boolean process(Integer request) {
        if (request != SUCCESS) return super.process(request);

        vyigryshSumma = (int) (Math.random() * 4) + 1;

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Вы победили!");
        alert.setHeaderText("Вам доступно " + vyigryshSumma + " monetok!");
        alert.setContentText("Шо делаем?");

        ButtonType zabrat = new ButtonType("Выводим", ButtonBar.ButtonData.NO);
        ButtonType igratDalshe = new ButtonType("Депаем дальше", ButtonBar.ButtonData.YES);
        alert.getButtonTypes().clear();
        alert.getButtonTypes().addAll(igratDalshe, zabrat);
        Optional<ButtonType> option = alert.showAndWait();

        return option.get().getButtonData() == ButtonBar.ButtonData.YES;
    }
}
