import java.awt.*;

public class Projectile extends GameObject {

	public Projectile(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed= 10;
	}

	void draw(Graphics g) {
    g.setColor(Color.red);
    g.fillRect(x, y, width, height);
	}
	
}
