import java.util.ArrayList;
/**
 * Write a description of class PowerPlantTable here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PowerPlantTable
{
    // instance variables - replace the example below with your own
    private String name;
    private ArrayList<PowerPlant> powerPlants;

    /**
     * Constructor for objects of class PowerPlantTable
     */
    public PowerPlantTable(String name)
    {
        // initialise instance variables
        this.name = name;
        powerPlants = new ArrayList<PowerPlant>();
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    
    public void addPowerStation(PowerPlant powerStation)
    {
        powerPlants.add(powerStation);
    }
        
    public double getTotalPower()
    {
        double sum = 0;
        for(PowerPlant powerStation : powerPlants)
        {
            sum += powerStation.getCapacity();
        }
        return sum;
    }
    
    public void printTable()
    {
        String heading = String.format("| %-20s | %-20s | %-20s | %-20s | %-20s |",  "Name",  "Country", "Capacity", "Construction Start", "Connecting Year");
        System.out.println(heading);
        for(PowerPlant powerStation: powerPlants)
        {
            powerStation.print();
        }
    }
}
