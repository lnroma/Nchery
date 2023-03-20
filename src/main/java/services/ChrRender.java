package services;

import javafx.scene.canvas.GraphicsContext;
import registries.GraphixContextRegistry;
import registries.sprites.SpritesSheet;

public class ChrRender {
    /**
     * redraw all
     */
    public void redrawAll() {
        GraphicsContext gcSprites =  GraphixContextRegistry.getSpritesGraphicsContext();
        GraphicsContext gcBackground = GraphixContextRegistry.getBackgroundGraphicsContext();

        DrawPage drawSprite = new DrawPage();
        drawSprite.drawPage(SpritesSheet.getPageOneAnimation(), gcSprites);
        drawSprite.drawPage(SpritesSheet.getPageTwoBackground(), gcBackground);

        DrawGreedInCanvas drawGreedInCanvas = new DrawGreedInCanvas();
        drawGreedInCanvas.drawGrid(gcSprites);
        drawGreedInCanvas.drawGrid(gcBackground);
    }
}
