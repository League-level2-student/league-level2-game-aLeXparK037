package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class Claw extends GameObject {
	boolean down = false;
	boolean right = false;
	boolean left = false;
	
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	


	Claw(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
		speed = 2;
		if (needImage) {
		    loadImage ("claw.png");
		}
	}

	void draw(Graphics g) {
		g.setColor(new Color(161,149,90));
		g.fillRect(x + 25, 0, 3, y);
		if (gotImage) {
			g.drawImage(image, x, y, width, height, null);
		} else {
			g.setColor(Color.BLUE);
			g.fillRect(x, y, width, height);
		}

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
		if (right == true && down == false && x < ClawGame.WIDTH - width) {
			x += 2;
		}
		if (left == true && down == false && x > 0) {
			x-=2;
		}
		if (down == true) {
			y+=speed;
		}
	}
	void loadImage(String imageFile) {
	    if (needImage) {
	        try {
	            image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
		    gotImage = true;
	        } catch (Exception e) {
	            
	        }
	        needImage = false;
	    }
	}

	

}
