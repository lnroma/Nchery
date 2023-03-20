package windows.mainWindow;

import javafx.scene.canvas.Canvas;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import registries.GraphixContextRegistry;

public class NametableTab {
    private final Tab tabNameTable;
    private final ScrollPane scrollPaneNameTable;
    private final Canvas canvasNameTable;
    public NametableTab() {
        scrollPaneNameTable = new ScrollPane();
        tabNameTable = new Tab("Nametable");
        canvasNameTable = new Canvas(2000, 2000);
    }
    public Tab getNameTableTab() {
        scrollPaneNameTable.setContent(canvasNameTable);
        scrollPaneNameTable.setHbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        scrollPaneNameTable.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        GraphixContextRegistry.setNametableTabContext(canvasNameTable.getGraphicsContext2D());
        tabNameTable.setContent(scrollPaneNameTable);

        return tabNameTable;
    }
}
