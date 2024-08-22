import java.awt.Color;
import java.awt.Graphics;

public class Rocketship extends GameObject {
	
	boolean movingUp = false;
	boolean movingDown = false;
	boolean movingLeft = false;
	boolean movingRight = false;
	
	
	public Rocketship(int x, int y, int width, int height) {
		// TODO Auto-generated constructor stub
		super(x,y,width,height);
		speed = 3;
		
	
	}

	void draw(Graphics g) {
		g.setColor(Color.blue);
		g.fillRect(x, y, width, height);
	}
//movement {
	public void up() {
		y-=speed;
	}
	public void down() {
		y+=speed;
	}
	public void right() {
		x+=speed;
	}
	public void left() {
		x-=speed;
	}
	
	void update() {
		if(movingUp) {
			up();
		}
		if(movingDown) {
			down();
		}
		if(movingLeft) {
			left();
		}
		if(movingRight) {
			right();
		}
	}
	// }
}
