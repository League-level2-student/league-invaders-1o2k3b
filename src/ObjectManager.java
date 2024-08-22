import java.awt.Graphics;
import java.util.*;

public class ObjectManager {

	Rocketship ship;
	
	ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
	ArrayList<Alien> aliens = new ArrayList<Alien>();
	
	Random r = new Random();
	
	public ObjectManager(Rocketship s) {
		this.ship = s;
	}
	
	void addProjectile(Projectile p) {
		
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
		Iterator<Alien> a = aliens.iterator();
		while(a.hasNext()) {
			Alien al = a.next();
			if(!al.isActive) {
				a.remove();
			}
		}
		Iterator<Projectile> p = projectiles.iterator();
		while(p.hasNext()) {
			Projectile pro = p.next();
			if(!pro.isActive) {
				p.remove();
			}
		}
	}
	
	 
	
}
