package Buildings;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class Well extends Building {


    // ----------------------------------------------------------------------------------------------------------------
    // CONSTRUCTOR
    // ----------------------------------------------------------------------------------------------------------------
    public Well() {
        super(DEFAULT_UPKEEP, DEFAULT_PRODUCTION);
    }

    // ----------------------------------------------------------------------------------------------------------------
    // Workers needed encapsulation
    // ----------------------------------------------------------------------------------------------------------------
    private int workersNeeded = 0;

    public void changeWorkersNeeded(int workersNeededModifier) {
        this.workersNeeded += workersNeededModifier;
    }

    // ----------------------------------------------------------------------------------------------------------------
    // Defining the default Maps for upkeep and production
    // ----------------------------------------------------------------------------------------------------------------
    @Getter
    private static final Map<String, Double> DEFAULT_UPKEEP = initUpkeepMap();
    private static Map<String, Double> initUpkeepMap() {
        Map<String, Double> defUpkeepMap = new HashMap<>();
        defUpkeepMap.put("Food", 0.0);
        defUpkeepMap.put("Wood", 0.0);
        defUpkeepMap.put("Water", 0.0);
        defUpkeepMap.put("Stone", 0.0);
        return defUpkeepMap;
    }

    @Override
    public Map<String, Double> getDailyUpkeep() {
        Map<String, Double> dailyUpkeep = new HashMap<>();
        DEFAULT_UPKEEP.forEach((key, value) -> dailyUpkeep.put(key, value * getUpkeepModifier()));
        return dailyUpkeep;
    }


    // ----------------------------------------------------------------------------------------------------------------
    // Overriding superclass' abstract functions
    // ----------------------------------------------------------------------------------------------------------------
    @Getter
    private static final Map<String, Double> DEFAULT_PRODUCTION = initProductionMap();
    private static Map<String, Double> initProductionMap() {
        Map<String, Double> defProdMap = new HashMap<>();
        defProdMap.put("Food", 0.0);
        defProdMap.put("Wood", 0.0);
        defProdMap.put("Water", 100.0);
        defProdMap.put("Stone", 0.0);
        return defProdMap;
    }

    @Override
    public Map<String, Double> getDailyProduction() {
        Map<String, Double> dailyProduction = new HashMap<>();
        for (Map.Entry<String, Double> set: DEFAULT_PRODUCTION.entrySet()) {
            dailyProduction.put(set.getKey(), set.getValue() * getProductionModifier());
        }
        return dailyProduction;
    }

    // ----------------------------------------------------------------------------------------------------------------
    // Defining default construction cost and overriding method
    // ----------------------------------------------------------------------------------------------------------------
    @Getter
    private static final Map<String, Double> DEFAULT_CONSTRUCTION_COST = initConstructionMap();
    private static Map<String, Double> initConstructionMap() {
        Map<String, Double> defConstMap = new HashMap<>();
        defConstMap.put("Food", 0.0);
        defConstMap.put("Wood", 0.0);
        defConstMap.put("Water", 0.0);
        defConstMap.put("Stone", 25.0);
        return defConstMap;
    }

    public Map<String, Double> getConstructionCost() {
        Map<String, Double> constructionCostMap = new HashMap<>();
        DEFAULT_CONSTRUCTION_COST.forEach((k, v) -> constructionCostMap.put(k, v * getConstructionModifier()));
        return constructionCostMap;
    }
}
