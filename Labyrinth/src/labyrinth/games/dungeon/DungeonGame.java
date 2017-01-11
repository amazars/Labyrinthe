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
    	Room c1_in, a2, b2, c2, f3, a3, c3, d3, e3, a4_out, c4, e4, e5, c5, d5, f5, d6;
    	
    	// création des pièces
    	a2 = new Room("bloqué par Le Destroyer Stellaire classe - 1"); //bloqué il faut la force
        a3 = new Room("en train de détruire le bouclier sur Endor");
        a4_out = new Room("dans l'étoile de la mort");
        b2 = new Room("sur Yog 'Dhul"); 
        c1_in = new Room("sur Tatooine");
        c2 = new Room("dans le Faucon Millenium");
        c3 = new Room("sur Ando");
        c4 = new ObstacleRoom("touché par le Patrouilleur Firespray de Booba Fett", 1); //perte de point
        c5 = new Room("sur Colomus");
        d3 = new Room("sur Naboo");
        d5 = new Room("sur Coruscant");
        d6 = new ObstacleRoom("touché par un escadon de clones", 3); //perte de point
        e3 = new Room("sur Dagoba, vous vous êtes ecrasé"); //perte d'un point une seul fois
        e4 = new Room("sur Mustafar");
        e5 = new Room("sur Hoth, Obi-Wan se revèle à vous"); //gain de force
        f3 = new Room("salué par Yoda"); //gain de force : clefs
        
        
        // initialisation des sorties des pièces
        a2.setExit(Direction.EAST, b2);
        a2.setExit(Direction.SOUTH, a3);
        a3.setExit(Direction.SOUTH, a4_out);
        a3.setExit(Direction.NORTH, a2);
        b2.setExit(Direction.WEST, a2);
        b2.setExit(Direction.EAST, c2);
        c1_in.setExit(Direction.SOUTH, c2);
        c2.setExit(Direction.WEST, b2);
        c2.setExit(Direction.SOUTH, c3);
        c3.setExit(Direction.EAST, d3);
        c3.setExit(Direction.SOUTH, c4);
        c3.setExit(Direction.NORTH, c2);
        c4.setExit(Direction.SOUTH, c5);
        c4.setExit(Direction.NORTH, c3);
        c5.setExit(Direction.EAST, d5);
        c5.setExit(Direction.NORTH, c4);
        d3.setExit(Direction.WEST, c3);
        d3.setExit(Direction.EAST, e3);
        d5.setExit(Direction.EAST, e5);
        d5.setExit(Direction.SOUTH, d6);
        d5.setExit(Direction.WEST, c5);
        d6.setExit(Direction.NORTH, d5);
        e3.setExit(Direction.EAST, d3);
        e3.setExit(Direction.SOUTH, e4);
        e3.setExit(Direction.EAST, f3);
        e4.setExit(Direction.NORTH, e3);
        e4.setExit(Direction.SOUTH, e5);
        e5.setExit(Direction.NORTH, e4);
        e5.setExit(Direction.WEST, d5);
        f3.setExit(Direction.WEST, e3);
        
        return c1_in;
    }

}
