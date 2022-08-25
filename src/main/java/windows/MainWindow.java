package windows;

import javafx.css.CssMetaData;
import javafx.css.Styleable;
import javafx.css.StyleableProperty;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import registries.*;
import registries.controls.ButtonSizeScale;

public class MainWindow  {
    public void show() throws Exception {
        Stage stage = StageRegistry.getStage();

        stage.setTitle("NesDev chr editor");
        MenuBar menuBar = new MenuBar();

        Menu menu = new Menu("File");
        MenuItem menuOpen = new MenuItem("Open");
        MenuItem menuSave = new MenuItem("Save");
        MenuItem menuClose = new MenuItem("Close");

        menu.getItems().add(menuOpen);
        menu.getItems().add(menuSave);
        menu.getItems().add(menuClose);

        MenuRegister.setMenuClose(menuClose);
        MenuRegister.setMenuOpen(menuOpen);
        MenuRegister.setMenuSave(menuSave);

        menuBar.getMenus().add(menu);

        Canvas canvas = new Canvas(2000,2000);
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        GraphixContextRegistry.setGraphicsContext(graphicsContext);

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(canvas);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);

        GridPane vBox2 = new GridPane();
        ColorPicker colorOne = new ColorPicker(PaleteRegistry.getColorOne());
        ColorPicker colorTwo = new ColorPicker(PaleteRegistry.getColorTwo());
        ColorPicker colorThree = new ColorPicker(PaleteRegistry.getColorThree());
        ColorPicker colorFour = new ColorPicker(PaleteRegistry.getColorFour());

        Label labelScale = new Label("Scale");
        Button buttonMinus = new Button("-");
        Button buttonPlus = new Button("+");

        Label paleteLabel = new Label("Palete:");
        vBox2.add(paleteLabel, 0,0);
        vBox2.add(colorOne, 0,1);
        vBox2.add(colorTwo, 1,1);
        vBox2.add(colorThree, 2,1);
        vBox2.add(colorFour, 3,1);
        vBox2.add(labelScale, 0, 2);
        vBox2.add(buttonMinus, 1,2);
        vBox2.add(buttonPlus, 2,2);
        vBox2.setMinHeight(100.00);

        ButtonSizeScale.setButtonMinus(buttonMinus);
        ButtonSizeScale.setButtonPlus(buttonPlus);

        ColorChooserRegister.setColorPickerOne(colorOne);
        ColorChooserRegister.setColorPickerTwo(colorTwo);
        ColorChooserRegister.setColorPickerThree(colorThree);
        ColorChooserRegister.setColorPickerFour(colorFour);


        Tab tabSprites = new Tab("sprites");
        Tab tabBackground = new Tab("background");
        Tab tabCode = new Tab("code editor");

        tabSprites.setContent(scrollPane);

        TabPane tabPane = new TabPane(tabSprites, tabBackground, tabCode);


        VBox vBox = new VBox(menuBar);
        vBox.getChildren().add(vBox2);
        vBox.getChildren().add(tabPane);

        Scene scene = new Scene(vBox, 640, 480);
        stage.setScene(scene);
        stage.show();
    }
}
