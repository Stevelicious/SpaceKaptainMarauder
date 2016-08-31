/**
 * Created by Steven Hu on 2016-08-30.
 */
public class Main {
	public static void main(String[] args) throws InterruptedException {
		
		StandardUI window = new StandardUI();
		SKMWorld space = new SKMWorld(new PlayerLogic(), new EnemyLogic());
		
		window.printMeny();
		boolean inMenu = true;
		do{
			switch (window.readInput()){
				case "NormalKey 1":
					inMenu = false;
					break;
				case "NormalKey 3":
					System.exit(0);
			}
		}while (inMenu);
		
		
		do {
			window.updateScreen(space);
			do {
				space.readInput(window.readInput());
			}while (space.pause);
			space.update();
			Thread.sleep(10);


		} while (!space.isGameover());
		
		
		window.printGameOver();
	}
	
}
