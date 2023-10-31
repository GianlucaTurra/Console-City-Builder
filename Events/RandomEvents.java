package Events;

import Settlements.Settlement;
import Settlements.Village;
import lombok.NonNull;

import java.util.Random;

public class RandomEvents {
    public static void tarrasqueAttack(@NonNull Settlement settlement) {
        settlement.reducePopulation(0.95);
        System.out.println(EventsDescription.TARRASQUE_ATTACK.getDescription());
    }

    public static void monstersAttack(@NonNull Settlement settlement) {
        settlement.reducePopulation(0.5);
        System.out.println(EventsDescription.MONSTERS_ATTACK.getDescription());
    }

    public static void goblinRaid(@NonNull Settlement settlement) {
        settlement.reducePopulation(0.01);
        settlement.getResourceMap().replaceAll((k, v) -> v * 0.85);
        System.out.println(EventsDescription.GOBLIN_RAID.getDescription());
    }

    public static void flooding(@NonNull Settlement settlement) {
        settlement.changeCropFieldsProduction(-0.75);
        settlement.reducePopulation(0.10);
        settlement.getResourceMap().replaceAll((k, v) -> v * 0.90);
        System.out.println(EventsDescription.FLOODING.getDescription());
    }

    public static void reallyBadHarvest(@NonNull Settlement settlement) {
        settlement.changeCropFieldsProduction(-0.25);
        System.out.println(EventsDescription.REALLY_BAD_HARVEST.getDescription());
    }

    public static void badHarvest(@NonNull Settlement settlement) {
        settlement.changeCropFieldsProduction(-0.1);
        System.out.println(EventsDescription.BAD_HARVEST.getDescription());
    }

    public static void goodHarvest(@NonNull Settlement settlement) {
        settlement.changeCropFieldsProduction(0.1);
        System.out.println(EventsDescription.GOOD_HARVEST.getDescription());
    }

    public static void reallyGoodHarvest(@NonNull Settlement settlement) {
        settlement.changeCropFieldsProduction(0.25);
        System.out.println(EventsDescription.REALLY_GOOD_HARVEST.getDescription());
    }

    public static void newSettlers(@NonNull Settlement settlement) {
        Random random = new Random();
        int ranSettlers = random.nextInt(1, 10);
        settlement.changeSettlementPopulation(ranSettlers);
        System.out.println(EventsDescription.NEW_SETTLERS.getDescription());
    }

    public static void giftFromKing(@NonNull Settlement settlement) {
        settlement.updateResourceMap(100, 100, 100, 100);
        System.out.println(EventsDescription.GIFT_FROM_KING.getDescription());
    }
}
