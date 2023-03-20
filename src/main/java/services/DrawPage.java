package services;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import registries.PaleteRegistry;
import registries.variables.PixelSize;

public class DrawPage {
    protected DrawSprite drawSprite;
    public DrawPage() {
        this.drawSprite = new DrawSprite();
    }

    public void drawPage(int[][][][] page, GraphicsContext graphicsContext) {
        for (int x = 0; x < page.length; x++) {
            for (int y = 0; y < page[x].length; y++) {
                this.drawSprite.drawSprite(page[x][y], graphicsContext, x, y);
            }
        }
    }
}
