package services;

import javafx.css.Match;
import registries.FilePathRegistry;
import registries.NameTableRegister;
import registries.sprites.SpritesSheet;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ReadNameTableFileReader {
    private int[][][] nameTableSheetTmp = new int[32][32][2];

    public void read() throws IOException {
        Path path = FilePathRegistry.getNameTablePath();
        byte[] data = Files.readAllBytes(path);

        for (int y = 0; y < 32; y++) {
            for (int x = 0; x < 32; x++ ) {
                int xInSpriteSheet;
                int yInSpriteSheet;
                int currentByte = data[(y*32) + x];

                if (currentByte < 0) {
                    currentByte = currentByte * -1;
                }
                System.out.print(Integer.toHexString(currentByte));
                System.out.print(" ");

                yInSpriteSheet = (int)currentByte/16;
                xInSpriteSheet = currentByte - yInSpriteSheet * 16;

                nameTableSheetTmp[x][y][0] = xInSpriteSheet;
                nameTableSheetTmp[x][y][1] = yInSpriteSheet;

            }
            System.out.print("\n");
        }

        NameTableRegister.setNameTableSheet(nameTableSheetTmp);
    }
}
