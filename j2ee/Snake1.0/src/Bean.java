import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Bean {
	int row, col;
	int w = Yard.BLOCK_SIZE;
	int h = Yard.BLOCK_SIZE;
	private static Random r = new Random();
	private Color c = Color.GREEN;

	public Bean(int row, int col) {
		this.row = row;
		this.col = col;
	}

	public Bean() {
		this(r.nextInt(Yard.ROWS - 2) + 2, r.nextInt(Yard.COLS));
	}

	public void reAppear() {
		this.row = r.nextInt(Yard.ROWS - 2) + 2;
		this.col = r.nextInt(Yard.COLS);
	}

	public Rectangle getRect() {
		return new Rectangle(col * Yard.BLOCK_SIZE, row * Yard.BLOCK_SIZE, w, h);
	}

	public void draw(Graphics g) {
		g.setColor(c);
		g.fillOval(col * Yard.BLOCK_SIZE, row * Yard.BLOCK_SIZE, w, h);
		if (c == Color.GREEN)
			c = Color.RED;
		else
			c = Color.GREEN;
	}
}
