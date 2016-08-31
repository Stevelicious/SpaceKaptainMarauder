import com.googlecode.lanterna.input.Key;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * Created by Steven Hu on 2016-08-30.
 */
public class EnemyLogic implements GameLogic {
	private Random rng = new Random();
	
	
	public void run(List<Entity> enemies, List<Entity> bullets){
		
		moveEnemy(enemies, bullets);
		update(bullets);
		
	}
	
	@Override
	public boolean isGameOver( List<Entity> entites) {
		if (entites.isEmpty()) {
			return true;
		}
		return false;
	}
	
	
	public void shoot(Entity entity, List<Entity> bullets) {
		bullets.add(new Bullet(entity.x, entity.y));
		
	}
	
	@Override
	public void update( List<Entity> bullets) {

//		Move enemy bullets
		for (Iterator<Entity> iterator = bullets.iterator(); iterator.hasNext(); ) {
			Entity bullet = iterator.next();
			if (bullet.y < 29) {
				bullet.y += bullet.speed;
			} else {
				iterator.remove();
			}
		}
		
	}
public void moveEnemy(List<Entity> enemies, List<Entity> bullets){
//		Move enemy
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (Entity enemy :
				enemies) {
			max = Math.max(max, enemy.getX());
			min = Math.min(min, enemy.getX());
		}
		
		for (Entity enemy :
				enemies) {
			if (enemy.y % 2 == 0) {
				enemy.x -= enemy.speed;
				if (min < 5) {
					enemy.y++;
				}
			} else {
				enemy.x += enemy.speed;
				if (max > 95) {
					enemy.y++;
				}
			}
//			Enemy randomly shooting
			if (rng.nextDouble() > 0.999941) {
				shoot(enemy, bullets);
			}
		}
		
	}
	
}
	
	

