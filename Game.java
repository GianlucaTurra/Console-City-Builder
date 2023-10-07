import Buildings.House;

import java.util.HashMap;

public class Game {

    public static void main(String[] args) {
        House house1 = new House();
        house1.inhabitants = 2;
        HashMap<String, Integer> dailyHouseUpkeep = house1.houseUpkeep();
        System.out.println(dailyHouseUpkeep);
    }

}
