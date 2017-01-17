package labyrinth.games.dungeon;

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
        System.out.println("vous perdez "+this.difficulty+" points de force");
        ((DungeonGame) game).setHealthDown(this.difficulty);
        beVisited();
        return false;
    }
	
	@Override
	public char characterDescription() { return intToChar(this.difficulty); }
	
	private char intToChar(int i){
		String s=""+i;
		return s.charAt(0);
	}
}
