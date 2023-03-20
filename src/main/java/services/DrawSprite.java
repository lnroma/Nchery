package services;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import registries.PaleteRegistry;
import registries.variables.PixelSize;

public class DrawSprite {

    private static final int size = PixelSize.getSizePixel();

    public void drawSprite(int[][] sprite, GraphicsContext gc, int x, int y) {
        this.draw(sprite, gc, x, y);
    }

    public void drawSprite(int[][] sprite, GraphicsContext gc, int x, int y, int pixelSize) {
        this.draw(sprite, gc, x, y, pixelSize);
    }

    public void drawSprite(int[][] sprite, GraphicsContext gc) {
        this.draw(sprite, gc, 0, 0);
    }

    private void draw(int[][] sprite, GraphicsContext gc, int x, int y) {
        draw(sprite, gc, x, y, size);
    }

    private void draw(int[][] sprite, GraphicsContext gc, int x, int y, int pixelSize) {
        for (int xPoint = 0; xPoint < sprite.length; xPoint++) {
            for (int yPoint = 0; yPoint < sprite[xPoint].length; yPoint++) {
                int dataPoint = sprite[xPoint][yPoint];
                int absoluteX = x*8*pixelSize + xPoint*pixelSize;
                int absoluteY = y*8*pixelSize + yPoint*pixelSize;

                Color pixelColor = getPixelColor(dataPoint);
                drawPixel(absoluteX, absoluteY, pixelColor, gc);
            }
        }
    }

    private void drawPixel(int x, int y, Color pixelColor, GraphicsContext gc) {
        gc.setFill(pixelColor);
        gc.fillRect(x, y, size, size);
    }

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
