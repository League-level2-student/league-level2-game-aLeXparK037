package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class Claw extends GameObject implements ActionListener {
	Timer clawTimer = new Timer(1000 / 60, this);
	boolean downIsActive = true;

	Claw(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
		speed = 5;
	}

	void draw(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(x, y, width, height);

	}

	public void right() {
		if (downIsActive == false) {

		} else {
			x += speed;
		}
	}

	public void left() {
		if (downIsActive == false) {

		} else {
			x -= speed;
		}
	}

	public void down() {
		downIsActive = false;
		y += 3;
		if (y > 500) {
			clawTimer.stop();
		}
	}

	void timerStart() {
		clawTimer.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		down();

	}

}
