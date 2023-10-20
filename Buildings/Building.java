package Buildings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class Building {


    // Stuff for the constructor
    protected Map<String, Double> upkeepMap;
    protected Map<String, Double> productionMap;
    // Definition of the constructor
    public Building(Map<String, Double> upkeepMap, Map<String, Double> productionMap) {
        this.upkeepMap = upkeepMap;
        this.productionMap = productionMap;
    }


    // Default upkeep/production modifier
    double upkeepModifier = 1;
    double productionModifier = 1;

    // Method to change upkeep/production modifier
    public void changeUpkeepModifier(double mod) {
        upkeepModifier += mod;
    }
    public void changeProductionModifier(double mod) {
        productionModifier += mod;
    }


    // Abstract methods for buildings
    public abstract Map<String, Double> returnUpkeep();
    public abstract Map<String, Double> returnProduction();


    ArrayList<Integer> tilesList;
    HashMap<String, Integer> materialsMap = new HashMap<>();
    
}
