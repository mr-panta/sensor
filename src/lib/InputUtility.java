package lib;

public class InputUtility {
	
	private static int mouseX = 0;
	private static int mouseY = 0;
	private static boolean mouseLeftLastDown = false;
	private static boolean mouseLeftDown = false;
	private static boolean isMouseOnScreen = false;
	
	public static boolean isMouseOnScreen() {
		return isMouseOnScreen;
	}
	public static boolean isMouseLeftLastDown() {
		return mouseLeftLastDown;
	}
	public static void setMouseLeftLastDown(boolean mouseLeftLastDown) {
		InputUtility.mouseLeftLastDown = mouseLeftLastDown;
	}
	public static boolean isMouseLeftDown() {
		return mouseLeftDown;
	}
	public static void setMouseLeftDown(boolean mouseLeftDown) {
		InputUtility.mouseLeftDown = mouseLeftDown;
	}
	public static void setMouseOnScreen(boolean isMouseOnScreen) {
		InputUtility.isMouseOnScreen = isMouseOnScreen;
	}
	public static int getMouseX() {
		return mouseX;
	}
	public static void setMouseX(int mouseX) {
		InputUtility.mouseX = mouseX;
	}
	public static int getMouseY() {
		return mouseY;
	}
	public static void setMouseY(int mouseY) {
		InputUtility.mouseY = mouseY;
	}
}