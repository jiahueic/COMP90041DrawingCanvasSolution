
/**
 * A custom shape that a user can configure.
 * The CustomShape objects are backed by a 2-dimensional array.
 * Inidividual "pixels" of the shape can be set, to create the shape.
 * 
 * @author Dengke Sha
 *
 */
public class CustomShape extends Shape {
	
	// The pixels within this shape and whether they are on or off.
	private boolean[][] pixels;

	/**
	 * Create a CustomShape.
	 * @param symbol     the symbol for drawing the shape with
	 * @param positionX  the x position of the top-left corner of the shape on canvas
	 * @param positionY  the y position of the top-left corner of the shape on canvas
	 * @param width      the width of the shape
	 * @param height     the height of the shape
	 */
	public CustomShape(String symbol, int positionX, int positionY, int width, int height) {
		super(symbol, positionX, positionY, width, height);
		this.pixels = new boolean[height][width];
	}
	
	/**
	 * Set a pixel to be on for this custom shape. (x, y) is the location
	 * of a pixel on this image to be set to "on". In these relative
	 * co-ordinates, the top-left of shape is (0, 0).
	 * 
	 * @param x  the local x location for the pixel to set
	 * @param y  the local y location for the pixel to set
	 */
	public void setPixel(int x, int y) {
		pixels[y][x] = true;
	}

	@Override
	public boolean drawLocal(int localX, int localY) {
		boolean isPixelOn = pixels[localY][localX];
		
		if (isPixelOn) {
			drawSymbol();
		}
		
		return isPixelOn;
	}

}
