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
		enemies.add(new Enemy(10,10));
	}
}
