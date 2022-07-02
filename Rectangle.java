public class Rectangle extends Shape {

	/**
	 * Create a rectangle.
	 * @param symbol     the symbol for drawing the shape with
	 * @param positionX  the x position of the top-left corner of the shape on canvas
	 * @param positionY  the y position of the top-left corner of the shape on canvas
	 * @param width      the width of the shape
	 * @param height     the height of the shape
	 */
	public Rectangle(String symbol, int positionX, int positionY, int width, int height) {
		super(symbol, positionX, positionY, width, height);
	}

	@Override
	public boolean drawLocal(int localX, int localY) {
		drawSymbol();
		return true;
	}

}
