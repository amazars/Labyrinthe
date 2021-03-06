package labyrinth;


public abstract class Game {
    protected Room currentRoom;
   

    /**
     * Construction du labyrinthe et de sa carte interne.
     */
    public Game() {
        currentRoom = this.createRooms();
    }

    /**
     * Construction des salles et des liens d'adjacence entre elles dans le monde.
     *
     * La salle  retournée par cette méthode deviendra le point de départ du jeu. Toutes les autres
     * salles doivent être connexes, directement ou non, à cette salle de départ. Pour le bon
     * fonctionnement du plan, la topologie doit s'aligner une grille plane, sans chevauchement.
     *
     * @return La salle de départ du jeu.
     * @see Plan
     */
    protected abstract Room createRooms();

    /**
     * @return La salle où est le joueur.
     */
    public Room currentRoom() { return currentRoom; }

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
    protected boolean enterRoom(Room room) {
        currentRoom = room;
        return currentRoom.enter(this);
    }
    
    
    /**
     * Boucle principale du jeu. Demande et exécute des commandes jusqu'à la fin du jeu.
     */
    public void play() {
        this.printWelcome();
        enterRoom(currentRoom);

        boolean finished = false;
        while (!finished) {
            Command command = Command.readCommand();
            finished = processCommand(command);
        }

        this.printGoodbye();
    }

    /**
     * Aiguillage vers le traitement d'une commande individuelle; rejet des commandes inexistantes.
     *
     * @param cmd La commande entrée par le joueur.
     * @return <code>true</code> si le jeu est fini.
     */
    protected boolean processCommand(Command cmd) {
        if (cmd.isUnknown()) {
            System.out.println("Je ne comprends pas cette commande...");
            return false;
        }

        boolean wantToQuit = false;
        String verb = cmd.getVerb();
        if (verb.equals("aide")) {
            printHelp(cmd);
        } else if (verb.equals("plan")) {
            printMap(cmd);
        } else if (verb.equals("quitter")) {
            wantToQuit = processQuit(cmd);
        } else if (verb.equals("aller")) {
            wantToQuit = processGo(cmd);
        }
        return wantToQuit;
    }

    /**
     * Commande <code>aller</code>: déplacement du joueur.
     *
     * Vérifie la présence en argument du nom d'une des {@link Direction directions cardinales}, et
     * d'une salle adjacente.
     *
     * @param command La commande <code>aller</code> à exécuter.
     * @return <code>true</code> si le déplacement a provoqué la fin du jeu.
     */
    protected boolean processGo(Command command) {
        Room exit = null;
        Direction dir = null;

        dir = Direction.named(command.getArgument());
        if (dir == null) { // direction absente ou mal formée
            System.out.println("Aller où ?");
            return false;
        }

        exit = currentRoom.getExit(dir);
        if (exit == null) { // pas de salle adjacente
            System.out.println("Impossible d'aller par là !");
            return false;
        }

        return enterRoom(exit);
    }

    /**
     * Commande <code>quitter</code>: sortie volontaire du jeu.
     *
     * @param command La commande <code>quitter</code> à exécuter.
     * @return <code>true</code> si la commande est valide.
     */
    protected boolean processQuit(Command command) {
        if (command.hasArgument()) {
            // l'utilisateur pensait peut-être pouvoir quitter un endroit...
            System.out.println("Quitter quoi ?");
            return false;
        } else {
            return true;
        }
    }

    /**
     * Commande <code>plan</code>.
     *
     * @param command La commande <code>plan</code> à exécuter.
     */
    private void printMap(Command command) { System.out.println(new Plan(currentRoom)); }

    /**
     * Commande <code>aide</code>: rappel des commandes disponibles.
     *
     * @param command La commande <code>aide</code> à exécuter.
     */
    private void printHelp(Command command) {
        System.out.println("Vous êtes perdu. Vous êtes seul.");
        System.out.println();
        System.out.print("Les commandes sont :");
        Command.printAll();
    }

    /**
     * Message d'accueil dans le jeu.
     */
    protected void printWelcome() {

		System.out.println("    .          __---__");
		System.out.println("  .     .   .-'...:...'-.               .          .");
		System.out.println("           / .  . : .__ .\\  .");    
		System.out.println("    .     /........./  \\ .\\ .   .                  .");
		System.out.println("         / :  :   :| () | :\\                  .        .");
		System.out.println("        :...........\\__/....:         .");
		System.out.println(" .      |___________________|              .   ");               
		System.out.println("        |...................|               .");
		System.out.println("  .     :  :  :   :   :   : :                          .");
		System.out.println("      .  \\................./      .            .");
		System.out.println("          \\  .  . : .  .  /   .            ");
		System.out.println(".      .   \\._........._./  .        .                   .");
		System.out.println("              -..___..-                .         .");
        System.out.println();
        System.out.println("Bienvenue jeune padawan, que la force soit avec vous !");
        System.out.println();
        System.out.println("Si la force vous quitte, tapez 'aide'.");
        System.out.println();
    }

    /**
     * Message de fin du jeu.
     */
    protected void printGoodbye() {
        System.out.println();
        System.out.println("Merci d'avoir joué, au revoir !");
    }

    /**
     * @return <code>true</code> si l'état courant du jeu autorise une fin automatique (hors
     *         commande <code>quitter</code>).
     */
    public boolean isOkToFinish() { return true; }
}
