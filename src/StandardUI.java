import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
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
		printToTerminal("lib\\menu.txt");
	}
	
	public void printGameOver(){
		
		printToTerminal("lib\\victory.txt");
	}
	
	public String readInput(){
		Key key;
		key = terminal.readInput();
		return key!= null ? (key.getKind() + " " + key.getCharacter()) :"";
	}
	
	public void printToTerminal(String filnamn) {
		
		
		try (BufferedReader br = new BufferedReader(new FileReader(filnamn))) {
			terminal.clearScreen();
			String text;
			int i = 0;
			while ((text = br.readLine()) != null) {
				terminal.moveCursor(0,i);
				for (char c : text.toCharArray()) {
					terminal.putCharacter(c);
				}
				i++;
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
