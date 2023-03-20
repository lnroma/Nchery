package controllers;

import javafx.scene.control.MenuItem;
import registries.FilePathRegistry;
import registries.MenuRegister;
import services.ChrRender;
import services.NameTableReader;
import services.ReadFileBytsAsString;
import services.ReadNameTableFileReader;
import windows.ChoseFileDialog;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class NameTableOpenController {
    public void control() {
        MenuItem menuNameTableOpen = MenuRegister.getMenuOpenNametable();
        menuNameTableOpen.setOnAction(e -> {
            ChoseFileDialog choseFileDialog = new ChoseFileDialog();
            choseFileDialog.show();
            Path path = FileSystems.getDefault().getPath(choseFileDialog.getOpenedFile().getPath());

            FilePathRegistry.setNameTablePath(path);
            ReadNameTableFileReader readNameTableFileReader = new ReadNameTableFileReader();
            try {
                readNameTableFileReader.read();
                NameTableReader nameTableReader = new NameTableReader();
                nameTableReader.drawNameTable();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
    }
}
