package events;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class MouseDraggedHandler implements EventHandler<MouseEvent> {
    @Override
    public void handle(MouseEvent event) {
        double x = event.getX();
        double y = event.getY();
    }
}
