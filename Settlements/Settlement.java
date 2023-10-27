package Settlements;

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
    // Common settlement attributes
    // ----------------------------------------------------------------------------------------------------------------
    protected int villageTiles;
    public void changeVillageTiles(int modifier) {
        villageTiles += modifier;
    }

    protected int settlementSize = 0;
    public void changeVillageSize(int modifier) {
        settlementSize += modifier;
    }

    protected int settlementPopulation = 0;
    public void changeVillagePopulation(int modifier) {
        settlementPopulation += modifier;
    }
}
