package labyrinth.games.dungeon;

import labyrinth.Game;
import labyrinth.Room;
import labyrinth.games.dungeon.DungeonGame;

public class BonusRoom extends Room{
	private int bonus;

	public BonusRoom(String description, int bonus) {
		super(description);
		this.bonus = bonus;
	}


	// La consigne nous dit de extend notre enter. On doit donc reprendre la même fonction. 
	public boolean enter(Game game) {
		System.out.println(fullDescription());
		if( isVisited() == false){
			System.out.println("vous gagnez "+this.bonus+" points de force");
			((DungeonGame) game).setHealthUp(this.bonus);
		}
	    beVisited();
	    return false;
	}
	
	@Override
	public char characterDescription() {return '+';}
	
}