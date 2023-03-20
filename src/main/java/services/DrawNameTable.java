package services;

import javafx.scene.canvas.GraphicsContext;
import registries.NameTableRegister;
import registries.sprites.SpritesSheet;

public class DrawNameTable {

    private final DrawSprite drawSprite;

    public DrawNameTable() {
        drawSprite = new DrawSprite();
    }

    public void DrawTable(GraphicsContext gc) {
        int[][][][] sprites = SpritesSheet.getPageOneAnimation();
        int[][][] nametable = NameTableRegister.getNameTableSheet();
        for (int y = 0; y < 32; y++) {
            for (int x = 0; x < 32; x++) {
                int[] tail = nametable[y][x];
//                int[] tail = nametable[x][y];
                int xSprite = tail[0];
                int ySprite = tail[1];
                int[][] sprite = sprites[xSprite][ySprite];
//                int [][] sprite = sprites[ySprite][xSprite];
                this.drawSprite.drawSprite(sprite, gc, y, x, 2);
            }
        }
    }
}
