import javax.swing.JFrame;

public class LeagueInvaders {

JFrame frame;
public static final int WIDTH = 500;
public static final int HEIGHT = 800; 
GamePanel G;

public LeagueInvaders() {
	// TODO Auto-generated constructor stub 
	this.frame = new JFrame();
	this.G = new GamePanel();
}
void setup() {
	frame.setVisible(true);
	frame.setSize(WIDTH, HEIGHT);
	frame.add(G);                 
	frame.addKeyListener(G); 
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
public static void main(String[] args) {
LeagueInvaders L = new LeagueInvaders();
L.setup();

}
}
