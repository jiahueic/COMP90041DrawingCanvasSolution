import java.util.Scanner;

/**
 * A simple drawing program.
 * 
 * @author Dengke Sha
 *
 */
public class DrawingCanvas {
	
	// Argument indexes for parsing commands.
	private static final int CMD_NAME = 0;
	private static final int CMD_SYMBOL = 1;
	private static final int CMD_POS_X = 2;
	private static final int CMD_POS_Y = 3;
	private static final int CMD_WIDTH = 4;
	private static final int CMD_HEIGHT = 5;
	
	// Index where we start retrieving pixel on information from the custom shape command.
	private static final int CMD_PIXEL_START = 6;
	private static final int ARG_PAIRS = 2;

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Canvas background: ");
		String backgroundSymbol = scanner.nextLine();
		
		System.out.print("Canvas width: ");
		int canvasWidth = scanner.nextInt();
		scanner.nextLine();
		
		System.out.print("Canvas height: ");
		int canvasHeight = scanner.nextInt();
		scanner.nextLine();

		Canvas canvas = new Canvas(backgroundSymbol, canvasWidth, canvasHeight);
		
		// Read shape commands.
		while(true) {
			
			// Read in commands for drawing shapes.
			System.out.print("shape> ");
			String input = scanner.nextLine();
			
			// Stop reading commands if no more commands.
			if(input.equals("")) {
				break;
			}
			
			// Get info from the command entered.
			String[] command = input.split(" ");
			String commandName = command[CMD_NAME];
			String symbol = command[CMD_SYMBOL];
			int posX = Integer.parseInt(command[CMD_POS_X]);
			int posY = Integer.parseInt(command[CMD_POS_Y]);
			int width = Integer.parseInt(command[CMD_WIDTH]);
			
			// Handle each command.
			if(commandName.equals("rec")) {
				
				int height = Integer.parseInt(command[CMD_HEIGHT]);
				canvas.add(new Rectangle(symbol, posX, posY, width, height));
				
			} else if(commandName.equals("tri")) {
				
				canvas.add(new Triangle(symbol, posX, posY, width));
				
			} else if(commandName.equals("cus")) {
				
				int height = Integer.parseInt(command[CMD_HEIGHT]);
				CustomShape customShape = new CustomShape(symbol, posX, posY, width, height);
				
				// Takes pairs of integers as pixel locations to turn on.
				int currentIndex = CMD_PIXEL_START;
				while(currentIndex < command.length) {
					// Take pairs of pixels to set.
					int x = Integer.parseInt(command[currentIndex]);
					int y = Integer.parseInt(command[currentIndex + 1]);
					customShape.setPixel(x, y);
					currentIndex += ARG_PAIRS;
				}

				canvas.add(customShape);
				
			}
			
		}

		// Draw the shapes on the canvas.
		canvas.draw();

		scanner.close();

	}

}
