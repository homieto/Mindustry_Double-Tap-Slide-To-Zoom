package double.tap.zoom;

import arc.Core;
import arc.input.GestureDetector;
import mindustry.mod.Mod;

public class Main extends Mod {
    public Main() {
        DoubleTapZoomHandler doubleTapZoomHandler = new DoubleTapZoomHandler();
        GestureDetector gestureDetector = new GestureDetector(doubleTapZoomHandler);
        Core.input.addProcessor(gestureDetector);
    }
}