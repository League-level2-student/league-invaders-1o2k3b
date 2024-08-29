import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class ObjectManager implements ActionListener{

	Rocketship ship;

	ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
	ArrayList<Alien> aliens = new ArrayList<Alien>();

	Random r = new Random();
	int score = 0;
	GamePanel p;

	ObjectManager(Rocketship s, GamePanel gamePanel) {
		this.ship = s;
		this.p = gamePanel;
		addAlien();
	}

	void addProjectile(Projectile p) {
		projectiles.add(p);
	}

	void addAlien() {
		aliens.add(new Alien(r.nextInt(LeagueInvaders.WIDTH),0,50,50));
	}

	void update() {
		ship.update();
	

		for(Alien a: aliens) {
			a.update();
			if(a.y > LeagueInvaders.HEIGHT) {
				a.isActive = false;
			}
		}
		for(Projectile p: projectiles) {
			p.update();
			if(p.y < 0) {
				p.isActive = false;
			}
		}

		checkCollision();
		purgeObjects();

	}

	void draw(Graphics g) {
		ship.draw(g);
		for(Alien a:aliens) {
			a.draw(g);
		}
		for(Projectile p: projectiles) {
			p.draw(g);
		}
	}

	void purgeObjects() {
		Iterator<Alien> aIter = aliens.iterator();
		while(aIter.hasNext()) {
			Alien a = aIter.next();
			if(!a.isActive) {
				aIter.remove();
			}
		}
		Iterator<Projectile> pIter = projectiles.iterator();
		while(pIter.hasNext()) {
			Projectile pro = pIter.next();
			if(!pro.isActive) {
				pIter.remove();
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

		addAlien();
	//	System.out.println(aliens.size());	
	}

	void checkCollision() {
		for(Alien a:aliens) {
			for(Projectile p:projectiles) {
				if(p.collisionBox.intersects(a.collisionBox)) {
					p.isActive = false;
					a.isActive = false;
					score++;
					System.out.println(score);
					
				}
				
			}
			if(a.collisionBox.intersects(ship.collisionBox)) {
				a.isActive = false;
				ship.isActive = false;
			
				p.currentState = p.END;
			}
		}
	}

}
