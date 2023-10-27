package Buildings;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Getter
public class House extends Building{

    // ----------------------------------------------------------------------------------------------------------------
    // CONSTRUCTOR
    // ----------------------------------------------------------------------------------------------------------------
    public House() {
        super(DEFAULT_UPKEEP, DEFAULT_PRODUCTION);
        this.upkeepModifier = super.getUpkeepModifier();
    }

    // ----------------------------------------------------------------------------------------------------------------
    // Generate base statistics for House object
    // ----------------------------------------------------------------------------------------------------------------
    private double upkeepModifier;
    @Override
    public void changeUpkeepModifier(double mod) {
        super.changeUpkeepModifier(mod);
        this.upkeepModifier = super.getUpkeepModifier();
    }

    private final Random inhabitants = new Random();
    private final double houseInhabitants = inhabitants.nextInt(10) + 1;

    // ----------------------------------------------------------------------------------------------------------------
    // Defining the default upkeep and encapsulation
    // ----------------------------------------------------------------------------------------------------------------
    private static final Map<String, Double> DEFAULT_UPKEEP = initUpkeepMap();
    private static Map<String, Double> initUpkeepMap() {
        Map<String, Double> defUpkeepMap = new HashMap<>();
        defUpkeepMap.put("Food", 3.0);
        defUpkeepMap.put("Wood", 5.0);
        defUpkeepMap.put("Water", 2.5);
        defUpkeepMap.put("Stone", 0.0);
        return defUpkeepMap;
    }

    @Override
    public Map<String, Double> getDailyUpkeep() {
        Map<String, Double> dailyUpkeep = new HashMap<>();
        DEFAULT_UPKEEP.forEach((key, value) -> dailyUpkeep.put(key, value * getUpkeepModifier() * houseInhabitants));
        return dailyUpkeep;
    }

    // ----------------------------------------------------------------------------------------------------------------
    // Defining default production and overriding method
    // ----------------------------------------------------------------------------------------------------------------
    @Getter
    private static final Map<String, Double> DEFAULT_PRODUCTION = initProductionMap();
    private static Map<String, Double> initProductionMap() {
        Map<String, Double> defProdMap = new HashMap<>();
        defProdMap.put("Food", 0.0);
        defProdMap.put("Wood", 0.0);
        defProdMap.put("Water", 0.0);
        defProdMap.put("Stone", 0.0);
        return defProdMap;
    }

    @Override
    public Map<String, Double> getDailyProduction() {
        return DEFAULT_PRODUCTION;
    }

    // ----------------------------------------------------------------------------------------------------------------
    // Defining default construction cost and overriding method
    // ----------------------------------------------------------------------------------------------------------------
    @Getter
    private static final Map<String, Double> DEFAULT_CONSTRUCTION_COST = initConstructionMap();
    private static Map<String, Double> initConstructionMap() {
        Map<String, Double> defConstMap = new HashMap<>();
        defConstMap.put("Food", 0.0);
        defConstMap.put("Wood", 50.0);
        defConstMap.put("Water", 0.0);
        defConstMap.put("Stone", 50.0);
        return defConstMap;
    }

    public Map<String, Double> getConstructionCost() {
        Map<String, Double> constructionCostMap = new HashMap<>();
        getDEFAULT_CONSTRUCTION_COST().forEach((k, v) -> constructionCostMap.put(k, v * getConstructionModifier()));
        return constructionCostMap;
    }
}
