package Events;

import lombok.Getter;

public enum EventsDescription {

    GAME_START("Welcome to Console City Builder! Build your settlement in 14 days and try to achieve the highest " +
            "population score."),
    NEW_DAY("A new day in the settlement begins, new challenges ahead!"),
    TARRASQUE_ATTACK("The most terrible of all monster has awakened and your poor settlement was ravaged by its " +
            "primordial fury. Most of the inhabitants died during the attack, survivors are coming out from the" +
            "to rebuild the settlement."),
    MONSTERS_ATTACK("The night is dark and full of terrors. Shadows roaming the forest quickly became terrible" +
            "monsters attacking the undefended people, killing many of them. Survivors pray not to witness these" +
            "horrors once again."),
    GOBLIN_RAID("They're not smart, they're not strong, damn they're neither scary, but there are so many it's " +
            "impossible to stop them from looting the village... Goblins take some random stuff and run away, " +
            "they probably don't even know what to do with it."),
    FLOODING("The river nearby is overflowing causing damage to the crop fields and killing some unlucky inhabitants." +
            "It'll take some time to recover."),
    REALLY_BAD_HARVEST("The harvest is terrible, famine is incoming if storages are running low..."),
    BAD_HARVEST("Crop fields aren't producing has expected lately, the settlement needs to adapt to this " +
            "misfortune."),
    GOOD_HARVEST("Crop fields are producing more than expected lately, surely the inhabitants are pleased."),
    REALLY_GOOD_HARVEST("Crop fields production is exceeding even the most optimistic predictions! Granaries " +
            "are likely to be filled in a short time!"),
    NEW_SETTLERS("New settlers searching a brand new start arrived today. Welcome them properly, they join " +
            "the inhabitants to build a better future."),
    GIFT_FROM_KING("News of the inhabitants work have arrived to the king's court. Goods are delivered to the" +
            "settlement, use them properly!");

    @Getter
    private final String description;

    private EventsDescription(String description) {
        this.description = description;
    }
}
