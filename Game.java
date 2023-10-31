import Buildings.CropField;
import Buildings.House;
import Buildings.Well;
import CustomErrors.UnknownCommandException;
import Events.EventsDescription;
import Events.NewDay;
import Settlements.Settlement;
import Settlements.Village;

import java.util.Scanner;

public class Game {

    // ----------------------------------------------------------------------------------------------------------------
    // THE GAME
    // ----------------------------------------------------------------------------------------------------------------
    static boolean gameIsOn = true;
    public static void game() {
        System.out.println(EventsDescription.GAME_START.getDescription());
        Settlement gameSettlement = createSettlement();
        while(gameIsOn) {
            String userCommand = getUserCommand();
            try {
                receiveCommands(userCommand, gameSettlement);
            } catch (UnknownCommandException e) {
                System.out.println("You entered an invalid command, please try again. ");
            }
        }
    }

    // ----------------------------------------------------------------------------------------------------------------
    // Village creation - First step of the game
    // ----------------------------------------------------------------------------------------------------------------
    static Settlement createSettlement() {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter village name: ");
        String settlementName = keyboard.nextLine();
        return new Village(settlementName);
    }

    // ----------------------------------------------------------------------------------------------------------------
    // USER INPUT
    // ----------------------------------------------------------------------------------------------------------------
    static String getUserCommand() {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter a command: ");
        return keyboard.nextLine();
    }
    static void receiveCommands(String command, Settlement settlement) throws UnknownCommandException {
        switch(command) {
            case "create house":
                House house = new House();
                settlement.addBuilding(house);
                break;
            case "create crop field":
                CropField cropField = new CropField();
                settlement.addBuilding(cropField);
                break;
            case "create well":
                Well well = new Well();
                settlement.addBuilding(well);
                break;
            case "new day":
                NewDay.newDay(settlement);
                break;
            case "show":
                System.out.println("Village: " + settlement.getName());
                System.out.println("Village size: " + settlement.getSettlementSize());
                System.out.println("Village population: " + settlement.getSettlementPopulation());
                System.out.println("Village resources: " + settlement.getResourceMap());
                break;
            case "end game":
                gameIsOn = false;
                break;
            default:
                throw new UnknownCommandException();
        }
    }
}
