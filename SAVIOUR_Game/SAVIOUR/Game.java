import java.util.HashSet;
import java.util.Stack;
 
  /**
 *  This class is the main class of the "SAVIOUR" application. 
 *  "SAVIOUR" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2016.02.29
 * Modified by Emmanuel Duru
 */

public class Game 
{
    private Parser parser;
    private Room currentRoom;
    private HashSet<Item> inventory;
    private Stack<Room> prevRooms = new Stack<Room>();
    Room firstRoom;
    //private Stack<Room>
    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        createRooms();
//        parser = new Parser();
        inventory = new HashSet<Item>();
    }
 
    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms()
    {
        Room idaho, ohio, florida, california, maryland, texas, washington;
      
        
        Item weapon1 = new Item("AK 47");
        Item letter = new Item("classified information (letter)");
        
        // create the rooms
        idaho = new Room("in the starting point of the game");
        ohio = new Room("in ohio to take a letter to be delivered to the president in washington..saviour: OH! sounds like i have got to do the bad guy thing to make a successful delivery ha!ha!ha");
        ohio.placeItem(letter);
        florida = new Room("in God we trust city(florida)and will be taking a route (california) where most bad guys dwell so take a weapon for self-defense you might encounter some bad guys on your way");
        florida.placeItem(weapon1);
        california = new Room("to be very careful,saviour: ha!ha! i fear no man!! whoever that shows up takes the first bullet, ARO MATE!!!");
        maryland = new Room("apprehended ha!ha!ha! get me the letter and kill the bastard!,now go back and try again");
        texas = new Room("in a beautiful and peaceful city, saviour: sure i am already getting to the president");
        washington = new Room("at the office of the president, now you delivered the letter");
        
        // initialise room exits
        idaho.setExit("east",ohio);
        
        ohio.setExit("west", idaho);
        ohio.setExit("east", florida);
        
        florida.setExit("west", ohio);
        florida.setExit("south", california);
        
        california.setExit("north", florida);
        california.setExit("west", texas);
        california.setExit("east", maryland);
        
        maryland.setExit("west", california);
        
        texas.setExit("east", california);
        texas.setExit("south", washington);
        
        washington.setExit("north", texas);

        
        currentRoom = idaho;  // start game outside
        firstRoom = idaho;
    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {
        GuiGame newGame = new GuiGame(firstRoom);
        newGame.startGamePlay();
//        // Enter the main command loop.  Here we repeatedly read commands and
//        // execute them until the game is over.
//
//        boolean finished = false;
//        while (! finished) {
//            Command command = parser.getCommand();
//            finished = processCommand(command);
//        }
//        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        if(command.isUnknown()) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        String commandWord = command.getCommandWord();
        if (commandWord.equals("help")) {
            printHelp();
        }
        else if (commandWord.equals("go")) {
            goRoom(command);
        }
        else if (commandWord.equals("quit")) {
            wantToQuit = quit(command);
        }
        else if(commandWord.equals("take")){
            takeItem(command);
        }
        else if(commandWord.equals("back")){
            if(prevRooms.empty()){
                System.out.println("No room to go back!!!");
            }
            else{
                currentRoom = prevRooms.pop();
                System.out.println(currentRoom.getLongDescription());
            }
            
        }
        // else command not recognised.
            return wantToQuit;
    }

    // implementations of user commands:

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void printHelp() 
    {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();
    }

    /** 
     * Try to in to one direction. If there is an exit, enter the new
     * room, otherwise print an error message.
     */
    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else {
            prevRooms.push(currentRoom);
            currentRoom = nextRoom;
            if(nextRoom.itemEmptyCheck()==false){
                System.out.println("Items in the room: ");
                nextRoom.printAllItem();
            }
            System.out.println(currentRoom.getLongDescription());
        }
    }

    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }
    
    /**
     * The given command enables the player take items once an item is found in the room.
     * @param  command The command to be processed.
     * @return prints the added item. 
     */
    public void takeItem(Command command)
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Take what?");
            return;
        }

        String foundItem = command.getSecondWord();
        
        Item found = currentRoom.findByName(foundItem,currentRoom.getItem());

        
        inventory.add(found);//add holygrail to hashset inventory
        currentRoom.removeItem(found);//remove holygrail from the room
        System.out.println("Now you got " + found.getName());
        System.out.println(currentRoom.getLongDescription());
    }
}
