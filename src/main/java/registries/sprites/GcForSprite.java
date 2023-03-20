package registries.sprites;

import javafx.scene.canvas.GraphicsContext;

public class GcForSprite {

    protected static GraphicsContext[] gc = new GraphicsContext[8];

    public static void setGc(GraphicsContext gc, int index) {
        GcForSprite.gc[index] = gc;
    }

    public static GraphicsContext getGc(int index) {
        return gc[index];
    }
}
