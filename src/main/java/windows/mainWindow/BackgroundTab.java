package windows.mainWindow;

import javafx.scene.canvas.Canvas;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import registries.GraphixContextRegistry;

public class BackgroundTab {
    public Tab getBackgroundTab() {
        Tab tabBackground = new Tab("background");
        ScrollPane scrollPaneBackground = new ScrollPane();
        Canvas canvasBackground = new Canvas(2000, 2000);
        scrollPaneBackground.setContent(canvasBackground);
        scrollPaneBackground.setHbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        scrollPaneBackground.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        GraphixContextRegistry.setBackgroundGraphicsContext(canvasBackground.getGraphicsContext2D());
        tabBackground.setContent(scrollPaneBackground);

        return tabBackground;
    }
}
