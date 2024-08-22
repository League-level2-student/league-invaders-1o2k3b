import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class GamePanel extends JPanel implements ActionListener , KeyListener {
	final int MENU = 0;
	final int GAME = 1;
	final int END = 2;
	
	

	int currentState = MENU;

	Rocketship ship = new Rocketship(250, 700, 50, 50);
	ObjectManager manager = new ObjectManager(ship);
	
	Font titleFont;
	Font textFont;
	Font endFont;

	Timer frameDraw;

	GamePanel() {
		this.titleFont = new Font("Arial", Font.PLAIN, 48);
		this.textFont = new Font("Arial", Font.PLAIN, 25);
		this.endFont = new Font("Arial", Font.BOLD, 32);
		
		this.frameDraw = new Timer(1000 / 60, this);
		this.frameDraw.start();
		
		
	}

	@Override
	public void paintComponent(Graphics g) {
		if (currentState == MENU) {
			drawMenuState(g);
		} else if (currentState == GAME) {
			drawGameState(g);
		} else if (currentState == END) {
			drawEndState(g);
		}
	}

	void updateMenuState() {

	}

	void updateGameState() {
manager.update();
	}

	void updateEndState() {

	}

	void drawMenuState(Graphics g) {
		// rectangle color

		g.setColor(Color.BLUE);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);

		// font color

		g.setFont(titleFont);
		g.setColor(Color.YELLOW);
		g.drawString("LEAGUE INVADERS", 22, 100);
		g.setFont(textFont);
		g.setColor(Color.YELLOW);
		g.drawString("press ENTER to start", 100, 375);
		g.setFont(textFont);
		g.setColor(Color.YELLOW);
		g.drawString("press SPACEBAR for instruction", 50, 525);

	}

	void drawGameState(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		
		manager.draw(g);
	}

	void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		
		g.setFont(endFont);
		g.setColor(Color.BLACK);
		g.drawString("YOUR SHIP WAS DESTROYED", 15, 100);
		g.setFont(textFont);
		g.setColor(Color.BLACK);
		g.drawString("press ENTER to return to menu", 75, 375);
		g.setFont(textFont);
		g.setColor(Color.BLACK);
		g.drawString("you killed enemies", 128, 525);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		// TODO Auto-generated method stub

		if (currentState == MENU) {
			updateMenuState();
		} else if (currentState == GAME) {
			updateGameState();
		} else if (currentState == END) {
			updateEndState();
		}
		
		//System.out.println("action");
		repaint();
		
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
		
		if(currentState == GAME) {
	
			if(e.getKeyCode()==KeyEvent.VK_UP) {
		    ship.movingUp = true;
		    }
		    if(e.getKeyCode()==KeyEvent.VK_DOWN) {
		    	 ship.movingDown = true;
		    }
		    if(e.getKeyCode()==KeyEvent.VK_LEFT) {
		    	 ship.movingLeft = true;
		    }
		    if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
		    	 ship.movingRight = true;
		    }
		}
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if(currentState == GAME) {
			
			if(e.getKeyCode()==KeyEvent.VK_UP) {
		    ship.movingUp = false;
		    }
		    if(e.getKeyCode()==KeyEvent.VK_DOWN) {
		    	 ship.movingDown = false;
		    }
		    if(e.getKeyCode()==KeyEvent.VK_LEFT) {
		    	 ship.movingLeft = false;
		    }
		    if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
		    	 ship.movingRight = false;
		    }
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
