package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener{
    final int MENU = 0;
    final int LEVELONE = 1;
    final int LEVELTWO = 2;
    final int END = 3;    
    int currentState = MENU;
    Font titleFont;
	Font subFont;
	Timer frameDraw;
	Claw claw = new Claw(200, 50, 50, 50);



    
	@Override
	public void paintComponent(Graphics g){
		//g.fillRect(225, 50, 50, 50);
		if(currentState == MENU){
		    drawMenuState(g);
		}else if(currentState == LEVELONE){
		    drawLeveloneState(g);
		}else if(currentState == LEVELTWO) {
			drawLeveltwoState(g);
		}else if(currentState == END){
		    drawEndState(g);
		}
	}
		GamePanel(){
		    titleFont = new Font("Arial", Font.PLAIN, 36);
		    subFont = new Font("Arial", Font.PLAIN, 18);
		    frameDraw = new Timer(1000/60,this);
		    frameDraw.start();

		}

	
	
	void  updateMenuState() { 
		
	}
	void  updateLeveloneState() { 
		
	}
	void updateLeveltwoState() {
		
	}
	void updateEndState()  { 
		
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
	}
	void drawLeveltwoState(Graphics g) {
		g.setColor(Color.ORANGE);
		g.fillRect(0, 0, ClawGame.WIDTH, ClawGame.HEIGHT);
	}
	void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, ClawGame.WIDTH, ClawGame.HEIGHT);
		
		g.setFont(titleFont);
		g.setColor(Color.BLACK);
		g.drawString("Game Over", 150, 100);
		
		g.setFont(subFont);
		g.drawString("Press 'enter' to begin", 160, 300);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(currentState == MENU){
		    updateMenuState();
		}else if(currentState == LEVELONE){
		    updateLeveloneState();
		}else if (currentState == LEVELTWO) {
			updateLeveltwoState();
		}else if(currentState == END){
		    updateEndState();
		}
		
		repaint();
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode()==KeyEvent.VK_ENTER) {
		    if (currentState == END) {
		        currentState = MENU;
		    } else {
		        currentState++;
		    }
		}   
		if (currentState == LEVELONE) {
			if (e.getKeyCode()==KeyEvent.VK_UP) {
			    System.out.println("UP");
			}
			if (e.getKeyCode()==KeyEvent.VK_DOWN) {
			    System.out.println("down");
			}
			if (e.getKeyCode()==KeyEvent.VK_LEFT) {
			    System.out.println("left");
			}
			if (e.getKeyCode()==KeyEvent.VK_RIGHT) {
			    System.out.println("right");
			}
		}
		if (currentState == LEVELTWO) {
			if (e.getKeyCode()==KeyEvent.VK_UP) {
			    System.out.println("UP");
			}
			if (e.getKeyCode()==KeyEvent.VK_DOWN) {
			    System.out.println("down");
			}
			if (e.getKeyCode()==KeyEvent.VK_LEFT) {
			    System.out.println("left");
			}
			if (e.getKeyCode()==KeyEvent.VK_RIGHT) {
			    System.out.println("right");
			}
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	}


