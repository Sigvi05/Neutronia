package json_generator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

public class JsonGeneratorApp {

    Logger logger = LogManager.getLogger("JsonGenerator");

    public static void main(String[] argv) {
        JsonGeneratorApp displayExample = new JsonGeneratorApp();
        displayExample.start();
    }

    public void start() {
        try {
            Display.setDisplayMode(new DisplayMode(800, 600));
            Display.create();
        } catch (LWJGLException e) {
            e.printStackTrace();
            System.exit(0);
        }

        // init OpenGL here

        while (!Display.isCloseRequested()) {

            // render OpenGL here

            Display.update();
        }

        Display.destroy();
    }

}
