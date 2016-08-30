import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.terminal.Terminal;

/**
 * Created by Steven Hu on 2016-08-30.
 */
public class SKMLogic implements GameLogic{
	
	public boolean collide(Entity e1, Entity e2) {
		if (e1.x == e2.x && e1.y == e2.y) {
			return true;
		}
		return false;
	}
	
	@Override
	public void readInput() throws InterruptedException {
		Key key;
		Thread.sleep(50);
		key = terminal.readInput();
	}
	
	@Override
	public boolean isGameOver() {
		if (space.enemies.isEmpty()) {
			return false;
		}
		return true;
	}


//	private void hitDetect(Player player, Enemy enemies, Terminal terminal) {
//		if (player.bullets != null) {
//
//			for (int i = 0; i < player.bullets.size(); i++) {
//				player.bullets.get(i).move();
//
//				if (player.bullets.get(i).y <= 0) {
//					player.bullets.remove(i);
//				} else if (enemies == null) {
//					break;
//				} else if (collide(player.bullets.get(i), enemies.g)) {
//					player.bullets.remove(i);
//					enemies.remove(0);
//					break;
//				} else {
//					terminal.moveCursor((int) player.bullets.get(i).x, (int) player.bullets.get(i).y);
//					terminal.putCharacter(player.bullets.get(i).symbol);
//				}
//			}
//
//		}
//
//	public boolean isVictory() {
//		if (enemies.isEmpty()) {
//			return false;
//		}
//		return true;
//	}
//
//	public void printVictory() {
//		terminal.clearScreen();
//		terminal.moveCursor(40, 10);
//		String gOver = "VICTORY";
//		for (char c :
//				gOver.toCharArray()) {
//			terminal.putCharacter(c);
//		}
//	}
//
//	public void gameLogic() throws InterruptedException {
//		Key key;
//
//
//		Thread.sleep(50);
//		key = terminal.readInput();
//
//		if (key != null) {
//			System.out.println(key.getKind() + " " + key.getCharacter());
//			switch (key.getKind() + " " + key.getCharacter()) {
//				case "ArrowLeft L":
//					player.x--;
//					break;
//				case "ArrowRight R":
//					player.x++;
//					break;
//				case "NormalKey  ":
//					player.shoot();
//					break;
//				case "Escape \\":
//					System.exit(0);
//				case "NormalKey p":
//					break;
//			}
//
//		}
//	}
}
	
	

