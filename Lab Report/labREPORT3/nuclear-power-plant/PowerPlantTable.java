import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;
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
    
    public void listByCountry()
    {
       for(PowerPlant powerPlant : powerPlants)
       {
          System.out.println("COUNTRY:" + powerPlant.getCountry()); 
          powerPlant.print();
       }
       
    }
    /**
     * method to indicate the PowerByCountry
     * returns HashMap total power
     */
    public HashMap<String, Double> powerByCountry()
    {
        HashMap<String, Double> totalPower = new HashMap<String, Double>();
        for(PowerPlant powerPlant : powerPlants)
        {
            String country = powerPlant.getCountry();
            double capacity = powerPlant.getCapacity();
            
            if(totalPower.containsKey(country))
            {   
                double currentPower = totalPower.get(country);
                totalPower.put(country, currentPower + capacity ); 
            }else{
                totalPower.put(country, capacity);
            }
        }
        
        return totalPower;
    }
    
        /**
         * actualization of printCapacity
         *
         * HashMap, defining the countries and its capacities
         */
        public void printCapacity(HashMap<String, Double> totalPower)
    { 
        for(String country : totalPower.keySet())
        {
            System.out.println(country + ": " + totalPower.get(country) );
        }
    }
    
     /**
     * information stating the mapByCountry
     *
     * HashMap. key = String(countries) and Value= HashSet (all windFarms located in this country).
     */
    public HashMap<String, HashSet<PowerPlant> > mapByCountry()
    {
        HashMap<String, HashSet<PowerPlant> > powerMap = new HashMap<String, HashSet<PowerPlant> >(); 
        for(PowerPlant powerPlant : powerPlants)
        {
            String country = powerPlant.getCountry();
            
            if(powerMap.containsKey(country))
            {
                HashSet<PowerPlant> powerPlantSet = powerMap.get(country);
                powerPlantSet.add(powerPlant);
                powerMap.put(country, powerPlantSet);
            } 
            else 
            {   
                HashSet<PowerPlant> powerPlantSet = new HashSet<PowerPlant>();
                powerPlantSet.add(powerPlant);
                powerMap.put(country, powerPlantSet);
            }
        }
        
        return powerMap;
    }
    
     public void printMap(HashMap< String, HashSet<PowerPlant> > powerMap)
    {
        for(String country : powerMap.keySet())
        {
            System.out.println("\n" + country + ": ");
            
            HashSet<PowerPlant> powerPlantSet = powerMap.get(country);
            
            for(PowerPlant powerPlant : powerPlantSet)
            {
                powerPlant.print();
            }
        }
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
