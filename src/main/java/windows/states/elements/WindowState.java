package windows.states.elements;

import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import windows.components.textEditor.ReachTextArea;

public class WindowState {

    protected static TextArea textAreaState;

    protected static Tab tabCode;
    protected static TabPane tabPane;
    protected static Stage stage;

    public static void setStage(Stage stage) {
        WindowState.stage = stage;
    }

    public static Stage getStage() {
        return stage;
    }

    public static void setTabPane(TabPane tabPane) {
        WindowState.tabPane = tabPane;
    }

    public static TabPane getTabPane() {
        return tabPane;
    }

    public static void setTabCode(Tab tabCode) {
        WindowState.tabCode = tabCode;
    }

    public static Tab getTabCode() {
        return tabCode;
    }

    public static void setTextAreaState(TextArea textAreaState) {
        WindowState.textAreaState = textAreaState;
    }

    public static TextArea getTextAreaState() {
        return textAreaState;
    }
}
