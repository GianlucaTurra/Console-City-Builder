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
    private static final Map<String, Double> DEFAULT_UPKEEP;
    static {
        DEFAULT_UPKEEP = new HashMap<>();
        DEFAULT_UPKEEP.put("Food", 0.0);
        DEFAULT_UPKEEP.put("Wood", 0.0);
        DEFAULT_UPKEEP.put("Water", 0.0);
    }

    @Override
    public Map<String, Double> getDailyUpkeep() {
        Map<String, Double> dailyUpkeep = new HashMap<>();
        for (Map.Entry<String, Double> set: DEFAULT_UPKEEP.entrySet()) {
            dailyUpkeep.put(set.getKey(), set.getValue() * getUpkeepModifier());
        }
        return dailyUpkeep;
    }


    // ----------------------------------------------------------------------------------------------------------------
    // Overriding superclass' abstract functions
    // ----------------------------------------------------------------------------------------------------------------
    private static final Map<String, Double> DEFAULT_PRODUCTION;
    static {
        DEFAULT_PRODUCTION = new HashMap<>();
        DEFAULT_PRODUCTION.put("Food", 0.0);
        DEFAULT_PRODUCTION.put("Wood", 0.0);
        DEFAULT_PRODUCTION.put("Water", 100.0);
    }

    @Override
    public Map<String, Double> getDailyProduction() {
        Map<String, Double> dailyProduction = new HashMap<>();
        for (Map.Entry<String, Double> set: DEFAULT_PRODUCTION.entrySet()) {
            dailyProduction.put(set.getKey(), set.getValue() * getProductionModifier());
        }
        return dailyProduction;
    }
}
