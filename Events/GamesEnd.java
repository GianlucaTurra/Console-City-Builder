package Events;

import Settlements.Settlement;
import lombok.NonNull;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class GamesEnd {

    private static int daysCounter = 0;

    public static int newDayCounter() {
        return ++daysCounter;
    }

    public static boolean checkGameEnd() {
        return (daysCounter == 14);
    }

    public static boolean checkIfFileIsEmpty() {
        File savesFile = new File("High Scores");
        return (savesFile.length() == 0);
    }

    public static int getHighestScore() {
        try(FileReader savesFile = new FileReader("High Scores")) {
            return savesFile.read();
        } catch (IOException ioe) {
            System.out.println("An error occurred during high score file reading.");
            ioe.printStackTrace();
            return 0;
        }
    }

    public static void saveHighScore(@NonNull Settlement settlement) {
        try(FileWriter savesFile = new FileWriter("High Scores", false)) {
            savesFile.write(settlement.getSettlementPopulation());
        } catch (IOException ioe) {
            System.out.println("An error during score saving occurred.");
            ioe.printStackTrace();
        }
    }

    public static void gamesEnd(Settlement settlement) {
        int highestScore = 0;
        if (checkIfFileIsEmpty()) {
            saveHighScore(settlement);
        } else {
            highestScore = getHighestScore();
        }
        if (settlement.getSettlementPopulation() > highestScore) {
            System.out.println("New highest score achieved: " + settlement.getSettlementPopulation());
            saveHighScore(settlement);
        } else {
            System.out.println("Your score is: " + settlement.getSettlementPopulation());
            System.out.println("Highest score: " + highestScore);
        }
    }
}
