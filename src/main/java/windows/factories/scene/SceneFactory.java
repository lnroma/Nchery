package windows.factories.scene;

import javafx.scene.Parent;
import javafx.scene.Scene;

public class SceneFactory {
    public Scene create(Parent node, double weight, double height) {
        return new Scene(node, weight, height);
    }
}
