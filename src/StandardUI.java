import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.terminal.Terminal;

import java.nio.charset.Charset;

/**
 * Created by Steven Hu on 2016-08-30.
 */
public class StandardUI{
	
	public Terminal terminal;
	
	//Skapa terminal
	public StandardUI() {
		this.terminal = TerminalFacade.createTerminal(System.in, System.out, Charset.forName("UTF8"));
		terminal.enterPrivateMode();
		terminal.setCursorVisible(false);
		
	}
	
	//Uppdatera skärmen
	public void updateScreen(SKMWorld space) {
		terminal.clearScreen();
		for (Entity player :
				space.players) {
			drawEntity(player);
		}
		
		for (Entity enemy :
				space.enemies) {
			drawEntity(enemy);
		}
		for (Entity bullet :
				space.enemyBullets) {
			drawEntity(bullet);
		}
		for (Entity bullet :
				space.playerBullets) {
			drawEntity(bullet);
		}
		
	}
	
	//Rita ut en Entity
	public void drawEntity(Entity entity){
		terminal.moveCursor(entity.getX(),entity.getY());
		terminal.putCharacter(entity.symbol);
	}
	
//	Rita ut start menyn
	public void printMeny() {
		
	}
	
	public void printGameOver(){
		System.out.println("GAME OVER");
	}
	
	public String readInput(){
		Key key;
		key = terminal.readInput();
		return key!= null ? (key.getKind() + " " + key.getCharacter()) :"";
	}
	
	
	
}
