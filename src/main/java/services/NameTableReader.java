package services;

import javafx.scene.canvas.GraphicsContext;
import registries.GraphixContextRegistry;
import registries.sprites.SpritesSheet;

public class NameTableReader {

    /**
     * redraw all
     */
    public void drawNameTable() {
        GraphicsContext nametableTabContext =  GraphixContextRegistry.getNametableTabContext();

//        DrawPage drawSprite = new DrawPage();
//        drawSprite.drawPage(SpritesSheet.getPageOneAnimation(), gcSprites);
//        drawSprite.drawPage(SpritesSheet.getPageTwoBackground(), gcBackground);
        DrawNameTable drawNameTable = new DrawNameTable();
        drawNameTable.DrawTable(nametableTabContext);
        DrawGreedInCanvas drawGreedInCanvas = new DrawGreedInCanvas();
        drawGreedInCanvas.drawGridNametable(nametableTabContext, 16);
//        drawGreedInCanvas.drawGridAttributeTable(nametableTabContext);
//        drawGreedInCanvas.drawGrid(gcBackground);
    }
}
