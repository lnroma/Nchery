package windows;

import events.MouseDraggedHandler;
import events.MouseHandler;
import javafx.css.CssMetaData;
import javafx.css.Styleable;
import javafx.css.StyleableProperty;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import registries.*;
import registries.controls.ButtonSizeScale;
import windows.mainWindow.RightToolsPanel;

public class MainWindow  {
    public void show() throws Exception {
        Stage stage = StageRegistry.getStage();

        stage.setTitle("NesDev chr editor");

        TabPane tabPane = new TabPane(
                getSpritesTab(),
                getBackgroundTab(),
                getTabCode()
        );

        tabPane.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                double x = event.getX();
            }
        });

        VBox vBox = new VBox(
                getMenuBar()
        );

        RightToolsPanel rightToolsPanel = new RightToolsPanel();
        GridPane mainGridPane = new GridPane();
        mainGridPane.add(getHeadTool(), 0, 0);
        mainGridPane.add(tabPane, 0, 1);
        mainGridPane.add(rightToolsPanel.renderRightPane(), 1, 0, 1,2);
        ColumnConstraints firstColumn = new ColumnConstraints();
        ColumnConstraints secondColumn = new ColumnConstraints();
        firstColumn.setPercentWidth(80);
        secondColumn.setPercentWidth(20);
        mainGridPane.getColumnConstraints().add(firstColumn);
        mainGridPane.getColumnConstraints().add(secondColumn);

        mainGridPane.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                double x = event.getX();
            }
        });
        mainGridPane.setGridLinesVisible(true);

        vBox.getChildren().add(mainGridPane);

        Pane pane = new Pane();
        pane.setOnMouseMoved(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                double x = event.getX();
            }
        });

        Scene scene = new Scene(vBox, 640, 480);
        vBox.setOnMouseDragEntered(new MouseHandler());
        vBox.setOnMouseDragged(new MouseDraggedHandler());
        scene.setOnMouseMoved(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                double x = event.getX();
            }
        });

        stage.setScene(scene);
        stage.show();
    }

    private MenuBar getMenuBar() {
        MenuBar menuBar = new MenuBar();

        Menu menu = new Menu("File");
        MenuItem menuOpen = new MenuItem("Open");
        MenuItem menuSave = new MenuItem("Save");
        MenuItem menuClose = new MenuItem("Close");

        Menu menuSettings = new Menu("Settings");
        MenuItem language = new MenuItem("Language");

        menu.getItems().add(menuOpen);
        menu.getItems().add(menuSave);
        menu.getItems().add(menuClose);

        MenuRegister.setMenuClose(menuClose);
        MenuRegister.setMenuOpen(menuOpen);
        MenuRegister.setMenuSave(menuSave);

        menuBar.getMenus().add(menu);

        return menuBar;
    }

    private Tab getTabCode() {
        Tab tabCode = new Tab("code editor");
        return tabCode;
    }

    private Tab getSpritesTab() {
        Canvas canvas = new Canvas(2000,2000);
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        GraphixContextRegistry.setSpritesGraphicsContext(graphicsContext);
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(canvas);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        Tab tabSprites = new Tab("sprites");
        tabSprites.setContent(scrollPane);

        return tabSprites;
    }

    private Tab getBackgroundTab() {
        Tab tabBackground = new Tab("background");
        ScrollPane scrollPaneBackground = new ScrollPane();
        Canvas canvasBackground = new Canvas(2000, 2000);
        scrollPaneBackground.setContent(canvasBackground);
        scrollPaneBackground.setHbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        scrollPaneBackground.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        GraphixContextRegistry.setBackgroundGraphicsContext(canvasBackground.getGraphicsContext2D());
        tabBackground.setContent(scrollPaneBackground);

        return tabBackground;
    }

    private GridPane getHeadTool() {
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
