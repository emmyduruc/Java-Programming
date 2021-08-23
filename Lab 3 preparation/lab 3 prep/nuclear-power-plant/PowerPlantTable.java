import java.util.ArrayList;
import java.util.HashSet;
/**
 * Write a description of class PowerPlantTable here.
 *
 * @author (Emmanuel Duru)
 * @version (13.04.2020)
 */
public class PowerPlantTable
{
    // instance variables - replace the example below with your own
    private String name;
    private ArrayList<PowerPlant> powerPlants;
    private HashSet<PowerPlant> plants;

    /**
     * Constructor for objects of class PowerPlantTable
     */
    public PowerPlantTable(String name)
    {
        // initialise instance variables
        this.name = name;
        powerPlants = new ArrayList<PowerPlant>();
        plants = new HashSet<PowerPlant>();
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
    
    public void intList()
    {
        PowerPlant powerPlant1 = new PowerPlant("Oma", "Japan", 1325, 2010, 2025);
        PowerPlant powerPlant2 = new PowerPlant("Rooppur", "Bangladesh", 2160, 2017, 2023);
        PowerPlant powerPlant3 = new PowerPlant("Vogtle", "USA", 2234,2013,2021);
        PowerPlant powerPlant4 = new PowerPlant("Karachi", "Pakistan",1664, 2010,2022);
        addPowerStation(powerPlant1);
        addPowerStation(powerPlant2);
        addPowerStation(powerPlant3);
        addPowerStation(powerPlant4);
    }
    
    /**
     * List all power plants whose country match the search country
     * @param country of power plants to be listed
     */public void listPowerPlants(String country)
    {
        for(PowerPlant powerPlant : powerPlants)
        {
            if(powerPlant.getCountry() == country)
            {
                powerPlant.print();
            }
        }
    }
    
    public HashSet<PowerPlant> findPowerPlants(String country)
    {
        for(PowerPlant powerPlant : powerPlants)
        {
            if(powerPlant.getCountry() == country)
            {
                plants.add(powerPlant);
            }
        }
        
        return plants;
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
