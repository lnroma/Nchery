package registries.controls;

import javafx.scene.control.Button;

public class ButtonSizeScale {

    protected static Button buttonMinus;
    protected static Button buttonPlus;

    public static Button getButtonMinus() {
        return buttonMinus;
    }

    public static Button getButtonPlus() {
        return buttonPlus;
    }

    public static void setButtonMinus(Button buttonMinus) {
        ButtonSizeScale.buttonMinus = buttonMinus;
    }

    public static void setButtonPlus(Button buttonPlus) {
        ButtonSizeScale.buttonPlus = buttonPlus;
    }
}
