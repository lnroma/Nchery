package registries;

import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

public class MenuRegister {
    protected static MenuItem menuOpen;
    protected static MenuItem menuSave;
    protected static MenuItem menuClose;

    public static void setMenuClose(MenuItem menuClose) {
        MenuRegister.menuClose = menuClose;
    }

    public static void setMenuSave(MenuItem menuSave) {
        MenuRegister.menuSave = menuSave;
    }

    public static MenuItem getMenuClose() {
        return menuClose;
    }

    public static MenuItem getMenuSave() {
        return menuSave;
    }

    public static void setMenuOpen(MenuItem menuOpen) {
        MenuRegister.menuOpen = menuOpen;
    }

    public static MenuItem getMenuOpen() {
        return menuOpen;
    }
}
