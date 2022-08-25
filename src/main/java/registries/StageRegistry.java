package registries;

public class StageRegistry {

    protected static javafx.stage.Stage currentStage;

    public static void setStage(javafx.stage.Stage stage) {
        currentStage = stage;
    }

    public static javafx.stage.Stage getStage() {
        return currentStage;
    }
}
