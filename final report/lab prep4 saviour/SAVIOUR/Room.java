import java.util.Set;
import java.util.*;

/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "SAVIOUR" application. 
 * "SAVIOUR" is a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  For each existing exit, the room 
 * stores a reference to the neighboring room.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2016.02.29
 * Modified by Emmanuel Duru
 */

public class Room 
{
    private String description;
    private HashMap<String,Room> exits;        // stores exits of this room.
    private ArrayList<Item> items = new ArrayList<Item>();
    
    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
    public Room(String description) 
    {
        this.description = description;
        exits = new HashMap<>();
    }
    
   
    
    /**
     * Define an exit from this room.
     * @param direction The direction of the exit.
     * @param neighbor  The room to which the exit leads.
     */
    public void setExit(String direction, Room neighbor) 
    {
        exits.put(direction, neighbor);
    }
    
    
    
    /**
     * @return The short description of the roo
     * (the one that was defined in the constructor).
     */
    public String getShortDescription()
    {
        return description;
    }

    /**
     * Return a description of the room in the form:
     *     You are in the kitchen.
     *     Exits: north west
     * @return A long description of this room
     */
    public String getLongDescription()
    {
        return "You are " + description + ".\n" + getExitString();
    }

    /**
     * Return a string describing the room's exits, for example
     * "Exits: north west".
     * @return Details of the room's exits.
     */
    private String getExitString()
    {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }

    /**
     * Return the room that is reached if we go from this room in direction
     * "direction". If there is no room in that direction, return null.
     * @param direction The exit's direction.
     * @return The room in the given direction.
     */
    public Room getExit(String direction) 
    {
        return exits.get(direction);
    }
    
    /**
     * retuns an ArrayList of items by calling a method getItem 
     * @return  the list of items
     */
    public ArrayList<Item> getItem()
    {

        return items;
    }
    
    /**
     * Use this method when you want to place the item in a room
     * It will add the item into the list of 
     */
    public void placeItem(Item item)
    {
        items.add(item);
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public boolean equals(Room room)
    {
        if(this==room)
            return true;
        else 
            return false;
    }
    
    /**
     * This method check and returns the list of item in the room if not returns empty . 
     * @param return  empty if no item is found
     */
    public boolean itemEmptyCheck()
    {

        return items.isEmpty();
    }

    /**
     * This method prints all the list of items by calling their name.
     */
    public void printAllItem()
    {
        for(Item item : items){
            System.out.println(item.getName());
        }
    }

    /**
     * retuns an ArrayList of items by calling a method getItem 
     * @return  the list of items
     */
    public ArrayList<Item> gettem()
    {

        return items;
    }

    /**
     * method findByName given a string and an ArrayList of Items, 
     * find the Item with the matching name, or else return null
     */
    public Item findByName(String s ,ArrayList<Item> L){

        int n=0;
        while (n < L.size()) {
            Item i = L.get(n);
            if (s.equals(i.getName())) 
                return i;
            n++;
        }

        return null;

    }
    
    /**
     * This method removes the item of the item list
     */
    public void removeItem(Item item)
    {
        items.remove(item);
    }
}

