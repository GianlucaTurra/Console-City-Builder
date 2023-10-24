package Buildings;

import lombok.Getter;

import java.util.Map;

abstract class Building {

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

    // Upkeep modifier encapsulation
    @Getter
    private double upkeepModifier = 1;

    public void changeUpkeepModifier(double mod) {
        upkeepModifier += mod;
    }

    // Production modifier encapsulation
    @Getter
    private double productionModifier = 1;

    public void changeProductionModifier(double mod) {
        productionModifier += mod;
    }

    // ----------------------------------------------------------------------------------------------------------------
    // Abstract methods to return Maps
    // ----------------------------------------------------------------------------------------------------------------
    public abstract Map<String, Double> getDailyUpkeep();
    public abstract Map<String, Double> getDailyProduction();
    
}
