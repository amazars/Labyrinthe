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
	
	public boolean enter(Game game) {
        System.out.println(fullDescription());
        game.setHealth(this.difficulty);
        beVisited();
        return false;
    }
	
}
