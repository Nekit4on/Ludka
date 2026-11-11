package sample;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;

import java.util.Optional;

public class ChanceHandler extends Handler {

    public static final int CHANCE = 2;

    public ChanceHandler(Handler processor) {
        super(processor);
    }

    @Override
    public boolean process(Integer request) {
        if (request != CHANCE) return super.process(request);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Вы проиграли!");
        alert.setHeaderText("Но судьба даёт вам шанс сыграть еще раз!");

        ButtonType prinyat = new ButtonType("Принять", ButtonBar.ButtonData.YES);
        ButtonType otkaz = new ButtonType("Не надо дядя", ButtonBar.ButtonData.NO);
        alert.getButtonTypes().clear();
        alert.getButtonTypes().addAll(prinyat, otkaz);
        Optional<ButtonType> option = alert.showAndWait();

        if (option.get().getButtonData() == ButtonBar.ButtonData.YES)
            return true;
        else
            return false;
    }
}
