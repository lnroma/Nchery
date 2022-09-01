package events;

import javafx.event.EventHandler;
import javafx.scene.input.MouseDragEvent;

public class MouseHandler implements EventHandler<MouseDragEvent> {
    @Override
    public void handle(MouseDragEvent event) {
        double x = event.getX();
        double y = event.getY();
    }
}
