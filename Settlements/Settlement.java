package Settlements;

import Buildings.Building;
import Settlements.modifiers.SettlementModifier;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter @Setter
public abstract class Settlement {

    // ----------------------------------------------------------------------------------------------------------------
    // CONSTRUCTOR
    // ----------------------------------------------------------------------------------------------------------------
    protected String name;
    public Settlement(String name) {
        this.name = name;
    }

    // ----------------------------------------------------------------------------------------------------------------
    // SETTLEMENT ATTRIBUTES
    // ----------------------------------------------------------------------------------------------------------------
    protected final List<Building> settlementBuildings = new ArrayList<>();

    protected int settlementTiles;
    public void changeVillageTiles(int modifier) {
        settlementTiles += modifier;
    }

    protected int settlementSize = 0;
    public void changeVillageSize(int modifier) {
        settlementSize += modifier;
    }

    protected int settlementPopulation = 0;
    public abstract void changeSettlementPopulation(int modifier);

    // ----------------------------------------------------------------------------------------------------------------
    // SETTLEMENT MODIFIERS
    // ----------------------------------------------------------------------------------------------------------------
    protected final Map<String, SettlementModifier> settlementModifiers = new HashMap<>();

    // ----------------------------------------------------------------------------------------------------------------
    // VILLAGE MODIFIERS
    // ----------------------------------------------------------------------------------------------------------------


    public abstract void addModifierToSettlement(SettlementModifier settlementModifier);
    public abstract void removeModifierFromSettlement(String modifierName);

    // ----------------------------------------------------------------------------------------------------------------
    // SETTLEMENT METHODS
    // ----------------------------------------------------------------------------------------------------------------
    public abstract void printSettlementModifiersMap();
    public abstract void addBuilding(Building building);
    public abstract Map<String, Double> getResourceMap();
    public abstract Map<String, Double> getDailyProduction();
    public abstract void reducePopulation(double killPercentage);
    public abstract void changeCropFieldsProduction(double modifier);
    public abstract void updateResourceMap(double food, double wood, double water, double stone);
}
