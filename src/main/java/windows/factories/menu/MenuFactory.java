package windows.factories.menu;

import javafx.scene.control.Menu;

public class MenuFactory {
    public Menu create() {
        return new Menu();
    }

    public Menu create(String menuName) {
        return new Menu(menuName);
    }
}
