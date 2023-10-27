package Settlements;

import Buildings.CropField;
import Buildings.House;
import Buildings.Well;

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
        villageHouses = new ArrayList<>();
        villageCropFields = new ArrayList<>();
        villageWells = new ArrayList<>();
        villageTiles = 20;
    }

    // ----------------------------------------------------------------------------------------------------------------
    // Definition and encapsulation for Buildings list
    // ----------------------------------------------------------------------------------------------------------------
    private final List<House> villageHouses;
    private final List<CropField> villageCropFields;
    private final List<Well> villageWells;

    public void addHouse(House house) {
        if (checkSlots() && checkResources(house.getConstructionCost())) {
            villageHouses.add(house);
            applyConstructionCosts(house.getConstructionCost());
            settlementSize += 1;
            changeVillagePopulation((int)house.getHouseInhabitants());
        }
    }
    public void addCropField(CropField cropField) {
        if (checkSlots() && checkResources(cropField.getConstructionCost())) {
            villageCropFields.add(cropField);
            applyConstructionCosts(cropField.getConstructionCost());
            settlementSize += 1;
        }
    }
    public void addWell(Well well) {
        if (checkSlots() && checkResources(well.getConstructionCost())) {
            villageWells.add(well);
            applyConstructionCosts(well.getConstructionCost());
            settlementSize += 1;
        }
    }

    // ----------------------------------------------------------------------------------------------------------------
    // Defining the default production Map
    // ----------------------------------------------------------------------------------------------------------------
    @Getter
    private static final Map<String, Double> DAILY_PRODUCTION = initDailyProductionMap();
    private static Map<String, Double> initDailyProductionMap() {
        Map<String, Double> defDailyProdMap = new HashMap<>();
        defDailyProdMap.put("Food", 50.0);
        defDailyProdMap.put("Wood", 50.0);
        defDailyProdMap.put("Water", 50.0);
        defDailyProdMap.put("Stone", 25.0);
        return defDailyProdMap;
    }

    // ----------------------------------------------------------------------------------------------------------------
    // Defining the default resource Map
    // ----------------------------------------------------------------------------------------------------------------
    private final Map<String, Double> resourceMap = new HashMap<>();

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
        changeVillagePopulation(modifier);
    }

    public void changeVillageCropFieldsProduction(double modifier) {
        villageCropFields.forEach(cropField -> cropField.changeProductionModifier(modifier));
    }

    // ----------------------------------------------------------------------------------------------------------------
    // Utils methods for village methods
    // ----------------------------------------------------------------------------------------------------------------
    private boolean checkSlots() {
        if (settlementSize == villageTiles) {
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
