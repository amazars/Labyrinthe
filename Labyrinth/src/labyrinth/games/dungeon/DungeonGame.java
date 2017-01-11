package labyrinth.games.dungeon;

import labyrinth.Direction;
import labyrinth.Game;
import labyrinth.Room;
import labyrinth.games.dungeon.DungeonGame;

public class DungeonGame extends Game{

	public static void main(String[] args) {
		new DungeonGame().play();
		
    }
	
    protected Room createRooms() {
    	Room c1_in, a2, b2, c2, e2, f2, a3, c3, d3, e3, a4_out, c4, d4, e4, c5, d5, f5, d6, e6, f6, e7, e8;
    	
    	// création des pièces
        c1_in = new Room("sur Tatooine");
        c2 = new Room("dans le faucon millenium");
        a2 = new Room("bloqué par Le Destroyer Stellaire classe - 1");
        a3 = new Room("en train de détruire le bouclier sur Endor");
        a4_out = new Room("dans l'étoile de la mort");
         
        // initialisation des sorties des pièces
        c1_in.setExit(Direction.SOUTH, c2);
		
        return c1_in;
    }

}
