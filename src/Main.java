/**
 * Created by Steven Hu on 2016-08-30.
 */
public class Main {
	public static void main(String[] args) throws InterruptedException {
		SKMWorld space = new SKMWorld();
		
		StandardUI window = new StandardUI();
		
		SKMLogic logic = new SKMLogic(window, space);
		
		do {
			logic.updateGame();
			window.updateScreen(space);
			logic.action();
			Thread.sleep(5);
		}while(!logic.isGameOver());
		
		window.printGameOver();
	}
	
}
