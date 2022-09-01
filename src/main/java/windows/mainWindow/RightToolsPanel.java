package windows.mainWindow;

import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.effect.BlendMode;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class RightToolsPanel {

    public GridPane renderRightPane() {
        GridPane gridPane = new GridPane();
        Label t1 = new Label("Animation tools drag and drop" +
                " sprite to squire for edit" +
                " sprites in the group");
        t1.setWrapText(true);
        Canvas firstSprite = new Canvas(80,80);
        Canvas twiceSprite = new Canvas(80,80);
        Canvas threeSprite = new Canvas(80,80);
        Canvas forSprite = new Canvas(80,80);
        firstSprite.getGraphicsContext2D().setFill(Color.BLACK);

//        Label t2 = new Label("sprites);
//        Label t3 = new Label("sprites 2");
//        Label t4 = new Label("sprites 3");
//        Label t5 = new Label("sprites 4");
        Label t6 = new Label("t6");
        Label t7 = new Label("t7");

        gridPane.add(t1, 0, 0, 2, 1);
        gridPane.add(firstSprite, 0, 1);
        gridPane.add(twiceSprite, 1, 1);
        gridPane.add(threeSprite, 0, 2);
        gridPane.add(forSprite, 1, 2);
        gridPane.add(t6, 0, 5);
        gridPane.add(t7, 0, 6);

        gridPane.setGridLinesVisible(true);

        return gridPane;
    }
}
