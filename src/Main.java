/**
 * Created by Steven Hu on 2016-08-30.
 */
public class Main {
	public static void main(String[] args) throws InterruptedException {
		StandardUI window = new StandardUI();
		SKMWorld space = new SKMWorld();
		GameLogic logic = new SKMLogic();
		
		do {
			
			window.updateScreen(space);
			
			Thread.sleep(5);
		}while(logic.isGameOver());
		
//		window.printVictory();
	}
	
}
