package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class Claw extends GameObject {
	boolean down = false;
	boolean right = false;
	boolean left = false;


	Claw(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
		speed = 5;
	}

	void draw(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(x, y, width, height);

	}

	public void right(boolean moveRight) {
		right = moveRight;
	}

	public void left(boolean moveLeft) {
		left = moveLeft;
	}

	public void down(boolean moveDown) {
		down = moveDown;
				//3
	}
	
	public void update() {
		if (y>500) {
			down = false;
		} 
		if (right == true && down == false) {
			x += 2;
		}
		if (left == true && down == false) {
			x-=2;
		}
		if (down == true) {
			y+=2;
		}
	}

	

}
