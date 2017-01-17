package labyrinth.games.dungeon;

import java.util.Random;

import labyrinth.Game;
import labyrinth.Room;

public class MonsterRoom extends Room{
	private int monsterHealth;
	private int monsterHit; 
	private int monsterDamage;
	
	public MonsterRoom(String description) {
		super(description);
		Random rand = new Random();
		monsterHealth = rand.nextInt(6 - 2 + 1) + 2; //max 5 min 2
		monsterHit = rand.nextInt(6 - 2 + 1) + 2;
		monsterDamage = rand.nextInt(5 - 2 + 1) + 2;
	}
	
	@Override
	public boolean enter(Game game) {
		
        if(this.monsterHealth > 0){
        	System.out.println(fullDescription());
        	System.out.println("Il a "+ this.monsterHealth+" point de vie.");
        	
        	System.out.println("Il vous inflige "+ this.monsterDamage+" point de dégat.");
        	((DungeonGame) game).setHealthDown(this.monsterDamage);
        	
        	System.out.println("vous lui infligez "+this.monsterHit+" points de dégat.");
        	this.monsterHealth -= this.monsterHit;
       
        	if(this.monsterHealth <= 0){
        		System.out.println("Le monstre est mort.");
        	}
        }else{
        	System.out.println("La voie est libre.");
        }
        
        beVisited();
        return false;
    }
	
	
	@Override
	public char characterDescription() { 
		if(this.monsterHealth > 0)
			return '$';
		else
			return ' '; 
	}
	
	
}

