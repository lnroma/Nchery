package registries;

import javafx.scene.canvas.GraphicsContext;

public class GraphixContextRegistry {
    protected static GraphicsContext spritesGraphicsContext;
    protected static GraphicsContext backgroundGraphicsContext;
    protected static GraphicsContext nametableTab;

    public static void setBackgroundGraphicsContext(GraphicsContext backgroundGraphicsContext) {
        GraphixContextRegistry.backgroundGraphicsContext = backgroundGraphicsContext;
    }

    public static void setSpritesGraphicsContext(GraphicsContext spritesGraphicsContext) {
        GraphixContextRegistry.spritesGraphicsContext = spritesGraphicsContext;
    }

    public static void setNametableTabContext(GraphicsContext nametableTabContext) {
        GraphixContextRegistry.nametableTab = nametableTabContext;
    }

    public static GraphicsContext getBackgroundGraphicsContext() {
        return backgroundGraphicsContext;
    }

    public static GraphicsContext getSpritesGraphicsContext() {
        return spritesGraphicsContext;
    }
    public static GraphicsContext getNametableTabContext() { return nametableTab; }
}
