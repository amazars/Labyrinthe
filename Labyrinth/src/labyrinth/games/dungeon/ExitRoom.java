package labyrinth.games.dungeon;

import labyrinth.Game;
import labyrinth.Room;

public class ExitRoom extends Room{
	private Room key1;
	private Room key2;
	
	public ExitRoom(String description) { 
		this(description, null); 
	}
	public ExitRoom(String description, Room key) { 
		this(description, key, null); 
	}
	/* constructeur officiel */
	public ExitRoom(String description, Room key1, Room key2) {
		super(description);
		this.key1 = key1;
		this.key2 = key2;
	}
	
	public boolean enter(Game game) {
		System.out.println(fullDescription());
		
		if(this.key1 == null && this.key2 == null){
			System.out.println("Vous avez gagné");
			beVisited();
			return true;
		}
		else if(this.key1 != null && this.key2 == null)
			if(this.key1.isVisited()){
				System.out.println("Vous avez gagné");
				beVisited();
				return true;
			}
			else{
				System.out.println("Il vous faut la clef 1");
				beVisited();
				return false;
			}
		else{
			if(this.key1.isVisited() && this.key2.isVisited()){
				System.out.println("Vous avez gagné");
				beVisited();
				return true;
			}
			else{
				System.out.println("Il vous manque encore une clef");
				beVisited();
				return false;
			}
		}
	}
}
