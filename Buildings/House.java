package Buildings;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Getter
public class House extends Building{

    // ----------------------------------------------------------------------------------------------------------------
    // HOUSE INHABITANTS
    // ----------------------------------------------------------------------------------------------------------------
    private final Random random = new Random();
    private final double houseInhabitants = random.nextInt(10) + 1;

    // ----------------------------------------------------------------------------------------------------------------
    // HOUSE UPKEEP
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

    private double upkeepModifier = super.getBaseUpkeepModifier();
    @Override
    public void changeUpkeepModifier(double mod) {
        upkeepModifier += mod;
    }

    @Override
    public Map<String, Double> getDailyUpkeep() {
        Map<String, Double> dailyUpkeep = new HashMap<>();
        DEFAULT_UPKEEP.forEach((key, value) -> dailyUpkeep.put(key, value * upkeepModifier * houseInhabitants));
        return dailyUpkeep;
    }

    // ----------------------------------------------------------------------------------------------------------------
    // HOUSE DAILY PRODUCTION
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

    private double productionModifier = getBaseProductionModifier();
    @Override
    public void changeProductionModifier(double mod) {
        productionModifier += mod;
    }

    @Override
    public Map<String, Double> getDailyProduction() {
        Map<String, Double> dailyProductionMap = new HashMap<>();
        DEFAULT_PRODUCTION.forEach((k, v) -> dailyProductionMap.put(k, v * productionModifier));
        return dailyProductionMap;
    }

    // ----------------------------------------------------------------------------------------------------------------
    // HOUSE CONSTRUCTION COST
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

    private double constructionModifier = getBaseConstructionModifier();
    @Override
    public void changeConstructionModifier(double mod) {
        constructionModifier += mod;
    }

    public Map<String, Double> getConstructionCost() {
        Map<String, Double> constructionCostMap = new HashMap<>();
        getDEFAULT_CONSTRUCTION_COST().forEach((k, v) -> constructionCostMap.put(k, v * constructionModifier));
        return constructionCostMap;
    }
}
