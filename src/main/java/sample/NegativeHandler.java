package sample;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;

import java.util.Optional;

public class NegativeHandler extends Handler {

    public static final int LOSS = 3;

    public NegativeHandler(Handler processor) {
        super(processor);
    }

    @Override
    public boolean process(Integer request) {
        if (request != LOSS) return super.process(request);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Проигрыш!");
        alert.setHeaderText("Монетка потеряна, но всегда можно отыграться!");

        ButtonType replay = new ButtonType("Продолжить лудку", ButtonBar.ButtonData.YES);
        ButtonType vacation = new ButtonType("Отдохнуть", ButtonBar.ButtonData.NO);
        alert.getButtonTypes().clear();
        alert.getButtonTypes().addAll(replay, vacation);
        Optional<ButtonType> option = alert.showAndWait();

        if (option.get().getButtonData() == ButtonBar.ButtonData.YES)
            return true;
        else
            return false;
    }
}
