import Buildings.CropField;
import Buildings.House;
import Buildings.Well;
import Settlements.Village;

import java.util.Map;
import java.util.Scanner;

public class Game {

    // ----------------------------------------------------------------------------------------------------------------
    // THE GAME
    // ----------------------------------------------------------------------------------------------------------------
    static boolean gameIsOn = true;
    public static void game() {
        Village gameVillage = createVillage();
        while(gameIsOn) {
            String userCommand = getUserCommand();
            receiveCommands(userCommand, gameVillage);
        }
    }

    // ----------------------------------------------------------------------------------------------------------------
    // Village creation - First step of the game
    // ----------------------------------------------------------------------------------------------------------------
    static Village createVillage() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter village name: ");
        String villageName = keyboard.nextLine();
        return new Village(villageName);
    }

    // ----------------------------------------------------------------------------------------------------------------
    // USER INPUT
    // ----------------------------------------------------------------------------------------------------------------
    static String getUserCommand() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter a command: ");
        return keyboard.nextLine();
    }
    static void receiveCommands(@org.jetbrains.annotations.NotNull String command, Village village) {
        switch(command) {
            case "create house":
                House house = new House();
                village.addBuildingsToVillage(house);
                break;
            case "create crop field":
                CropField cropField = new CropField();
                village.addBuildingsToVillage(cropField);
                break;
            case "create well":
                Well well = new Well();
                village.addBuildingsToVillage(well);
                break;
            case "show":
                for (Object building:
                        village.villageBuildings) {
                    System.out.println(building);
                }
                break;
            case "end game":
                gameIsOn = false;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + command);
        }

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
