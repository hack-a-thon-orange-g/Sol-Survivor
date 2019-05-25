import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;

public class Player {

	private int row;
	private int colum;
	private int dx;
	private int dy;
	public Player(int r, int c)
	{
		row = r;
		colum = c;
		dx = 0;
		dy = 0;
	}
	
	public void move(int direction) throws Exception
	{
		RemoveOldPlayer();
		dx = dy = 0;
		if(direction == KeyEvent.VK_UP)
			dy = -1;
		else if(direction == KeyEvent.VK_DOWN)
			dy = 1;
		else if(direction == KeyEvent.VK_RIGHT)
			dx = 1;
		else if(direction == KeyEvent.VK_LEFT)
			dx = -1;
		
		Map.Piece[][] temp = SolSurvivorGUI.getBoard().getBoard();
		
		if(row + dy >= 0 && row + dy <16 && colum + dx >= 0 && colum + dx < 12 && temp[row + dy][colum + dx] != Map.Piece.BASE) {

		
		
		
		
		
			SolSurvivorGUI.setSquare( row, colum, Map.Piece.PLAYER );
			temp[row][colum] = Map.Piece.PLAYER;
			SavePlayerLocate(row);
			SavePlayerLocateC(colum);

			row += dy;
			colum += dx;
		
			
			direction = 0;

			
		}
		else if(temp[row + dy][colum+dx]==Map.Piece.BASE) {
			JOptionPane.showMessageDialog(null,  "You are in base!");
		}
		
		else if(temp[row+dy][colum+dx] == Map.Piece.FUEL) {
			ResourceCounter();
		}
		
		
		
		
		
	}
	static int resourceCounter;
	static int SolCounter;
	static int SavedPlayerRow;
	static int SavedPlayerColum;
	public static int SavePlayerLocate(int row) {
		return( SavedPlayerRow = row);
	}
	public static int SavePlayerLocateC(int colum) {
		return( SavedPlayerColum = colum);
	}
	public static void RemoveOldPlayer() {
		SolSurvivorGUI.setSquare(SavedPlayerRow, SavedPlayerColum, Map.Piece.REDSAND );
	}
	
	public static void ResourceCounter() {
		resourceCounter++;
		System.out.println("Resource count = " + resourceCounter);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
