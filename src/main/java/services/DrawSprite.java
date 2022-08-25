package services;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import registries.GraphixContextRegistry;
import registries.PaleteRegistry;
import registries.sprites.SpritesSheet;
import registries.variables.PixelSize;

public class DrawSprite {

    private static final int size = PixelSize.getSizePixel();

    public void drawSpritesPageOne() {
        int[][][][] pageOne = SpritesSheet.getPageOneAnimation();

        for (int x = 0; x < pageOne.length; x++) {
            for (int y = 0; y < pageOne[x].length; y++) {
                for (int xPoint = 0; xPoint < pageOne[x][y].length; xPoint++) {
                    for (int yPoint = 0; yPoint < pageOne[x][y][xPoint].length; yPoint++) {
                        int dataPoint = pageOne[x][y][xPoint][yPoint];
                        int absoluteX = x*8*size + xPoint*size;
                        int absoluteY = y*8*size + yPoint*size;

                        Color currentColor = PaleteRegistry.getColorOne();
                        if (dataPoint == 1) {
                            currentColor = PaleteRegistry.getColorTwo();
                        } else if (dataPoint == 2) {
                            currentColor = PaleteRegistry.getColorThree();
                        } else if (dataPoint == 3) {
                            currentColor = PaleteRegistry.getColorFour();
                        }

                        GraphicsContext gc = GraphixContextRegistry.getGraphicsContext();
                        gc.setFill(currentColor);
                        gc.fillRect(absoluteX, absoluteY, size, size);
                    }
                }
            }
        }
    }
}
