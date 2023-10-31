package Settlements;

import Buildings.Building;
import Buildings.CropField;
import Buildings.House;

import lombok.Getter;

import java.util.*;

import static java.lang.Math.round;

@Getter
public class Village  extends Settlement{

    // ----------------------------------------------------------------------------------------------------------------
    // CONSTRUCTOR
    // ----------------------------------------------------------------------------------------------------------------
    String name;
    public Village(String name) {
        super(name);
        this.name = super.name;
        setBaseResourceMap();
        settlementTiles = 20;

    }

    // ----------------------------------------------------------------------------------------------------------------
    // Definition and encapsulation for Buildings list
    // ----------------------------------------------------------------------------------------------------------------
    @Override
    public void addBuilding(Building building) {
        if (checkSlots() && checkResources(building.getConstructionCost())) {
            settlementBuildings.add(building);
            applyConstructionCosts(building.getConstructionCost());
            settlementSize += 1;
            // Try to find a better way to add inhabitants if building adds them
            if (building instanceof House) {
                changeSettlementPopulation((int) ((House) building).getHouseInhabitants());
            }
        }
    }

    // ----------------------------------------------------------------------------------------------------------------
    // Defining the default production Map
    // ----------------------------------------------------------------------------------------------------------------
    private static final Map<String, Double> DAILY_PRODUCTION = initDailyProductionMap();
    private static Map<String, Double> initDailyProductionMap() {
        Map<String, Double> defDailyProdMap = new HashMap<>();
        defDailyProdMap.put("Food", 50.0);
        defDailyProdMap.put("Wood", 50.0);
        defDailyProdMap.put("Water", 50.0);
        defDailyProdMap.put("Stone", 25.0);
        return defDailyProdMap;
    }

    @Override
    public Map<String, Double> getDailyProduction() {
        return DAILY_PRODUCTION;
    }

    // ----------------------------------------------------------------------------------------------------------------
    // Defining the default resource Map
    // ----------------------------------------------------------------------------------------------------------------
    private final Map<String, Double> resourceMap = new HashMap<>();

    @Override
    public void updateResourceMap(double food, double wood, double water, double stone) {
        resourceMap.put("Food", resourceMap.get("Food") + food);
        resourceMap.put("Wood", resourceMap.get("Wood") + wood);
        resourceMap.put("Water", resourceMap.get("Water") + water);
        resourceMap.put("Stone", resourceMap.get("Stone") + stone);
    }
    public void setBaseResourceMap() {
        resourceMap.put("Food", 200.0);
        resourceMap.put("Wood", 200.0);
        resourceMap.put("Water", 200.0);
        resourceMap.put("Stone", 200.0);
    }

    // ----------------------------------------------------------------------------------------------------------------
    // Village stats modifying methods
    // ----------------------------------------------------------------------------------------------------------------
    public void reducePopulation(double killPercentage) {
        int modifier = (int) (settlementPopulation * killPercentage) * (-1);
        changeSettlementPopulation(modifier);
    }

    @Override
    public void changeCropFieldsProduction(double modifier) {
//        villageCropFields.forEach(cropField -> cropField.changeProductionModifier(modifier));
        for (Building building: settlementBuildings) {
            if (building instanceof CropField) {
                System.out.println(building);
                building.changeProductionModifier(modifier);
            }
        }
    }

    @Override
    public void changeSettlementPopulation(int modifier) {
        settlementPopulation += modifier;
    }

    // ----------------------------------------------------------------------------------------------------------------
    // VILLAGE MODIFIERS
    // ----------------------------------------------------------------------------------------------------------------
    private void initialize

    // ----------------------------------------------------------------------------------------------------------------
    // Utils methods for village methods
    // ----------------------------------------------------------------------------------------------------------------
    private boolean checkSlots() {
        if (settlementSize == settlementTiles) {
            System.out.println("No more room for buildings in the village!");
            return false;
        } else {
            return true;
        }
    }

    private boolean checkResources(Map<String, Double> buildingConstructionMap) {
        for (Map.Entry<String, Double> villageEntry: getResourceMap().entrySet()) {
            for (Map.Entry<String, Double> buildingEntry: buildingConstructionMap.entrySet()) {
                if (villageEntry.getValue() - buildingEntry.getValue() < 0) {
                    System.out.println("Not enough " + villageEntry.getKey() + " for this building.");
                    return false;
                }
            }
        }
        return true;
    }

    private void applyConstructionCosts(Map<String, Double> buildingConstructionMap) {
        resourceMap.forEach((k, v) -> resourceMap.put(k, v - buildingConstructionMap.get(k)));
    }
}
