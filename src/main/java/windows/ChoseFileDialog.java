package windows;

import javafx.stage.FileChooser;
import javafx.stage.Stage;
import registries.StageRegistry;

import java.io.File;

public class ChoseFileDialog {
    protected File openedFile;
    public void show() {
        Stage stage = StageRegistry.getStage();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open chr file");
        this.openedFile = fileChooser.showOpenDialog(stage);
    }

    public File getOpenedFile() {
        return this.openedFile;
    }
}
