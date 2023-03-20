package windows.mainWindow;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import registries.MenuRegister;
import windows.factories.menu.MenuFactory;
import windows.factories.menu.MenuItemFactory;

public class MenuBar {
    private MenuFactory menuFactory;
    private MenuItemFactory menuItemFactory;

    public MenuBar() {
        this.menuFactory = new MenuFactory();
        this.menuItemFactory = new MenuItemFactory();
    }

    public javafx.scene.control.MenuBar getMenuBar() {
        javafx.scene.control.MenuBar menuBar = new javafx.scene.control.MenuBar();

        Menu menu = this.menuFactory.create("File");
        MenuItem menuOpenCHR = this.menuItemFactory.create("Open CHR");
        MenuItem menuOpenNametable = this.menuItemFactory.create("Open Nametable");
        MenuItem menuCreate = this.menuItemFactory.create("New");
        MenuItem menuSave = this.menuItemFactory.create("Save");
        MenuItem menuClose = this.menuItemFactory.create("Close");

        Menu menuSettings = this.menuFactory.create("Settings");
        MenuItem language = this.menuItemFactory.create("Language");

        menu.getItems().add(menuOpenCHR);
        menu.getItems().add(menuOpenNametable);
        menu.getItems().add(menuSave);
        menu.getItems().add(menuClose);
        menu.getItems().add(menuCreate);


        menuSettings.getItems().add(language);

        MenuRegister.setMenuClose(menuClose);
        MenuRegister.setMenuOpen(menuOpenCHR);
        MenuRegister.setMenuOpenNametable(menuOpenNametable);
        MenuRegister.setMenuSave(menuSave);
        MenuRegister.setMenuNew(menuCreate);

        menuBar.getMenus().addAll(menu, menuSettings);

        return menuBar;
    }
}
