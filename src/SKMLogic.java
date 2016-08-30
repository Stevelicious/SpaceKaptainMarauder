import com.googlecode.lanterna.input.Key;

import java.util.Collections;
import java.util.Iterator;

/**
 * Created by Steven Hu on 2016-08-30.
 */
public class SKMLogic implements GameLogic {
	private StandardUI ui;
	private SKMWorld space;
	
	public SKMLogic(StandardUI ui, SKMWorld space) {
		this.ui = ui;
		this.space = space;
		
	}
	
	public boolean collide(Entity e1, Entity e2) {
		if (e1.getX() == e2.getX() && e1.getY() == e2.getY()) {
			return true;
		}
		return false;
	}
	
	@Override
	public String readInput() {
		Key key;
		key = ui.terminal.readInput();
		if (key != null) {
			return key.getKind() + " " + key.getCharacter();
		} else
			return "";
	}
	
	@Override
	public boolean isGameOver() {
		if (space.enemies.isEmpty()) {
			return true;
		}
		return false;
	}
	
	public void action() {
		switch (readInput()) {
			case "ArrowLeft L":
				if (space.players.get(0).x > 0) {
					space.players.get(0).x--;
				}
				break;
			case "ArrowRight R":
				if (space.players.get(0).x < 99) {
					space.players.get(0).x++;
				}
				break;
			case "NormalKey  ":
				shoot(space.players.get(0));
				break;
			case "Escape \\":
				System.exit(0);
			case "NormalKey p":
				break;
		}
	}
	
	public void shoot(Entity entity) {
		if (entity instanceof Player) {
			space.playerBullets.add(new Bullet(entity.x, entity.y));
		}
	}
	
	public void updateGame() {
		for (Iterator<Bullet> iterator = space.playerBullets.iterator(); iterator.hasNext(); ) {
			Bullet bullet = iterator.next();
			if (bullet.y > 0) {
				bullet.y -= bullet.speed;
			} else {
				iterator.remove();
			}
		}
		
		for (Iterator<Bullet> iterator = space.enemyBullets.iterator(); iterator.hasNext(); ) {
			Bullet bullet = iterator.next();
			if (bullet.y > 0) {
				bullet.y -= bullet.speed;
			} else {
				iterator.remove();
			}
		}
		
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (Entity enemy :
				space.enemies) {
			max = Math.max(max, enemy.getX());
			min = Math.min(min, enemy.getX());
		}
		
		for (Entity enemy :
				space.enemies) {
			if (enemy.y % 2 == 0) {
				enemy.x -= enemy.speed;
				if (min < 5){
					enemy.y++;
				}
			} else {
				enemy.x += enemy.speed;
				if (max > 95){
					enemy.y++;
				}
			}
		}
		
		//Check for collision
		
		for (Iterator<Bullet> iterator = space.playerBullets.iterator(); iterator.hasNext(); ) {
			Bullet bullet = iterator.next();
			for (Iterator<Enemy> enemyIterator = space.enemies.iterator(); enemyIterator.hasNext(); ) {
				Enemy enemy = enemyIterator.next();
				if (collide(bullet, enemy)) {
					iterator.remove();
					enemyIterator.remove();
				}
			}
		}
	}
	
}
	
	

