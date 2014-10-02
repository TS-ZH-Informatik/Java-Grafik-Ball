package ch.klandolt.java.grafik.ball;

import javax.swing.JComponent;
import javax.swing.JPanel;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class BallComponent extends JComponent implements Runnable {

	/**
	 * Variabeln für Koordinaten:
	 */

	double x1 = 0.0;
	double x2 = 200.0;
	double y1 = 100.0;
	double y2 = 100.0;
	
	int rectx1 = 0;
	int rectx2 = 0;
	
	
	

	double high = (double) getHeight();
	double with = (double) getWidth();
	int way = 1;

	private static final long serialVersionUID = 1L;

	private Thread t;

	public BallComponent() {
		this.setBackground(Color.RED);
	}

	public void start() {
		this.t = new Thread(this);
		t.start();
	}

	@Override
	public void paintComponent(Graphics g) {
		//System.out.println("in BallComponent.paintComponent...");

		Graphics2D g2 = (Graphics2D) g;

		Ellipse2D.Double head = new Ellipse2D.Double(x1, x2, y1, y2);
		g2.setColor(Color.RED);
		g2.fill(head);
		g2.draw(head);
		
		//Size
		
		high = (double) getHeight();
		with = (double) getWidth();
		
		g2.setColor(Color.GREEN);
		
		rectx1 = 0;
		rectx2 = (int) high/2-50;
		
		Rectangle rect1 = new Rectangle(rectx1, rectx2, 100, 100);
		g2.draw(rect1);
		

		if (x1 == 0) {
			way = 1;
		}
		
		rectx1 = (int) with/2 - 50;
		rectx2 = (int) high-100;
		Rectangle rect2 = new Rectangle(rectx1, rectx2, 100, 100);
		g2.draw(rect2);
		
		if (x2 == rectx2) {
			way = 2;
		}
		
		
		
		g2.setColor(Color.RED);
		rectx1 = (int) with - 100;
		rectx2 = (int) (high/2)-50;
		Rectangle rect3 = new Rectangle(rectx1, rectx2, 100, 100);
		g2.draw(rect3);
		
		
		if (x1 == rectx1) {
			way = 3;
		}
		
		g2.setColor(Color.GREEN);
		rectx1 = (int) (with/2) - 50;
		rectx2 = (int) 0;
		Rectangle rect4 = new Rectangle(rectx1, rectx2, 100, 100);
		g2.draw(rect4);
		
		if (x2 == rectx2) {
			way = 4;
		}
		
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(10);
				
				
				
				if (way == 1) {
					x1 = x1 + 1;
					x2 = x2 + 1;

					
				} else if (way == 2) {
					x1 = x1 + 1;
					x2 = x2 - 1;

					
				} else if (way == 3) {
					x1 = x1 - 1;
					x2 = x2 - 1;

					
				} else if (way == 4) {
					x1 = x1 - 1;
					x2 = x2 + 1;
					
				}

				high = (double) getHeight();
				with = (double) getWidth();

				this.repaint();
				//System.out.println("in run()...");
			} catch (InterruptedException e) {
			}
		}

	}

}
