import java.awt.Rectangle;

public class GameObject {
	 int x;
	 int y;
	 int width;
	 int height;
	 int speed = 0;
	 
	 Rectangle collisionBox;
	 
	 boolean isActive = true;
	 public GameObject(int x, int y, int width, int height) {
		// TODO Auto-generated constructor stub
	
		 this.collisionBox = new Rectangle(x, y, width, height);
		 
		 this.x = x;
		 this.y = y;
		 this.width = width;
		 this.height = height;
	 
	 }
	 
	 void update() {
		 collisionBox.setBounds(x,y,width,height);
	 }
	 
}
