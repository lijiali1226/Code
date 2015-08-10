import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Yard extends Frame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int ROWS = 15;
	public static final int COLS = 15;
	public static final int BLOCK_SIZE = 50;

	private int score = 0;
	private Font fontGameOver = new Font("Arial", Font.BOLD, 50);

	Snake s = new Snake(this);
	Bean b = new Bean();
	Image offScreenImage = null;

	boolean gameOver = false;
	PaintThread paintThread = new PaintThread();

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	/**
	 * 
	 */
	public void lauch() {
		this.setLocation(100, 100);
		this.setSize(ROWS * BLOCK_SIZE, COLS * BLOCK_SIZE);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		}); 
		this.setVisible(true);
		this.addKeyListener(new KeyMonitor());
		new Thread(paintThread).start();
	}

	public static void main(String args[]) {
		new Yard().lauch();
	}

	@Override
	public void paint(Graphics g) {

		g.setColor(Color.GRAY);
		g.fillRect(0, 0, ROWS * BLOCK_SIZE, COLS * BLOCK_SIZE);
		g.setColor(Color.DARK_GRAY);

		for (int i = 1; i < ROWS; i++) {
			g.drawLine(0, BLOCK_SIZE * i, COLS * BLOCK_SIZE, BLOCK_SIZE * i);
		}
		for (int i = 1; i < COLS; i++) {
			g.drawLine(BLOCK_SIZE * i, 0, BLOCK_SIZE * i, ROWS * BLOCK_SIZE);
		}
		g.setColor(Color.YELLOW);
		g.drawString("Score:" + score, 80, 80);
		if (gameOver) {
			g.setFont(fontGameOver);
			g.drawString("GAME OVER!", 100, 100);
			paintThread.gameOver();
		}
		s.eat(b);
		b.draw(g);
		s.draw(g);
	}

	@Override
	public void update(Graphics g) {
		if (offScreenImage == null) {
			offScreenImage = this.createImage(COLS * BLOCK_SIZE, ROWS
					* BLOCK_SIZE);
		}
		Graphics gOff = offScreenImage.getGraphics();
		paint(gOff);
		g.drawImage(offScreenImage, 0, 0, null);
	}

	public class PaintThread implements Runnable {

		boolean running = true;

		@Override
		public void run() {
			while (running) {
				repaint();
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

		public void gameOver() {
			running = false;
		}
	}

	private class KeyMonitor extends KeyAdapter {

		@Override
		public void keyPressed(KeyEvent e) {
			s.keyPressed(e);
		}

	}

	public void stop() {
		gameOver = true;
	}
}
