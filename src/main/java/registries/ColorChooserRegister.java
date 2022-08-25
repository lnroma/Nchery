package registries;

import javafx.scene.control.ColorPicker;

public class ColorChooserRegister {

    protected static ColorPicker colorPickerOne;
    protected static ColorPicker colorPickerTwo;
    protected static ColorPicker colorPickerThree;
    protected static ColorPicker colorPickerFour;

    public static void setColorPickerFour(ColorPicker colorPickerFour) {
        ColorChooserRegister.colorPickerFour = colorPickerFour;
    }

    public static void setColorPickerOne(ColorPicker colorPickerOne) {
        ColorChooserRegister.colorPickerOne = colorPickerOne;
    }

    public static void setColorPickerThree(ColorPicker colorPickerThree) {
        ColorChooserRegister.colorPickerThree = colorPickerThree;
    }

    public static void setColorPickerTwo(ColorPicker colorPickerTwo) {
        ColorChooserRegister.colorPickerTwo = colorPickerTwo;
    }

    public static ColorPicker getColorPickerFour() {
        return colorPickerFour;
    }

    public static ColorPicker getColorPickerOne() {
        return colorPickerOne;
    }

    public static ColorPicker getColorPickerThree() {
        return colorPickerThree;
    }

    public static ColorPicker getColorPickerTwo() {
        return colorPickerTwo;
    }
}
