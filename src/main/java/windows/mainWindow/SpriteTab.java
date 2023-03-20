package windows.mainWindow;

import events.canvas.MouseClickOnSprite;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import registries.GraphixContextRegistry;
import windows.factories.canvas.CanvasFactory;
import windows.factories.pane.ScrollPaneFactory;
import windows.factories.tab.TabFactory;

public class SpriteTab {
    protected CanvasFactory canvasFactory;
    protected ScrollPaneFactory scrollPaneFactory;
    protected TabFactory tabFactory;

    protected MouseClickOnSprite mouseClickOnSprite;

    public SpriteTab() {
        this.scrollPaneFactory = new ScrollPaneFactory();
        this.canvasFactory = new CanvasFactory();
        this.tabFactory = new TabFactory();
        this.mouseClickOnSprite = new MouseClickOnSprite();
    }

    public Tab getSpritesTab() {
        Canvas canvas = this.canvasFactory.create();
        canvas.setWidth(2000);
        canvas.setHeight(2000);
        canvas.setOnMouseClicked(this.mouseClickOnSprite);

        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        GraphixContextRegistry.setSpritesGraphicsContext(graphicsContext);

        ScrollPane scrollPane = this.scrollPaneFactory.create();
        scrollPane.getStyleClass().add("window");
        scrollPane.setContent(canvas);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);

        Tab tabSprites = this.tabFactory.create("sprites");
        tabSprites.setContent(scrollPane);

        return tabSprites;
    }
}
