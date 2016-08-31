import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Steven Hu on 2016-08-30.
 */
public class SKMWorld {
	List<Entity> players = new ArrayList<>();
	List<Entity> enemies = new ArrayList<>();
	
	List<Entity> playerBullets = new ArrayList<>();
	List<Entity> enemyBullets = new ArrayList<>();
	
	PlayerLogic playerLogic;
	EnemyLogic enemyLogic;
	String key;
	
	public SKMWorld(PlayerLogic playerLogic, EnemyLogic enemyLogic) {
		this.playerLogic = playerLogic;
		this.enemyLogic = enemyLogic;
		players.add(new Player(49, 28, 'O'));
		spawnEnemies();
//		enemies.add(new Enemy(10,10));
		
	}
	
	public void spawnEnemies() {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 10; j++) {
				enemies.add(new Enemy(j * 4 + 5, i * 2 + 5));
			}
		}
	}
	
	public void readInput(String key) {
		this.key = key;
	}
	
	public void update() {
		
		removeOnCollision(players, enemyBullets);
		removeOnCollision(players, enemies);
		removeOnCollision(playerBullets, enemies);
		
		playerLogic.run(key, players, playerBullets);
		enemyLogic.run(enemies, enemyBullets);
	}
	
	public boolean isGameover() {
		if (playerLogic.isGameOver(players) || enemyLogic.isGameOver(enemies)) {
			return true;
		}
		return false;
	}
	
	public void removeOnCollision(List<Entity> e1, List<Entity> e2) {
		
		for (Iterator<Entity> iterator = e1.iterator(); iterator.hasNext(); ) {
			Entity entity = iterator.next();
			for (Iterator<Entity> iterator2 = e2.iterator(); iterator2.hasNext(); ) {
				Entity entity2 = iterator2.next();
				
				if (entity.collide(entity2)) {
					iterator.remove();
					iterator2.remove();
					
				}
			}
		}
	}
}