package registries.sprites;

public class CurrentIndex {

    protected static int currentIndex = 0;

    public static int getCurrentIndex() {
        int indexBeforeInc = currentIndex;
        currentIndex++;
        if (currentIndex == 8) {
            currentIndex = 0;
        }

        return indexBeforeInc;
    }
}
