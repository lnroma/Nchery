package controllers;

import javafx.scene.control.ColorPicker;
import registries.ColorChooserRegister;
import registries.PaleteRegistry;
import registries.sprites.SpritesSheet;
import services.ChrRender;
import services.DrawGreedInCanvas;
import services.DrawSprite;

public class ColorPickerController {
    public void control() {
        ColorPicker colorPickerOne = ColorChooserRegister.getColorPickerOne();
        ColorPicker colorPickerTwo = ColorChooserRegister.getColorPickerTwo();
        ColorPicker colorPickerThree = ColorChooserRegister.getColorPickerThree();
        ColorPicker colorPickerFour = ColorChooserRegister.getColorPickerFour();
        ChrRender chrRender = new ChrRender();

        colorPickerOne.setOnAction(e -> {
            PaleteRegistry.setColorOne(colorPickerOne.getValue());
            chrRender.redrawAll();
        });

        colorPickerTwo.setOnAction(e -> {
            PaleteRegistry.setColorTwo(colorPickerTwo.getValue());
            chrRender.redrawAll();
        });

        colorPickerThree.setOnAction(e -> {
            PaleteRegistry.setColorThree(colorPickerThree.getValue());
            chrRender.redrawAll();
        });

        colorPickerFour.setOnAction(e -> {
            PaleteRegistry.setColorFour(colorPickerFour.getValue());
            chrRender.redrawAll();
        });
    }
}
