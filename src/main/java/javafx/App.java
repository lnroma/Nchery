package javafx;

import controllers.ColorPickerController;
import controllers.FileOpenController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import registries.StageRegistry;
import services.ReadFileBytsAsString;
import states.FileChrOpen;
import windows.ChoseFileDialog;
import windows.MainWindow;

import java.io.IOException;
import java.nio.file.Path;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        StageRegistry.setStage(stage);

        MainWindow mainWindow = new MainWindow();
        try {
            mainWindow.show();
            runControllers();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void runControllers() {
        ColorPickerController colorPickerController = new ColorPickerController();
        colorPickerController.control();

        FileOpenController fileOpenController = new FileOpenController();
        fileOpenController.control();
    }

    public static void main(String[] args) {
        launch();
    }
}