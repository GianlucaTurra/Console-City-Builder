package Buildings;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class Lumberjack extends Building {

    // ----------------------------------------------------------------------------------------------------------------
    // CONSTRUCTOR
    // ----------------------------------------------------------------------------------------------------------------
    public Lumberjack() {
        super.setWorkersNeeded(4);
    }

    // ----------------------------------------------------------------------------------------------------------------
    // LUMBERJACK UPKEEP
    // ----------------------------------------------------------------------------------------------------------------
    private static final Map<String, Double> DEFAULT_UPKEEP = initUpkeepMap();
    private static @NotNull Map<String, Double> initUpkeepMap() {
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
        DEFAULT_UPKEEP.forEach((key, value) -> dailyUpkeep.put(key, value * upkeepModifier * population));
        return dailyUpkeep;
    }

    // ----------------------------------------------------------------------------------------------------------------
    // LUMBERJACK DAILY PRODUCTION
    // ----------------------------------------------------------------------------------------------------------------
    @Getter
    private static final Map<String, Double> DEFAULT_PRODUCTION = initProductionMap();
    private static @NotNull Map<String, Double> initProductionMap() {
        Map<String, Double> defProdMap = new HashMap<>();
        defProdMap.put("Food", 0.0);
        defProdMap.put("Wood", 25.0);
        defProdMap.put("Water", 0.0);
        defProdMap.put("Stone", 0.0);
        return defProdMap;
    }

    @Override
    public Map<String, Double> getDailyProduction() {
        Map<String, Double> dailyProductionMap = new HashMap<>();
        DEFAULT_PRODUCTION.forEach((k, v) -> dailyProductionMap.put(k, v * productionModifier));
        return dailyProductionMap;
    }

    // ----------------------------------------------------------------------------------------------------------------
    // LUMBERJACK CONSTRUCTION COST
    // ----------------------------------------------------------------------------------------------------------------
    @Getter
    private static final Map<String, Double> DEFAULT_CONSTRUCTION_COST = initConstructionMap();
    private static @NotNull Map<String, Double> initConstructionMap() {
        Map<String, Double> defConstMap = new HashMap<>();
        defConstMap.put("Food", 0.0);
        defConstMap.put("Wood", 25.0);
        defConstMap.put("Water", 0.0);
        defConstMap.put("Stone", 25.0);
        return defConstMap;
    }

    public Map<String, Double> getConstructionCost() {
        Map<String, Double> constructionCostMap = new HashMap<>();
        getDEFAULT_CONSTRUCTION_COST().forEach((k, v) -> constructionCostMap.put(k, v * constructionModifier));
        return constructionCostMap;
    }
}
