package main;

import java.awt.Color;
import java.awt.Graphics;

public class Things extends GameObject{

	Things(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}
	public void update() {
	    super.update();

	}
	void draw(Graphics g) {
		g.setColor(Color.GREEN);
	    g.fillRect(x, y, width, height);
	}
}
