package Events;

import Settlements.Village;
import lombok.NonNull;

import java.util.Random;

public class RandomEvents {
    public static void tarrasqueAttack(@NonNull Village village) {
        village.reducePopulation(0.95);
        System.out.println(EventsDescription.TARRASQUE_ATTACK.getDescription());
    }

    public static void monstersAttack(@NonNull Village village) {
        village.reducePopulation(0.5);
        System.out.println(EventsDescription.MONSTERS_ATTACK.getDescription());
    }

    public static void goblinRaid(@NonNull Village village) {
        village.reducePopulation(0.01);
        village.getResourceMap().replaceAll((k, v) -> v * 0.85);
        System.out.println(EventsDescription.GOBLIN_RAID.getDescription());
    }

    public static void flooding(@NonNull Village village) {
        village.changeVillageCropFieldsProduction(-0.75);
        village.reducePopulation(0.10);
        village.getResourceMap().replaceAll((k, v) -> v * 0.90);
        System.out.println(EventsDescription.FLOODING.getDescription());
    }

    public static void reallyBadHarvest(@NonNull Village village) {
        village.changeVillageCropFieldsProduction(-0.25);
        System.out.println(EventsDescription.REALLY_BAD_HARVEST.getDescription());
    }

    public static void badHarvest(@NonNull Village village) {
        village.changeVillageCropFieldsProduction(-0.1);
        System.out.println(EventsDescription.BAD_HARVEST.getDescription());
    }

    public static void goodHarvest(@NonNull Village village) {
        village.changeVillageCropFieldsProduction(0.1);
        System.out.println(EventsDescription.GOOD_HARVEST.getDescription());
    }

    public static void reallyGoodHarvest(@NonNull Village village) {
        village.changeVillageCropFieldsProduction(0.25);
        System.out.println(EventsDescription.REALLY_GOOD_HARVEST.getDescription());
    }

    public static void newSettlers(@NonNull Village village) {
        Random random = new Random();
        int ranSettlers = random.nextInt(1, 10);
        village.changeSettlementPopulation(ranSettlers);
        System.out.println(EventsDescription.NEW_SETTLERS.getDescription());
    }

    public static void giftFromKing(@NonNull Village village) {
        village.updateResourceMap(100, 100, 100, 100);
        System.out.println(EventsDescription.GIFT_FROM_KING.getDescription());
    }
}
