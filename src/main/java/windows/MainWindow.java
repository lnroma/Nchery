package windows;

import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import registries.*;
import registries.controls.ButtonSizeScale;
import windows.factories.grid.ColumnConstraintsFactory;
import windows.factories.menu.MenuFactory;
import windows.factories.menu.MenuItemFactory;
import windows.factories.pane.GridPaneFactory;
import windows.factories.scene.SceneFactory;
import windows.mainWindow.*;
import windows.mainWindow.MenuBar;
import windows.mainWindow.headTools.HeadTool;
import windows.states.elements.WindowState;

public class MainWindow  {
    private final BackgroundTab backgroundTab;
    private final NametableTab nametableTab;
    private final SpriteTab spriteTab;
    private final MenuBar menuBar;
    private final TabCode tabCode;
    private final HeadTool headTool;
    private final RightToolsPanel rightToolsPanel;
    private final ColumnConstraintsFactory columnConstraintsFactory;
    private final SceneFactory sceneFactory;
    private final GridPaneFactory gridPaneFactory;

    public MainWindow() {
        this.backgroundTab = new BackgroundTab();
        this.menuBar = new MenuBar();
        this.spriteTab = new SpriteTab();
        this.tabCode = new TabCode();
        this.headTool = new HeadTool();
        this.rightToolsPanel = new RightToolsPanel();
        this.columnConstraintsFactory = new ColumnConstraintsFactory();
        this.sceneFactory = new SceneFactory();
        this.gridPaneFactory = new GridPaneFactory();
        this.nametableTab = new NametableTab();
    }

    public void show() throws Exception {
        Stage stage = StageRegistry.getStage();

        stage.setTitle("NesDev chr editor");

        TabPane tabPane = new TabPane(
                this.spriteTab.getSpritesTab(),
                this.backgroundTab.getBackgroundTab(),
                this.nametableTab.getNameTableTab()
//                this.tabCode.getTabCode()
        );

        WindowState.setTabPane(tabPane);

//        tabPane.getStyleClass().add("tab-pane");

        VBox vBox = new VBox(
                menuBar.getMenuBar()
        );

        GridPane mainGridPane = this.gridPaneFactory.create();
        mainGridPane.add(this.headTool.getHeadTool(), 0, 0);
        mainGridPane.add(tabPane, 0, 1);
        mainGridPane.add(this.rightToolsPanel.renderRightPane(), 1, 0, 1,2);
        ColumnConstraints firstColumn = this.columnConstraintsFactory.create();
        ColumnConstraints secondColumn = this.columnConstraintsFactory.create();
        firstColumn.setPercentWidth(80);
        secondColumn.setPercentWidth(20);
        mainGridPane.getColumnConstraints().add(firstColumn);
        mainGridPane.getColumnConstraints().add(secondColumn);
//        mainGridPane.setGridLinesVisible(true);

        vBox.getChildren().add(mainGridPane);

        Scene scene = this.sceneFactory.create(vBox, 640, 480);
//        String windowCss = getClass().getResource("styles/window.css").toExternalForm();
//        scene.getStylesheets().add(windowCss);
        WindowState.setStage(stage);
        stage.setScene(scene);
        stage.show();
    }
}
