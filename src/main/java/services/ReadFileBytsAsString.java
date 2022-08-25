package services;

import registries.FilePathRegistry;
import registries.sprites.SpritesSheet;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ReadFileBytsAsString {
    protected int[][][][] bufferPageOne = new int[16][16][8][8];
    protected int[][][][] bufferPageTwo = new int[16][16][8][8];

    public void read() throws IOException {
        Path path = FilePathRegistry.getPath();
        byte[] data = Files.readAllBytes(path);
        int chunksLength = data.length/16;
        int stringIndex = 0;
        int spriteXPos = 0;


        for (int chunkIndex = 0; chunkIndex < chunksLength - 16; chunkIndex++) {
            String[] bufer1;
            String[] bufer2;
            bufer1 = new String[8];
            bufer2 = new String[8];

            int bufferCount1 = 0;
            int bufferCount2 = 0;
            int startLo = chunkIndex * 8 + chunkIndex * 8;
            int startHo = chunkIndex * 8 + (chunkIndex + 1) * 8;

            for (int i = startLo; i < startHo; i++) {
                String bufer = String.format("%8s", Integer.toBinaryString(data[i] & 0xff)).replace(" ", "0");
                bufer1[bufferCount1] = bufer;
                bufferCount1 = bufferCount1 + 1;
            }

            for (int i = startHo; i < startHo + 8; i++) {
                String bufer = String.format("%8s", Integer.toBinaryString(data[i] & 0xff)).replace(" ", "0");
                bufer2[bufferCount2] = bufer;
                bufferCount2 = bufferCount2 + 1;
            }

            if (chunkIndex == 255) {
                stringIndex = 0;
            }

            if (chunkIndex % 16 == 0 & chunkIndex > 0) {
                stringIndex++;
                spriteXPos = 0;
            }

            for (int buferI = 0; buferI < 8; buferI++) {
                char[] bufferArray = bufer1[buferI].toCharArray();
                char[] bufferArray2 = bufer2[buferI].toCharArray();
                for (int pos = 0; pos < 8; pos++) {
                    if (bufferArray[pos] == '0' && bufferArray2[pos] == '0') {
                        addToBufferSpriteData(spriteXPos, stringIndex, pos, buferI, 0, chunkIndex < 256);
                    } else if (bufferArray[pos] == '1' && bufferArray2[pos] == '0') {
                        addToBufferSpriteData(spriteXPos, stringIndex, pos, buferI, 1, chunkIndex < 256);
                    } else if (bufferArray[pos] == '0' && bufferArray2[pos] == '1') {
                        addToBufferSpriteData(spriteXPos, stringIndex, pos, buferI, 2, chunkIndex < 256);
                    } else if (bufferArray[pos] == '1' && bufferArray2[pos] == '1') {
                        addToBufferSpriteData(spriteXPos, stringIndex, pos, buferI, 3, chunkIndex < 256);
                    }
                }
            }

            spriteXPos++;
        }

        SpritesSheet.setPageOneAnimation(bufferPageOne);
        SpritesSheet.setPageTwoBackground(bufferPageTwo);
    }

    protected void addToBufferSpriteData(
            int x,
            int y,
            int xSpritePoint,
            int ySpritePoint,
            int dataPixel,
            boolean isPageOne
    ) {
        if (isPageOne) {
            bufferPageOne[x][y][xSpritePoint][ySpritePoint] = dataPixel;
        } else {
            bufferPageTwo[x][y][xSpritePoint][ySpritePoint] = dataPixel;
        }
    }
}
