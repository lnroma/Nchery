package windows.factories.tab;

import javafx.scene.control.Tab;

public class TabFactory {
    public Tab create() {
        return new Tab();
    }

    public Tab create(String tabName) {
        return new Tab(tabName);
    }
}
