/**
 * A right-angled isosceles triangle, with the right-angle being located
 * at the bottom left of the shape.

 * @author Dengke Sha
 *
 */
public class Triangle extends Shape {
	
	/**
	 * Create a triangle.
	 * @param symbol      the symbol for drawing the shape with
	 * @param positionX   the x position of the top-left corner of the shape on canvas
	 * @param positionY   the y position of the top-left corner of the shape on canvas
	 * @param sideLength  the side length of the triangle
	 */
	public Triangle(String symbol, int positionX, int positionY, int sideLength) {
		super(symbol, positionX, positionY, sideLength, sideLength);
	}

	@Override
	public boolean drawLocal(int localX, int localY) {
		
		if (localX <= localY) {
			drawSymbol();
			return true;
		}
		
		return false;
	}

}
