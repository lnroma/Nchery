package windows.mainWindow.codeEditor;

import javafx.event.EventHandler;
import javafx.scene.CacheHint;
import javafx.scene.control.TextArea;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import windows.factories.codeEditor.TextAreaFactory;

public class CodeEditorTab {
    protected TextAreaFactory textAreaFactory;

    public CodeEditorTab() {
        this.textAreaFactory = new TextAreaFactory();
    }

    public TextArea render() {
        TextArea codeEditor = this.textAreaFactory.create();

        //        codeEditor.setOnInputMethodTextChanged(new EventHandler<InputMethodEvent>() {
//            @Override
//            public void handle(InputMethodEvent event) {
//                int caretPosition = event.getCaretPosition();
//            }
//        });

//        codeEditor.setOnKeyTyped(new EventHandler<KeyEvent>() {
//            @Override
//            public void handle(KeyEvent event) {
//                codeEditor.getPrefRowCount();
//            }
//        });

        return codeEditor;
    }
}
