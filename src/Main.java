/**
 * Created by Steven Hu on 2016-08-30.
 */
public class Main {
	public static void main(String[] args) throws InterruptedException {
		
		StandardUI window = new StandardUI();
		SKMWorld space = new SKMWorld(new PlayerLogic(), new EnemyLogic());
	
		
		do {
			window.updateScreen(space);
			
			do {
				space.readInput(window.readInput());
				Thread.sleep(10);
			}while (space.playerLogic.pause);
			
			space.update();
		}while(!space.isGameover());
		
		
		
		
		window.printGameOver();
	}
	
}
