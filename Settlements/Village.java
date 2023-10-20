package Settlements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Village {

    // ----------------------------------------------------------------------------------------------------------------
    // CONSTRUCTOR
    // ----------------------------------------------------------------------------------------------------------------
    String villageName;
    public Village(String villageName) {
        this.villageName = villageName;
    }

    // defining village building list and the function to populate it
    public int villageTiles = 20;
    public final List<Object> villageBuildings = new ArrayList<>();
    public void addBuildingsToVillage(Object building) {
        if (villageBuildings.size() == villageTiles) {
            System.out.println("No more room for buildings in the village!");
        } else {
            villageBuildings.add(building);
        }
    }

    // ----------------------------------------------------------------------------------------------------------------
    // Defining the default Map for production and the resource map
    // ----------------------------------------------------------------------------------------------------------------
    // Base daily production of the village
    public static final Map<String, Double> DAILY_PRODUCTION;
    static {
        DAILY_PRODUCTION = new HashMap<>();
        DAILY_PRODUCTION.put("Food", 50.0);
        DAILY_PRODUCTION.put("Wood", 50.0);
        DAILY_PRODUCTION.put("Water", 50.0);
    }
    // Initial stock of resources
    public static Map<String, Double> resourceMap;
    static {
        resourceMap = new HashMap<>();
        resourceMap.put("Food", 200.0);
        resourceMap.put("Wood", 200.0);
        resourceMap.put("Water", 200.0);
    }

}
