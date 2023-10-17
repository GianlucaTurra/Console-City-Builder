import java.util.HashMap;
import java.util.Map;

public class Buildings {

    public static class HouseOld extends BuildingOld {
        public static final HashMap<String, Integer> DEFAULT_UPKEEP;
        static {
            DEFAULT_UPKEEP = new HashMap<>();
            DEFAULT_UPKEEP.put("Wood", 10);
            DEFAULT_UPKEEP.put("Water", 25);
        }
        int inhabitants;
        public HashMap<String, Integer> houseUpkeep() {
            HashMap<String, Integer> dailyUpkeep = new HashMap<>();
            for (Map.Entry<String, Integer> entry : DEFAULT_UPKEEP.entrySet()) {
                dailyUpkeep.put(entry.getKey(), entry.getValue() * inhabitants);
                dailyUpkeep.put(entry.getKey(), entry.getValue() * inhabitants);
            }
            return dailyUpkeep;
        }
        public HouseOld() {
            super(DEFAULT_UPKEEP);
        }
    }


}
