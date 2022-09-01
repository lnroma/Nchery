package services;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import registries.GraphixContextRegistry;
import registries.variables.PixelSize;

public class DrawGreedInCanvas {
    public void drawGrid(GraphicsContext gc) {
        for (int xIndex = 0; xIndex < 16; xIndex++) {
            int x = xIndex * PixelSize.getSizePixel() * 8;
//            GraphicsContext gc = GraphixContextRegistry.getGraphicsContext();
            gc.setFill(Color.BLACK);
            gc.fillRect(x, 0, 3, 16 * 8 * PixelSize.getSizePixel());
            gc.fillRect(0, x, 16 * 8 * PixelSize.getSizePixel(), 3);
        }
    }
}
