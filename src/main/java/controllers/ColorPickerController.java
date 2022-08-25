package controllers;

import javafx.scene.control.ColorPicker;
import registries.ColorChooserRegister;
import registries.PaleteRegistry;
import services.DrawGreedInCanvas;
import services.DrawSprite;

public class ColorPickerController {
    public void control() {
        ColorPicker colorPickerOne = ColorChooserRegister.getColorPickerOne();
        ColorPicker colorPickerTwo = ColorChooserRegister.getColorPickerTwo();
        ColorPicker colorPickerThree = ColorChooserRegister.getColorPickerThree();
        ColorPicker colorPickerFour = ColorChooserRegister.getColorPickerFour();

        colorPickerOne.setOnAction(e -> {
            PaleteRegistry.setColorOne(colorPickerOne.getValue());
            reloadCanvas();
        });

        colorPickerTwo.setOnAction(e -> {
            PaleteRegistry.setColorTwo(colorPickerTwo.getValue());
            reloadCanvas();
        });

        colorPickerThree.setOnAction(e -> {
            PaleteRegistry.setColorThree(colorPickerThree.getValue());
            reloadCanvas();
        });

        colorPickerFour.setOnAction(e -> {
            PaleteRegistry.setColorFour(colorPickerFour.getValue());
            reloadCanvas();
        });
    }

    public void reloadCanvas() {
        DrawSprite drawSprite = new DrawSprite();
        drawSprite.drawSpritesPageOne();

        DrawGreedInCanvas drawGreedInCanvas = new DrawGreedInCanvas();
        drawGreedInCanvas.drawGrid();
    }
}
