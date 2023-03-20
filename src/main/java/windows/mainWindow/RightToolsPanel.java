package windows.mainWindow;

import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import registries.sprites.GcForSprite;
import services.DrawSprite;

public class RightToolsPanel {
    protected DrawSprite drawSprite;

    public RightToolsPanel() {
        this.drawSprite = new DrawSprite();
    }

    public GridPane renderRightPane() {
        GridPane gridPane = new GridPane();
        Label animationTools = new Label("Animation tools drag and drop" +
                " sprite to squire for edit" +
                " sprites in the group");
        animationTools.setWrapText(true);

        Canvas[] canvasArray = new Canvas[8];
        for (int canvasI = 0; canvasI < 8; canvasI++) {
            canvasArray[canvasI] = new Canvas(40, 40);
            GcForSprite.setGc(canvasArray[canvasI].getGraphicsContext2D(), canvasI);
        }

        gridPane.add(animationTools, 0, 0, 2, 1);
        int canvasIndex = 0;
        for (int rowIndex = 1; rowIndex < 4; rowIndex++) {
            for (int columnIndex = 0; columnIndex < 2; columnIndex++) {
                gridPane.add(canvasArray[canvasIndex], columnIndex, rowIndex);
                canvasIndex++;
            }
        }

//        gridPane.setGridLinesVisible(true);

        return gridPane;
    }
}
