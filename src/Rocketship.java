import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Rocketship extends GameObject {

	boolean movingUp = false;
	boolean movingDown = false;
	boolean movingLeft = false;
	boolean movingRight = false;

	public static boolean needImage = true;
	public static boolean gotImage = false;
	public static BufferedImage image;

	public Rocketship(int x, int y, int width, int height) {
		// TODO Auto-generated constructor stub
		super(x, y, width, height);
		speed = 3;
		if (needImage) {
			loadImage("rocket.png");
		}

	}

	void draw(Graphics g) {
		if (gotImage) {
			g.drawImage(image, x, y, width, height, null);
		} else {
			g.setColor(Color.BLUE);
			g.fillRect(x, y, width, height);
		}

	}

//movement {
	public void up() {
		y -= speed;
	}

	public void down() {
		y += speed;
	}

	public void right() {
		x += speed;
	}

	public void left() {
		x -= speed;
	}

	void update() {
		if (movingUp) {
			up();
		}
		if (movingDown) {
			down();
		}
		if (movingLeft) {
			left();
		}
		if (movingRight) {
			right();
		}
	}

	// }

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

	public Projectile getProjectile() {
		return new Projectile(x + width / 2, y, 10, 10);
	}

}
