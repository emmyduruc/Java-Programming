
/**
 * Write a description of class PowerPlant here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PowerPlant
{
    // instance variables - replace the example below with your own
    private String name;
    private String country;
    private double capacity;
    private int constructionStart;
    private int connectingYear;

    /**
     * Constructor for objects of class PowerPlant
     */
    public PowerPlant(String name, String country, double capacity, int constructionStart, int connectingYear)
    {
        // initialise instance variables
        this.name = name;
        this.country = country;
        this.capacity = capacity;
        this.constructionStart = constructionStart;
        this.connectingYear = connectingYear;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void print()
    {        
        String formatted = String.format("| %-20s | %-20s |  %-19.1f | %-20d | %-20d |",  name, country, capacity, constructionStart, connectingYear);
        System.out.println(formatted);
    }
    
    public double getCapacity()
    {
        return capacity;
    }
}
