import java.util.List;

/**
 * Created by Steven Hu on 2016-08-30.
 */
public interface GameLogic {
	void update(List<Entity> entities);
	boolean isGameOver(List<Entity> entities);
	void shoot(Entity entity, List<Entity> bullets);
}
