import javax.swing.JPanel;
import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;


public class Cat extends JFrame{
	// drawing constants are private - no one needs to know what we're doing
	// pick a head dimension
	private static final int HEAD_DIMENSION = 90;
	// eyes will be about 1/4 from top of head and 1/4 from left
	private static final int EYE_Y = HEAD_DIMENSION/4;
	private static final int EYE_X = HEAD_DIMENSION/7;
	private static final int EYE_SEPARATION = HEAD_DIMENSION/3;
	// pick eye dimensions
	private static final int EYE_HEIGHT = 20;
	private static final int EYE_WIDTH = 10;
	// pick mouth height, width is based on head dimension
	private static final int MOUTH_HEIGHT = 10;
	private static final int MOUTH_WIDTH = HEAD_DIMENSION/4;
	// mouth starts about 40% from left edge of head
	private static final int MOUTH_X = HEAD_DIMENSION/5 * 2;
	private static final int MOUTH_Y = HEAD_DIMENSION/5 * 3;
		
	// draw will render the Cat on the Graphics object
	public void draw(Graphics g, int catX, int catY)
	{
		Graphics2D g2 = (Graphics2D) g;
		int x=catX;
		int y=catY;
		
		ImageIcon lasagna = new ImageIcon(getClass().getResource("meat-lasagna-1200.jpg"));
		JLabel lasagnaLable = new JLabel(lasagna);
		add(lasagnaLable);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		pack();
		// Draw the head
		g2.setColor(Color.orange);
		g2.fillOval(x, y, HEAD_DIMENSION, HEAD_DIMENSION);
	
		g2.fillPolygon(new int[] {55, 50, 90}, new int[] {100, 20, 50}, 3);
		g2.fillPolygon(new int[] {115, 100, 140}, new int[] {100, 50, 20}, 3);
		
		
		// Draw the eyes
		g2.setColor(Color.red);
		x = catX + EYE_X; 
		y = catY + EYE_Y;
		g2.fillOval(x, y, EYE_WIDTH, EYE_HEIGHT);
		x += EYE_SEPARATION;
		g2.fillOval(x, y, EYE_WIDTH, EYE_HEIGHT);
		
	
		g2.fillPolygon(new int[] {catX + MOUTH_X + 7, catX + MOUTH_X + 2, catX + MOUTH_X + 11}, new int[] {catY + MOUTH_Y - 7, catY + MOUTH_Y - 9, catY + MOUTH_Y - 9}, 3);
		//pupils
		x -= EYE_SEPARATION;
		g2.setColor(Color.black);
		g2.fillOval(x+3, y+3, 10, 8);
		x += EYE_SEPARATION;
		g2.fillOval(x+1, y+1, 7, 9);
		// Draw the mouth
		g2.setColor(Color.pink);
		x = catX + MOUTH_X;
		y = catY + MOUTH_Y;
		g2.fillOval(x, y, MOUTH_WIDTH, MOUTH_HEIGHT);
		g2.setColor(Color.black);
		// Meow text appears below cat head, +10 places below 
		// so it doesn't overlap the drawing
		g2.drawString("GIMME LASAGNA NOW", catX, catY+HEAD_DIMENSION+10);
		g2.drawString("ugh mondays", catX, catY + HEAD_DIMENSION + 20);
		
		
	}
}
