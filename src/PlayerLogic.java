import java.util.Iterator;
import java.util.List;

/**
 * Created by Steven Hu on 2016-08-31.
 */
public class PlayerLogic implements GameLogic {

	

	public void run(String key,List<Entity> players, List<Entity> bullets){
		
		action(key, players, bullets);
		update(bullets);
		
	}
	@Override
	public void shoot(Entity entity, List<Entity> bullets) {
		bullets.add(new Bullet(entity.x, entity.y));
	}
	
	@Override
	public void update(List<Entity> entities) {
		
		for (Iterator<Entity> iterator = entities.iterator(); iterator.hasNext(); ) {
			Entity bullet = iterator.next();
			if (bullet.y > 0) {
				bullet.y -= bullet.speed;
			} else {
				iterator.remove();
			}
		}
	}
	
	@Override
	public boolean isGameOver(List<Entity> players) {
		if (players.isEmpty()){
			return true;
		}
		return false;
	}
	
	
	public void action(String key, List<Entity> players, List<Entity> bullets) {
		switch (key) {
			case "ArrowLeft L":
				if (players.get(0).x > 0) {
					players.get(0).x--;
				}
				break;
			case "ArrowRight R":
				if (players.get(0).x < 99) {
					players.get(0).x++;
				}
				break;
			case "NormalKey  ":
				shoot(players.get(0), bullets);
				break;
			case "Escape \\":
				System.exit(0);
			
		}
	}
}
