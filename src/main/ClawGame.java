package main;

import javax.swing.JFrame;

public class ClawGame {
	JFrame frame;
	final static int WIDTH = 500;
	final static int HEIGHT = 500;
	GamePanel game;

	public static void main(String[] args) {
		ClawGame one = new ClawGame();
		one.setup();
	}

	ClawGame() {
		frame = new JFrame();
		game= new GamePanel();

	}

	void setup() {
		frame.add(game);
		frame.setVisible(true);
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
