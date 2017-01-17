package labyrinth.games.dungeon;

import labyrinth.Direction;
import labyrinth.Game;
import labyrinth.Room;
import labyrinth.games.dungeon.DungeonGame;

public class DungeonGame extends Game{
	 protected int healthPoints;
	 protected int dec;
	 
	public static void main(String[] args) {
		// 15 points de départ, 1 point en moins à chaque déplacement
		new DungeonGame(15, 1).play();
    }
	
	public DungeonGame(int healthPoints, int dec){
		this.healthPoints=healthPoints+dec; /* On ajoute +dec car on modifie healthPoints dès le début du jeu*/
		this.dec=dec;
	}
	
	public void setHealthDown(int difficulte){
    	healthPoints -= difficulte;
    }
    public void setHealthUp(int bonus){
    	healthPoints += bonus;
    }
    
    protected Room createRooms() {
    	Room c1_in, a2, b2, c2, f3, a3, c3, d3, e3, a4_out, c4, e4, e5, c5, d5, d6;
    	
    	// création des pièces
    	a2 = new MonsterRoom("bloqué par Le Destroyer Stellaire classe - 1"); //bloqué il faut la force
        a3 = new Room("en train de détruire le bouclier sur Endor");
        b2 = new Room("sur Yog 'Dhul"); 
        c1_in = new Room("sur Tatooine");
        c2 = new Room("dans le Faucon Millenium");
        c3 = new Room("sur Ando");
        c4 = new ObstacleRoom("dans la zone d'un Patrouilleur Firespray de Booba Fett", 2); //perte de point
        c5 = new Room("sur Colomus");
        d3 = new Room("sur Naboo");
        d5 = new Room("sur Coruscant");
        d6 = new ObstacleRoom("touché par un escadon de clones", 3); //perte de point
        e3 = new Room("sur Dagoba, vous vous êtes ecrasé"); //perte d'un point une seul fois
        e4 = new Room("sur Mustafar");
        e5 = new BonusRoom("sur Hoth, Obi-Wan se revèle à vous", 4); //gain de force
        f3 = new Room("salué par Yoda, il vous remet la clef pour aller sur l'étoile noir"); //gain de clefs
      
        a4_out = new ExitRoom("dans l'étoile de la mort", f3);
        
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
        e3.setExit(Direction.WEST, d3);
        e3.setExit(Direction.SOUTH, e4);
        e3.setExit(Direction.EAST, f3);
        e4.setExit(Direction.NORTH, e3);
        e4.setExit(Direction.SOUTH, e5);
        e5.setExit(Direction.NORTH, e4);
        e5.setExit(Direction.WEST, d5);
        f3.setExit(Direction.WEST, e3);
        
        return c1_in;
    }
    

	/**
     * Déplacement du joueur.
     *
     * L'entrée dans une salle peut conclure le jeu (en cas de victoire, par exemple); cette
     * décision est déléguée à la salle de destination.
     *
     * @param room Salle dans laquelle le joueur arrive.
     * @return <code>true</code> si le jeu est fini.
     * @see Room#enter(Game)
     */
	@Override
    protected boolean enterRoom(Room room) {
        currentRoom = room;
        healthPoints=healthPoints-dec;
        boolean enter=currentRoom.enter(this);
        
        if (enter==false){	/*false indique que currentRoom n'est pas une sortie*/
        	if (healthPoints<=0){
        	  
        		System.out.println("Vous avez 0 point de force.");
        		System.out.println("Vous êtes mort ! La partie est perdue.");
        		return true;
        	}
        	else{
        		if (healthPoints==1){
        			System.out.println("Vous avez 1 point de force.");
        		}
        		else{
        			System.out.println("Vous avez "+ healthPoints+" points de force.");
        		}
        	}
        }
        return enter;
    }
	

}
