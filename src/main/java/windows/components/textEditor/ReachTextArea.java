package windows.components.textEditor;

import dto.HintsDto;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventTarget;
import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.geometry.Rectangle2D;
import javafx.geometry.Side;
import javafx.scene.Cursor;
import javafx.scene.control.*;
import javafx.scene.control.skin.TextAreaSkin;
import javafx.scene.control.skin.TextInputControlSkin;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Popup;
import javafx.stage.PopupWindow;
import javafx.stage.Window;
import windows.states.elements.WindowState;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReachTextArea extends TextArea {
    private double caretX = 0.0;
    private double caretY = 0.0;

    protected boolean isShowPopup = false;
    public ReachTextArea() {
        super();
        ContextMenu hintsMenu = new ContextMenu();

        double x = 0.0;
        double y = 0.0;

        textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                ArrayList<CustomMenuItem> populateHints = populateHintsMenu(newValue);
                hintsMenu.getItems().removeAll(hintsMenu.getItems());

                // coordinate
                TextAreaSkin textAreaSkin = (TextAreaSkin) getSkin();
                double minX = textAreaSkin.getCaretBounds().getMaxX();
                double minY = textAreaSkin.getCaretBounds().getMaxY();

                Bounds bounds = localToScreen(textAreaSkin.getCaretBounds());

                double layoutX = bounds.getMinX();
                double layoutY = bounds.getMinY();

//                new AutoCompleteTextField();
                setContextMenu(hintsMenu);
                if (getText().length() == 0) {
                    hintsMenu.hide();
                } else {
                        hintsMenu.getItems().addAll(populateHints);

                        hintsMenu.show(ReachTextArea.this, Side.RIGHT, minX, minY);
                        hintsMenu.show(ReachTextArea.this,Side.BOTTOM, 0, 0);
                        System.out.println("coordinate");
                        System.out.println(minX);
                        System.out.println(minY);

//                    popup.show(ReachTextArea.this, layoutX, layoutY);

                    System.out.println("show popup");
//                    popupWindow.show(ReachTextArea.this, layoutX, layoutY);
//                        hintsMenu.show(ReachTextArea.this, Side.BOTTOM, layoutX, layoutY);
                        hintsMenu.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {
                                CustomMenuItem target = (CustomMenuItem) event.getTarget();
                                String lastLine = newValue.substring(newValue.lastIndexOf("\n") + 1);
                                String lastWord = lastLine.substring(lastLine.lastIndexOf(" ") + 1);
                                deleteText(getText().length() - lastWord.length(), getText().length());
                                appendText(target.getText() + " ");
                            }
                        });
//                    }
                }
            }
        });
    }

    public void setCaretX(double caretX) {
        this.caretX = caretX;
    }

    public void setCaretY(double caretY) {
        this.caretY = caretY;
    }

    public double getCaretX() {
        return caretX;
    }

    public double getCaretY() {
        return caretY;
    }

    protected ArrayList<CustomMenuItem> populateHintsMenu(String newValue) {
        String[] words = HintsDto.getWordsHints();

        ArrayList<CustomMenuItem> customMenuItems = new ArrayList<>(10);

        String lastLine = newValue.substring(newValue.lastIndexOf("\n") + 1);
        String lastWord = lastLine.substring(lastLine.lastIndexOf(" ") + 1);

        if (lastWord.trim().equals("")) {
            return customMenuItems;
        }

        Pattern pattern = Pattern.compile(".*" + lastWord.toUpperCase() + ".*");

        for (String word : words) {
            if (pattern.matcher(word).find()) {
                Label label = new Label(word);
                CustomMenuItem customMenuItem = new CustomMenuItem(label);
                customMenuItem.setText(word);
                customMenuItems.add(customMenuItem);
            }
        }

        return customMenuItems;
    }
}
