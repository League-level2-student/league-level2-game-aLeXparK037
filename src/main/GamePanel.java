package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	final int MENU = 0;
	final int LEVELONE = 1;
	final int LEVELTWO = 2;
	final int END = 3;
	int currentState = MENU;
	Font titleFont;
	Font subFont;
	Timer frameDraw;
	Random ran = new Random();
	int num = ran.nextInt(476);
	Claw claw = new Claw(225, 50, 50, 50);
	Prize prize = new Prize(num, 400, 25, 25);

	@Override
	public void paintComponent(Graphics g) {
		// g.fillRect(225, 50, 50, 50);
		if (currentState == MENU) {
			drawMenuState(g);
		} else if (currentState == LEVELONE) {
			drawLeveloneState(g);
		} else if (currentState == LEVELTWO) {
			drawLeveltwoState(g);
		} else if (currentState == END) {
			drawEndState(g);
		}
	}

	GamePanel() {
		titleFont = new Font("Arial", Font.PLAIN, 36);
		subFont = new Font("Arial", Font.PLAIN, 18);
		frameDraw = new Timer(1000 / 60, this);
		frameDraw.start();

	}

	void updateMenuState() {

	}

	void updateLeveloneState() {
		claw.update();
		
	}

	void updateLeveltwoState() {
		claw.update();

	}

	void updateEndState() {

	}

	void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, ClawGame.WIDTH, ClawGame.HEIGHT);

		g.setFont(titleFont);
		g.setColor(Color.RED);
		g.drawString("Arcade Claw", 150, 100);

		g.setFont(subFont);
		g.drawString("Press 'enter' to begin", 160, 300);
		g.drawString("Press 'space' for instructions", 125, 425);

	}

	void drawLeveloneState(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillRect(0, 0, ClawGame.WIDTH, ClawGame.HEIGHT);
		claw.draw(g);
		prize.draw(g);
	}

	void drawLeveltwoState(Graphics g) {
		g.setColor(Color.ORANGE);
		g.fillRect(0, 0, ClawGame.WIDTH, ClawGame.HEIGHT);
		claw.draw(g);
		prize.draw(g);

	}

	void drawEndState(Graphics g) {
		g.setColor(Color.GRAY);
		g.fillRect(0, 0, ClawGame.WIDTH, ClawGame.HEIGHT);

		g.setFont(titleFont);
		g.setColor(Color.BLACK);
		g.drawString("YOU WIN!!", 150, 100);

		g.setFont(subFont);
		g.drawString("Press 'enter' to restart", 160, 300);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (currentState == MENU) {
			updateMenuState();
		} else if (currentState == LEVELONE) {
			updateLeveloneState();
		} else if (currentState == LEVELTWO) {
			updateLeveltwoState();
		} else if (currentState == END) {
			updateEndState();
		}

		repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}
	void checkWin() {
		if (claw.down == false) {
			if (prize.x >= claw.x && prize.x <= claw.x + 25 && prize.y >= claw.y + 25 && prize.y <= claw.y + 35) {
				String response = JOptionPane.showInputDialog("congrats!, you have finished level 1. The next level will be harder. Please type 'ready' when you are ready to move on");
				if (response.trim().equals("ready")) {
					System.out.println("hi");
					currentState++;
					claw.x = 225;
					claw.y = 50;
					int numtwo = ran.nextInt(465)+5;
					prize.x = numtwo;
					prize.y = 400;

				} else {
					System.out.println(response);
				}
			} else if (claw.y > 50){
				currentState = MENU;
				JOptionPane.showMessageDialog(null, "You have lost and been returned to the main menu");

			}
		}

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
		
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			if (currentState == MENU) {
				JOptionPane.showMessageDialog(null,
						"Your instructions are to retrieve the missing beach ball using a the machine. We wish you the best of luck! P.S. there are no errors with this claw game");
			} else if (currentState == LEVELONE || currentState == LEVELTWO) {
				claw.down(false);
				checkWin();

			}
		}
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (currentState == END) {
				currentState = MENU;
			} else {
				currentState++;
			}
		}
		if (currentState == LEVELONE || currentState == LEVELTWO) {

			if (e.getKeyCode() == KeyEvent.VK_DOWN && claw.y <= 500) {
				System.out.println("down");
				claw.down(true);

			}
			if (e.getKeyCode() == KeyEvent.VK_LEFT && claw.x >= 0) {
				System.out.println("left");
				claw.left(true);
			}
			if (e.getKeyCode() == KeyEvent.VK_RIGHT && claw.x <= 500) {
				System.out.println("right");
				claw.right(true);
			}
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if (currentState == LEVELONE || currentState == LEVELTWO) {

			
			if (e.getKeyCode() == KeyEvent.VK_LEFT && claw.x >= 0) {
				System.out.println("left");
				claw.left(false);
			}
			if (e.getKeyCode() == KeyEvent.VK_RIGHT && claw.x <= 500) {
				System.out.println("right");
				claw.right(false);
			}
		}

	}
}
