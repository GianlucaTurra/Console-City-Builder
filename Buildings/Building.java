package Buildings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class Building {

    // ----------------------------------------------------------------------------------------------------------------
    // CONSTRUCTOR
    // ----------------------------------------------------------------------------------------------------------------
    protected Map<String, Double> upkeepMap;
    protected Map<String, Double> productionMap;
    // Definition of the constructor
    public Building(Map<String, Double> upkeepMap, Map<String, Double> productionMap) {
        this.upkeepMap = upkeepMap;
        this.productionMap = productionMap;
    }

    // ----------------------------------------------------------------------------------------------------------------
    // Default upkeep and production modifiers and abstract methods to change them
    // ----------------------------------------------------------------------------------------------------------------
    double upkeepModifier = 1;
    double productionModifier = 1;
    public void changeUpkeepModifier(double mod) {
        upkeepModifier += mod;
    }
    public void changeProductionModifier(double mod) {
        productionModifier += mod;
    }

    // ----------------------------------------------------------------------------------------------------------------
    // Abstract methods to return Maps
    // ----------------------------------------------------------------------------------------------------------------
    public abstract Map<String, Double> returnUpkeep();
    public abstract Map<String, Double> returnProduction();
    
}
