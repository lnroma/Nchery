package registries;

import javafx.scene.paint.Color;

public class PaleteRegistry {
    protected static Color colorOne;
    protected static Color colorTwo;
    protected static Color colorThree;
    protected static Color colorFour;

    public static void setColorOne(Color colorOneValue) {
        colorOne = colorOneValue;
    }

    public static void setColorTwo(Color value) {
        colorTwo = value;
    }

    public static void setColorThree(Color value) {
        colorThree = value;
    }

    public static void setColorFour(Color value) {
        colorFour = value;
    }

    public static Color getColorOne() {
        if (colorOne == null) {
            return Color.WHITE;
        }

        return colorOne;
    }

    public static Color getColorTwo() {
        if (colorTwo == null) {
            return Color.GREEN;
        }

        return colorTwo;
    }

    public static Color getColorThree() {
        if (colorThree == null) {
            return Color.BLUE;
        }

        return colorThree;
    }

    public static Color getColorFour() {
        if (colorFour == null) {
            return Color.RED;
        }

        return colorFour;
    }
}
