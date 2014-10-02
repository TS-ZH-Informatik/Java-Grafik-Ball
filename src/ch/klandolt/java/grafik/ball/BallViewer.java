package ch.klandolt.java.grafik.ball;

import javax.swing.JFrame;

public class BallViewer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setSize(500, 500);
		BallComponent bc = new BallComponent();
		bc.start();
		f.add(bc);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);

	}

}
