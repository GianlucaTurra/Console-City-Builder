package Buildings;

import java.util.HashMap;
import java.util.Map;

public class CropField extends Building{

    // ----------------------------------------------------------------------------------------------------------------
    // CONSTRUCTOR
    // ----------------------------------------------------------------------------------------------------------------
    public CropField() {
        super(DEFAULT_UPKEEP, DEFAULT_PRODUCTION);
    }

    int workersNeeded = 3;

    // ----------------------------------------------------------------------------------------------------------------
    // Defining the default Maps for upkeep and production
    // ----------------------------------------------------------------------------------------------------------------
    public static final Map<String, Double> DEFAULT_UPKEEP;
    static {
        DEFAULT_UPKEEP = new HashMap<>();
        DEFAULT_UPKEEP.put("Food", 0.0);
        DEFAULT_UPKEEP.put("Wood", 0.0);
        DEFAULT_UPKEEP.put("Water", 25.0);
    }
    public static final Map<String, Double> DEFAULT_PRODUCTION;
    static {
        DEFAULT_PRODUCTION = new HashMap<>();
        DEFAULT_PRODUCTION.put("Food", 25.0);
        DEFAULT_PRODUCTION.put("Wood", 0.0);
        DEFAULT_PRODUCTION.put("Water", 0.0);
    }

    // ----------------------------------------------------------------------------------------------------------------
    // Overriding superclass' abstract functions
    // ----------------------------------------------------------------------------------------------------------------
    @Override
    public Map<String, Double> returnUpkeep() {
        Map<String, Double> dailyUpkeep = new HashMap<>();
        for (Map.Entry<String, Double> set: DEFAULT_UPKEEP.entrySet()) {
            dailyUpkeep.put(set.getKey(), set.getValue() * upkeepModifier);
        }
        return dailyUpkeep;
    }
    @Override
    public Map<String, Double> returnProduction() {
        Map<String, Double> dailyProduction = new HashMap<>();
        for (Map.Entry<String, Double> set: DEFAULT_PRODUCTION.entrySet()) {
            dailyProduction.put(set.getKey(), set.getValue() * productionModifier);
        }
        return dailyProduction;
    }
}
