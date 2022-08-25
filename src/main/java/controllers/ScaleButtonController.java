package controllers;

import javafx.scene.control.Button;
import registries.controls.ButtonSizeScale;
import registries.variables.PixelSize;
import services.DrawGreedInCanvas;
import services.DrawSprite;

public class ScaleButtonController {
    public void control() {

        Button buttonMinus = ButtonSizeScale.getButtonMinus();
        Button buttonPlus = ButtonSizeScale.getButtonPlus();

        buttonMinus.setOnAction(e -> {
            int currentScale = PixelSize.getSizePixel();
            currentScale--;
            PixelSize.setSizePixel(currentScale);
            redrawAll();
        });

        buttonPlus.setOnAction(e -> {
            int currentScale = PixelSize.getSizePixel();
            currentScale++;
            PixelSize.setSizePixel(currentScale);
            redrawAll();
        });
    }

    /**
     * redraw all
     */
    public void redrawAll() {
        DrawSprite drawSprite = new DrawSprite();
        drawSprite.drawSpritesPageOne();

        DrawGreedInCanvas drawGreedInCanvas = new DrawGreedInCanvas();
        drawGreedInCanvas.drawGrid();
    }
}
