package windows.states;

import windows.states.elements.WindowState;

public class GlobalState {

    protected static WindowState windowState;

    public static WindowState getWindowState() {
        return windowState;
    }

    public static void setWindowState(WindowState windowState) {
        GlobalState.windowState = windowState;
    }
}
