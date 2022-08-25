package registries;

import javafx.scene.canvas.GraphicsContext;

public class GraphixContextRegistry {
    protected static GraphicsContext currentGraphicsContext;

    public static void setGraphicsContext(GraphicsContext graphicsContext) {
        currentGraphicsContext = graphicsContext;
    }

    public static GraphicsContext getGraphicsContext() {
        return currentGraphicsContext;
    }

}
