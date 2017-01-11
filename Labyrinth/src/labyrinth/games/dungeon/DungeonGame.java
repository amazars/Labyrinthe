package labyrinth.games.dungeon;

import labyrinth.Direction;
import labyrinth.Game;
import labyrinth.Room;
import labyrinth.games.campus.CampusGame;

public class DungeonGame extends Game{

	public static void main(String[] args) {
		new CampusGame().play();
    }

    protected Room createRooms() {
    	Room outside, hall, amphi, cafet, lab, office;

        // création des pièces
        outside = new Room("à l'extérieur de l'entrée principale de l'Université");
		return outside;
    	
    }

}
