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
    }

    // ----------------------------------------------------------------------------------------------------------------
    // Definition of village tiles, size, inhabitants
    // ----------------------------------------------------------------------------------------------------------------
    private int villageTiles = 20;
    public void changeVillageTiles(int modifier) {
        villageTiles += modifier;
    }

    private int villageSize = 0;
    public void changeVillageSize(int modifier) {
        villageSize += modifier;
    }

    private int villagePopulation = 0;
    public void changeVillagePopulation(int modifier) {
        villagePopulation += modifier;
    }

    // ----------------------------------------------------------------------------------------------------------------
    // Definition and encapsulation for Buildings list
    // ----------------------------------------------------------------------------------------------------------------
    private final List<House> villageHouses;
    private final List<CropField> villageCropFields;
    private final List<Well> villageWells;

    public void addHouse(House house) {
        if (villageSize == villageTiles) {
            System.out.println("No more room for buildings in the village!");
        } else {
            villageHouses.add(house);
            villageSize += 1;
            changeVillagePopulation((int)house.getHouseInhabitants());
        }
    }
    public void addCropField(CropField cropField) {
        if (villageSize == villageTiles) {
            System.out.println("No more room for buildings in the village!");
        } else {
            villageCropFields.add(cropField);
            villageSize += 1;
        }
    }
    public void addWell(Well well) {
        if (villageSize == villageTiles) {
            System.out.println("No more room for buildings in the village!");
        } else {
            villageWells.add(well);
            villageSize += 1;
        }
    }

    // ----------------------------------------------------------------------------------------------------------------
    // Defining the default production Map
    // ----------------------------------------------------------------------------------------------------------------
    private static final Map<String, Double> DAILY_PRODUCTION;
    static {
        DAILY_PRODUCTION = new HashMap<>();
        DAILY_PRODUCTION.put("Food", 50.0);
        DAILY_PRODUCTION.put("Wood", 50.0);
        DAILY_PRODUCTION.put("Water", 50.0);
    }

    // ----------------------------------------------------------------------------------------------------------------
    // Defining the default resource Map
    // ----------------------------------------------------------------------------------------------------------------
    private final Map<String, Double> resourceMap = new HashMap<>();

    public void updateResourceMap(double food, double wood, double water) {
        resourceMap.put("Food", resourceMap.get("Food") + food);
        resourceMap.put("Wood", resourceMap.get("Wood") + wood);
        resourceMap.put("Water", resourceMap.get("Water") + water);
    }
    public void setBaseResourceMap() {
        resourceMap.put("Food", 200.0);
        resourceMap.put("Wood", 200.0);
        resourceMap.put("Water", 200.0);
    }

    // ----------------------------------------------------------------------------------------------------------------
    // Village stats modifying methods
    // ----------------------------------------------------------------------------------------------------------------
    public void reducePopulation(double killPercentage) {
        int modifier = (int) (villagePopulation * killPercentage) * (-1);
        changeVillagePopulation(modifier);
    }

    public void changeVillageCropFieldsProduction(double modifier) {
        villageCropFields.forEach(cropField -> cropField.changeProductionModifier(modifier));
    }
}
