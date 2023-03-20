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

    public void drawGridNametable(GraphicsContext gc, int pixelSize) {
        for (int xIndex = 0; xIndex < 32; xIndex++) {
            int x = xIndex * pixelSize;
            gc.setFill(Color.GREEN);
            gc.fillRect(x, 0, 1, 32 * pixelSize);
            gc.fillRect(0, x, 32 * pixelSize, 1);
        }
    }

    public void drawGridAttributeTable(GraphicsContext gc) {
        for (int xIndex = 0; xIndex < 16; xIndex++) {
            int x = xIndex * 8;
            gc.setFill(Color.BLUE);
            gc.fillRect(x, 0, 3, 64 * 8);
            gc.fillRect(0, x, 64 * 8, 3);
        }
    }
}
