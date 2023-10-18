import java.util.HashMap;
import java.util.Map;

import Buildings.House;
import Buildings.CropField;
import Buildings.Well;
import Settlements.Village;


public class Game {

    public static void main(String[] args) {
        House house1 = new House();
        //System.out.println(house1.houseInhabitants);
        //System.out.println(house1.returnUpkeep());
        house1.changeUpkeepModifier(-0.1);
        System.out.println(house1.returnUpkeep());
        CropField cropField1 = new CropField();
        System.out.println(cropField1.returnProduction());
        Well well1 = new Well();
        //daySettConsumption(Village.resourceMap, house1.returnUpkeep());
        //daySettConsumption(Village.resourceMap, house1.returnUpkeep());
    }

    public static void daySettConsumption(Map<String, Double> settlementResources, Map<String, Double> dailyUpkeep) {
        for (Map.Entry<String, Double> entry: settlementResources.entrySet()) {
            String settlementKey = entry.getKey();
            double settlementValue = entry.getValue();
            double upkeepValue = dailyUpkeep.get(settlementKey);
            settlementResources.put(settlementKey, settlementValue - upkeepValue);
        }
        System.out.println(settlementResources);
    }

    public static void daySettProduction(Map<String, Double> settlementResources, Map<String, Double> dailyProduction) {
        for (Map.Entry<String, Double> entry: settlementResources.entrySet()) {
            String settlementKey = entry.getKey();
            double settlementValue = entry.getValue();
            double productionValue = dailyProduction.get(settlementKey);
            settlementResources.put(settlementKey, settlementValue + productionValue);
        }
        System.out.println(settlementResources);
    }
}
