package Buildings;

import java.util.HashMap;
import java.util.ArrayList;

public abstract class Building {
    /*Abstract class is meant for inheritance by other classes and instances of it cannot be created from it*/

    // Writing public or leaving it 'default' means everyone can access it
    // Private means it can be accessed only inside the same package
    // Protected means it can be access only inside the same package or through inheritance

    // ------------------------------------------------------------------------------------------------------- //

    // An HashMap is declared and initialized and immediately after defined as a class constructor
    protected HashMap<String, Integer> upkeepMap;
    public Building(HashMap<String, Integer> upkeepMap) {
        this.upkeepMap = upkeepMap;
    }

    // HashMaps declared to be inherited by subclasses of Buildings.Building
    ArrayList<Integer> tilesList;
    HashMap<String, Integer> materialsMap = new HashMap<>();
    HashMap<String, Integer> productionMap = new HashMap<>();
    
}
