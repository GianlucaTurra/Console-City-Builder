package Buildings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class Building {

    protected Map<String, Double> upkeepMap;
    // Definition of the constructor
    public Building(Map<String, Double> upkeepMap) {
        this.upkeepMap = upkeepMap;
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

    ArrayList<Integer> tilesList;
    HashMap<String, Integer> materialsMap = new HashMap<>();
    HashMap<String, Integer> productionMap = new HashMap<>();
    
}
