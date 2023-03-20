package windows.mainWindow;

import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import windows.factories.tab.TabFactory;
import windows.mainWindow.codeEditor.CodeEditorTab;
import windows.states.elements.WindowState;

public class TabCode {
    protected TabFactory tabFactory;
    protected CodeEditorTab codeEditorTab;
    public TabCode() {
        this.tabFactory = new TabFactory();
        this.codeEditorTab = new CodeEditorTab();
    }
    public Tab getTabCode() {
        Tab tabCode = this.tabFactory.create("code editor");
        TextArea textArea =  this.codeEditorTab.render();
        WindowState.setTextAreaState(textArea);
        tabCode.setContent(textArea);

        WindowState.setTabCode(tabCode);

        return tabCode;
    }
}
