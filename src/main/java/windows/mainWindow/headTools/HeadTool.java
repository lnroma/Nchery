package windows.mainWindow.headTools;

import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import registries.ColorChooserRegister;
import registries.PaleteRegistry;
import registries.controls.ButtonSizeScale;

public class HeadTool {
    public GridPane getHeadTool() {
        Label labelScale = new Label("Scale");
        Button buttonMinus = new Button("-");
        Button buttonPlus = new Button("+");

        Label paleteLabel = new Label("Palete:");
        GridPane vBox2 = new GridPane();
        ColorPicker colorOne = new ColorPicker(PaleteRegistry.getColorOne());
        ColorPicker colorTwo = new ColorPicker(PaleteRegistry.getColorTwo());
        ColorPicker colorThree = new ColorPicker(PaleteRegistry.getColorThree());
        ColorPicker colorFour = new ColorPicker(PaleteRegistry.getColorFour());

        vBox2.add(paleteLabel, 0,0);
        vBox2.add(colorOne, 0,1);
        vBox2.add(colorTwo, 1,1);
        vBox2.add(colorThree, 2,1);
        vBox2.add(colorFour, 3,1);
        vBox2.add(labelScale, 0, 2);
        vBox2.add(buttonMinus, 1,2);
        vBox2.add(buttonPlus, 2,2);
        vBox2.setMinHeight(100.00);


        ColorChooserRegister.setColorPickerOne(colorOne);
        ColorChooserRegister.setColorPickerTwo(colorTwo);
        ColorChooserRegister.setColorPickerThree(colorThree);
        ColorChooserRegister.setColorPickerFour(colorFour);

        ButtonSizeScale.setButtonMinus(buttonMinus);
        ButtonSizeScale.setButtonPlus(buttonPlus);

        return vBox2;
    }
}
