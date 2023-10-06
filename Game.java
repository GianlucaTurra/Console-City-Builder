import java.util.HashMap;

public class Game {

    public static void main(String[] args) {
        Buildings.House house1 = new Buildings.House();
        house1.inhabitants = 2;
        HashMap<String, Integer> dailyHouseUpkeep = house1.houseUpkeep();
        System.out.println(dailyHouseUpkeep);
    }

}
