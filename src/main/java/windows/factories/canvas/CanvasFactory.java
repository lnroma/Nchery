package windows.factories.canvas;

import javafx.scene.canvas.Canvas;

public class CanvasFactory {
    public Canvas create(double weight, double height) {
        return new Canvas(weight, height);
    }

    public Canvas create() {
        return new Canvas();
    }
}
