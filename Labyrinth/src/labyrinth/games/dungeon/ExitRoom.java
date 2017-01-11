package labyrinth.games.dungeon;

import labyrinth.Game;
import labyrinth.Room;

public class ExitRoom extends Room{

	public ExitRoom(String description){
		super(description);
	}
	
	public boolean enter(Game game) {
        System.out.print("Vous avez gagné");
        beVisited();
	    return true;
	}
}
