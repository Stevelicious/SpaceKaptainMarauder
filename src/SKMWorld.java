import java.util.ArrayList;
import java.util.List;

/**
 * Created by Steven Hu on 2016-08-30.
 */
public class SKMWorld{
	List<Player> players = new ArrayList<>();
	List<Enemy> enemies = new ArrayList<>();
	
	List<Bullet> playerBullets = new ArrayList<>();
	List<Bullet> enemyBullets = new ArrayList<>();
	
	public SKMWorld() {
		players.add(new Player(49,28,'O'));
		spawnEnemies();
//		enemies.add(new Enemy(10,10));
	}
	
	public void spawnEnemies(){
		for (int i = 5; i < 10; i+=2) {
			for (int j = 10; j < 40; j+=4) {
				enemies.add(new Enemy(j, i));
			}
		}
	}
}
