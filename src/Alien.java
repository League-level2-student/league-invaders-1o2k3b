import java.awt.*;

public class Alien extends GameObject {

	public Alien(int x, int y, int width, int height) {
		// TODO Auto-generated constructor stub
		super(x,y,width,height);
		speed = 1;
		}
	
	void update() {
		y+= speed;
	}
	
	void draw(Graphics g) {
	       g.setColor(Color.YELLOW);
	        g.fillRect(x, y, width, height);
	}
	
}
