import java.util.HashMap;

import Buildings.House;
import Buildings.CropField;


public class Game {

    public static void main(String[] args) {
        House house1 = new House();
        System.out.println(house1.houseInhabitants);
        System.out.println(house1.returnUpkeep());
        house1.changeUpkeepModifier(-0.1);
        System.out.println(house1.returnUpkeep());
        CropField cropField1 = new CropField();
        System.out.println(cropField1.);
    }

}
