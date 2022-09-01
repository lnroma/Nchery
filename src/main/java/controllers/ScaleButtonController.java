package controllers;

import javafx.scene.control.Button;
import registries.controls.ButtonSizeScale;
import registries.sprites.SpritesSheet;
import registries.variables.PixelSize;
import services.ChrRender;
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
            ChrRender chrRender = new ChrRender();
            chrRender.redrawAll();
        });

        buttonPlus.setOnAction(e -> {
            int currentScale = PixelSize.getSizePixel();
            currentScale++;
            PixelSize.setSizePixel(currentScale);
            ChrRender chrRender = new ChrRender();
            chrRender.redrawAll();
        });
    }
}
