package javafx;

import controllers.ColorPickerController;
import controllers.FileNewController;
import controllers.FileOpenController;
import controllers.NameTableOpenController;
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
    public void start(Stage stage) throws Exception {
        StageRegistry.setStage(stage);

        MainWindow mainWindow = new MainWindow();

        //try {
            mainWindow.show();
            runControllers();
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
    }

    public void runControllers() {
        ColorPickerController colorPickerController = new ColorPickerController();
        colorPickerController.control();

        FileOpenController fileOpenController = new FileOpenController();
        fileOpenController.control();

        FileNewController fileNewController = new FileNewController();
        fileNewController.control();

        NameTableOpenController nameTableOpenController = new NameTableOpenController();
        nameTableOpenController.control();
    }

    public static void main(String[] args) {
        launch();
    }
}