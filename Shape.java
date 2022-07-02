
public abstract class Shape {
	
	// Symbol to use when rendering the shape.
	private String symbol;

	// Co-ordinate position of the top-left corner of the shape.
	private int positionX;
	private int positionY;
	
	// The maximum width and height that will be used for this shape.
	// These values will be used to decide how far to check to render this shape.
	private int width;
	private int height;
	

	/**
	 * Create a new Shape with a particular symbol to use when drawing,
	 * as well as the x and y position the shape should be drawn from.
	 *  
	 * @param symbol     the symbol for drawing the shape with
	 * @param positionX  the x position of the top-left corner of the shape on canvas
	 * @param positionY  the y position of the top-left corner of the shape on canvas
	 * @param width      the renderable width of the shape (usually same as the shape's width)
	 * @param height     the renderable height of the shape (usually same as the shape's height)
	 */
	public Shape(String symbol, int positionX, int positionY, int width, int height) {
		super();
		this.symbol = symbol;
		this.positionX = positionX;
		this.positionY = positionY;
		this.width = width;
		this.height = height;
	}

	/**
	 * Draws a pixel onto the canvas, at the requested position.
	 * @param x  x-coordinate on the canvas we want to render the shape for
	 * @param y  y-coordinate on the canvas we want to render the shape for
	 * @return   true if something was drawn at the position, false otherwise
	 */
	public boolean draw(int x, int y) {
		int localX = x - positionX;
		int localY = y - positionY;
		
		// If we are within the area where we can draw the shape, ask the
		// shape to draw the pixels within its renderable area.
		if (localX >= 0 && localX < width) {
			if (localY >= 0 && localY < height) {
				return drawLocal(localX, localY);
			}
		}
		
		return false;
	}
	
	/**
	 * A method that returns whether or not to draw a pixel at a specific x and y
	 * position local to within the shape.
	 * @param localX  the x position within the shape's renderable area we want to draw
	 * @param localY  the y position within the shape's renderable area we want to draw
	 * @return        true if something was drawn at the position, false otherwise
	 */
	public abstract boolean drawLocal(int localX, int localY);
	
	/**
	 * Prints the symbol for the shape.
	 */
	public void drawSymbol() {
		System.out.print(symbol);
	}

	public int getPositionX() {
		return positionX;
	}

	public int getPositionY() {
		return positionY;
	}

	

	
}
