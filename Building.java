import java.util.HashMap;
import java.util.ArrayList;

public abstract class Building {

    protected HashMap<String, Integer> upkeepMap = new HashMap<>();
    public Building(HashMap<String, Integer> upkeepMap) {
        this.upkeepMap = upkeepMap;
    }
    ArrayList<Integer> tilesList;
    HashMap<String, Integer> materialsMap = new HashMap<>();
    HashMap<String, Integer> productionMap = new HashMap<>();
    
}
