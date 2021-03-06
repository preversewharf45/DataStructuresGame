package renderEngine;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.ContextAttribs;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.PixelFormat;

public class DisplayManager {
	
	private static final int WIDTH = 1600;
	private static final int HEIGHT = 900;
	private static final int FPS_CAP = 200;

	private static boolean shouldClose = false;
	
	public static void createDisplay(){		
		ContextAttribs attribs = new ContextAttribs(3,2)
		.withForwardCompatible(true)
		.withProfileCore(true);
		
		try {
			Display.setDisplayMode(new DisplayMode(WIDTH,HEIGHT));
			Display.create(new PixelFormat(), attribs);
			Display.setTitle("Our First Display!");
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
		
		GL11.glViewport(0,0, WIDTH, HEIGHT);
	}
	
	public static void updateDisplay(){
		Display.sync(FPS_CAP);
		Display.update();
	}
	
	public static void closeDisplay(){
		Display.destroy();
	}

	public static boolean isCloseRequested() {
		if (Display.isCloseRequested()) {
			shouldClose = true;
		}
		return shouldClose;
	}

	public static void setDisplayShouldClose(boolean value) {
		shouldClose = value;
	}

}
