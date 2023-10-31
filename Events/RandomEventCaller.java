package Events;

import CustomErrors.RandomEvetOutOfRange;
import Settlements.Settlement;

import java.util.Random;

public class RandomEventCaller {

    static int generateRandomPercentageNumber() {
        Random random = new Random();
        return random.nextInt(1, 100);
    }

    static int generateEventNumber() {
        int randomNumber = generateRandomPercentageNumber();
        int eventNumber = 0;
        if (randomNumber == 1) eventNumber = 1; // tarrasque
        if (randomNumber > 1 && randomNumber <= 8) eventNumber = 2; // monsters
        if (randomNumber > 8 && randomNumber <= 15) eventNumber = 3; // flooding
        if (randomNumber > 15 && randomNumber <= 25) eventNumber = 4; // goblin raid
        if (randomNumber > 25 && randomNumber <= 35) eventNumber = 5; // really bad harvest
        if (randomNumber > 35 && randomNumber <= 50) eventNumber = 6; // bad harvest
        if (randomNumber > 50 && randomNumber <= 75) eventNumber = 7; // good harvest
        if (randomNumber > 75 && randomNumber <= 85) eventNumber = 8; // really good harvest
        if (randomNumber > 85 && randomNumber <= 95) eventNumber = 9; // new settlers
        if (randomNumber > 95 && randomNumber <= 100) eventNumber = 10; // gift from the king
        return eventNumber;
    }

    static void callRandomEvent(Settlement settlement) throws RandomEvetOutOfRange {
        switch (generateEventNumber()) {
            case 1:
                RandomEvents.tarrasqueAttack(settlement);
                break;
            case 2:
                RandomEvents.monstersAttack(settlement);
                break;
            case 3:
                RandomEvents.flooding(settlement);
                break;
            case 4:
                RandomEvents.goblinRaid(settlement);
                break;
            case 5:
                RandomEvents.reallyBadHarvest(settlement);
                break;
            case 6:
                RandomEvents.badHarvest(settlement);
                break;
            case 7:
                RandomEvents.goodHarvest(settlement);
                break;
            case 8:
                RandomEvents.reallyGoodHarvest(settlement);
                break;
            case 9:
                RandomEvents.newSettlers(settlement);
                break;
            case 10:
                RandomEvents.giftFromKing(settlement);
                break;
            default:
                throw new RandomEvetOutOfRange();
        }
    }
}
