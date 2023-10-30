package Settlements;

import Buildings.Building;
import lombok.Getter;
import lombok.Setter;

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
    // SETTLEMENT METHODS
    // ----------------------------------------------------------------------------------------------------------------
    public abstract void addBuilding(Building building);
}
