package controllers;

import javafx.scene.control.MenuItem;
import registries.FilePathRegistry;
import registries.MenuRegister;
import registries.sprites.SpritesSheet;
import services.ChrRender;
import services.DrawGreedInCanvas;
import services.DrawSprite;
import services.ReadFileBytsAsString;
import windows.ChoseFileDialog;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class FileOpenController {
    public void control() {
        MenuItem menuOpen = MenuRegister.getMenuOpen();

        menuOpen.setOnAction(e -> {
            ChoseFileDialog choseFileDialog = new ChoseFileDialog();
            choseFileDialog.show();
            Path path = FileSystems.getDefault().getPath(choseFileDialog.getOpenedFile().getPath());

            FilePathRegistry.setPath(path);
            ReadFileBytsAsString readFileBytsAsString = new ReadFileBytsAsString();
            try {
                readFileBytsAsString.read();
                ChrRender chrRender = new ChrRender();
                chrRender.redrawAll();
//
//                DrawSprite drawSprite = new DrawSprite();
//                drawSprite.drawPage(SpritesSheet.getPageOneAnimation());
//
//                DrawGreedInCanvas drawGreedInCanvas = new DrawGreedInCanvas();
//                drawGreedInCanvas.drawGrid();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
    }
}
