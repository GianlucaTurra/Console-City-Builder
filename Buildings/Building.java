package Buildings;

import java.util.HashMap;

public abstract class Building {
    /*Abstract class is meant for inheritance by other classes and instances of it cannot be created from it*/

    // Writing public or leaving it 'default' means everyone can access it
    // Private means it can be accessed only inside the same package
    // Protected means it can be access only inside the same package or through inheritance

    // ------------------------------------------------------------------------------------------------------- //

    // An HashMap is declared and initialized and immediately after defined as a class constructor
    protected HashMap<String, Double> upkeepMap;
    static int tileNumber;
    public Building(HashMap<String, Double> upkeepMap) {
        this.upkeepMap = upkeepMap;
    }

    public static int chooseTile(int tile) {
        tileNumber = tile;
        return tileNumber;
    }

    // Static field modifier, meaning it can be called without creating a class instance
    static double upkeepModifier = 1;
    static double productionModifier = 1;

    public void ChangeUpkeepModifier(double newModifier) {
        upkeepModifier = newModifier;
    }

    public void ChangeProductionModifier(double newModifier) {
        productionModifier = newModifier;
    }

    // HashMaps declared to be inherited by subclasses of Buildings.Building

    public static HashMap<String, Double> materialsMap;
    HashMap<String, Integer> productionMap;
    
}
