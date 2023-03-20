package controllers;

import javafx.scene.control.MenuItem;
import registries.MenuRegister;
import services.BlankChrBytesService;
import services.ChrRender;

public class FileNewController {

    public void control() {
        MenuItem menuNew = MenuRegister.getMenuNew();

        menuNew.setOnAction(event -> {
            BlankChrBytesService blankChrBytesService = new BlankChrBytesService();
            blankChrBytesService.blankNewChr();

            ChrRender chrRender = new ChrRender();
            chrRender.redrawAll();
        });
    }
}
