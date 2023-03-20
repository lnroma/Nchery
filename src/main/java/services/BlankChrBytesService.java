package services;

import registries.sprites.SpritesSheet;

public class BlankChrBytesService {
    protected int[][][][] bufferPageOne = new int[16][16][8][8];
    protected int[][][][] bufferPageTwo = new int[16][16][8][8];

    public void blankNewChr() {
        SpritesSheet.setPageOneAnimation(bufferPageOne);
        SpritesSheet.setPageTwoBackground(bufferPageTwo);
    }
}
