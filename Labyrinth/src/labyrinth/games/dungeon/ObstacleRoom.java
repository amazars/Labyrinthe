package labyrinth.games.dungeon;

import labyrinth.Direction;
import labyrinth.Game;
import labyrinth.Room;
import labyrinth.games.dungeon.DungeonGame;

public class ObstacleRoom extends Room{
	private int difficulty;
	public ObstacleRoom(String description, int difficulte) {
		super(description);
		difficulty = difficulte;
	}
	
	@Override
	public boolean enter(Game game) {
        System.out.println(fullDescription());
        System.out.println("vous perdez "+this.difficulty+" points de vie");
        ((DungeonGame) game).setHealthDown(this.difficulty);
        beVisited();
        return false;
    }
	
}
