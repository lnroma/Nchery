package registries.sprites;

public class SpritesForEditor {
    protected static int[][] oneSprite = new int[8][8];
    protected static int[][] twoSprite = new int[8][8];
    protected static int[][] threeSprite = new int[8][8];
    protected static int[][] forSprite = new int[8][8];

    public static int[][] getOneSprite() {
        return oneSprite;
    }

    public static int[][] getTwoSprite() {
        return twoSprite;
    }

    public static int[][] getThreeSprite() {
        return threeSprite;
    }

    public static int[][] getForSprite() {
        return forSprite;
    }

    public static void setOneSprite(int[][] oneSprite) {
        SpritesForEditor.oneSprite = oneSprite;
    }

    public static void setTwoSprite(int[][] twoSprite) {
        SpritesForEditor.twoSprite = twoSprite;
    }

    public static void setThreeSprite(int[][] threeSprite) {
        SpritesForEditor.threeSprite = threeSprite;
    }

    public static void setForSprite(int[][] forSprite) {
        SpritesForEditor.forSprite = forSprite;
    }
}
