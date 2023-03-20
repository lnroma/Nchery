package windows.factories.menu;

import javafx.scene.control.MenuItem;

public class MenuItemFactory {

    public MenuItem create() {
        return new MenuItem();
    }

    public MenuItem create(String menuItemName) {
        return new MenuItem(menuItemName);
    }
}
