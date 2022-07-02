import java.util.ArrayList;

/**
 * A Canvas for adding shapes to. Canvases can hold an arbitrary number of shapes
 * and will render shapes added first above shapes added later.
 * 
 * @author Dengke Sha
 *
 */
public class Canvas {
	
	// A single character string to use as the background for the Canvas.
	private String background;
	
	// Dimensions of the canvas.
	private int width;
	private int height;
	
	// List of shapes the canvas holds.
	private ArrayList<Shape> shapes = new ArrayList<Shape>();

	/**
	 * Constructs a new canvas with a particular width and height.
	 * @param width   the width of the canvas
	 * @param height  the height of the canvas
	 */
	public Canvas(String background, int width, int height) {
		super();
		this.background = background;
		this.width = width;
		this.height = height;
	}
	
	/**
	 * Draw the canvas and the shapes on the canvas.
	 */
	public void draw() {
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {

				boolean isPixelDrawn = false;

				for (Shape shape : shapes) {

					isPixelDrawn = shape.draw(x, y);

					// Once something is drawn, no longer need to draw anything else.
					if (isPixelDrawn) {
						break;
					}

				}
				
				// If nothing was drawn at that position, draw the empty cell instead.
				if (!isPixelDrawn) {
					System.out.print(background);
				}
			}
			System.out.println();
		}
	}
	
	/**
	 * Adds a shape to the canvas.
	 * @param shape  the shape to add
	 */
	public void add(Shape shape) {
		shapes.add(shape);
	}

}
		
