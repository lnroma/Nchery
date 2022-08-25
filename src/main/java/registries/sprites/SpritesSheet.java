package registries.sprites;

public class SpritesSheet {
    protected static int[][][][] pageOneAnimation = new int[16][16][8][8];
    protected static int[][][][] pageTwoBackground = new int[16][16][8][8];

    public static int[][][][] getPageOneAnimation() {
        return pageOneAnimation;
    }

    public static int[][][][] getPageTwoBackground() {
        return pageTwoBackground;
    }

    public static void setPageOneAnimation(int[][][][] pageOneAnimation) {
        SpritesSheet.pageOneAnimation = pageOneAnimation;
    }

    public static void setPageTwoBackground(int[][][][] pageTwoBackground) {
        SpritesSheet.pageTwoBackground = pageTwoBackground;
    }
}
