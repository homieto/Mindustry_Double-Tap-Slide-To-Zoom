package double.tab.zoom;

import arc.input.GestureDetector;
import arc.math.geom.Vec2;
import arc.util.Log;

public class DoubleTapZoomHandler implements GestureDetector.GestureListener {
    private final Vec2 firstTap = new Vec2();
    private boolean doubleTapRegistered = false;

    @Override
    public boolean tap(float x, float y, int count, int button) {
        if (count == 2) {
            firstTap.set(x, y);
            doubleTapRegistered = true;
        }
        return false;
    }

    @Override
    public boolean pan(float x, float y, float deltaX, float deltaY) {
        if (!doubleTapRegistered) return false;

        // Calculate distance from the second tap point
        float distance = Vec2.dst(firstTap.x, firstTap.y, x, y);

        // Zoom logic (adjust zoomFactor to your preference)
        float zoomFactor = 0.01f;
        if (distance > 0) {
            // Zoom in or out based on the direction of the slide
            // Example: Core.camera.zoom += (deltaY * zoomFactor);
            Log.info("Zooming with factor: " + (deltaY * zoomFactor));
        }

        return false;
    }

    @Override
    public boolean panStop(float x, float y, int pointer, int button) {
        doubleTapRegistered = false;
        return false;
    }
}