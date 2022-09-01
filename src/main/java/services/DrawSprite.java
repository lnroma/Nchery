package services;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import registries.GraphixContextRegistry;
import registries.PaleteRegistry;
import registries.sprites.SpritesSheet;
import registries.variables.PixelSize;

public class DrawSprite {

    private static final int size = PixelSize.getSizePixel();

    public void drawPage(int[][][][] page, GraphicsContext graphicsContext) {
        for (int x = 0; x < page.length; x++) {
            for (int y = 0; y < page[x].length; y++) {
                for (int xPoint = 0; xPoint < page[x][y].length; xPoint++) {
                    for (int yPoint = 0; yPoint < page[x][y][xPoint].length; yPoint++) {
                        int dataPoint = page[x][y][xPoint][yPoint];
                        int absoluteX = x*8*size + xPoint*size;
                        int absoluteY = y*8*size + yPoint*size;

                        Color pixelColor = getPixelColor(dataPoint);
                        drawPixel(absoluteX, absoluteY, pixelColor, graphicsContext);
                    }
                }
            }
        }
    }

    /**
     *
     * @param x
     * @param y
     * @param pixelColor
     */
    private void drawPixel(int x, int y, Color pixelColor, GraphicsContext gc) {
//        GraphicsContext gc = GraphixContextRegistry.getGraphicsContext();
        gc.setFill(pixelColor);
        gc.fillRect(x, y, size, size);
    }

    /**
     *
     * @param dataPoint
     * @return Color
     */
    private Color getPixelColor(int dataPoint) {
        Color currentColor = PaleteRegistry.getColorOne();
        if (dataPoint == 1) {
            currentColor = PaleteRegistry.getColorTwo();
        } else if (dataPoint == 2) {
            currentColor = PaleteRegistry.getColorThree();
        } else if (dataPoint == 3) {
            currentColor = PaleteRegistry.getColorFour();
        }

        return currentColor;
    }
}
