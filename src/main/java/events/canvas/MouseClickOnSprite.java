package events.canvas;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import registries.sprites.CurrentIndex;
import registries.sprites.GcForSprite;
import registries.sprites.SpritesForEditor;
import registries.sprites.SpritesSheet;
import services.DrawSprite;

public class MouseClickOnSprite implements EventHandler<MouseEvent> {
    @Override
    public void handle(MouseEvent event) {
        int xIndexSprite = (int) (event.getX()/40);
        int yIndexSprite = (int) (event.getY()/40);

        int[][][][] spritesSheet = SpritesSheet.getPageOneAnimation();
        int[][] currentSprite = spritesSheet[xIndexSprite][yIndexSprite];
        DrawSprite drawSprite = new DrawSprite();
        SpritesForEditor.setOneSprite(currentSprite);
        drawSprite.drawSprite(SpritesForEditor.getOneSprite(), GcForSprite.getGc(CurrentIndex.getCurrentIndex()));
    }
}
