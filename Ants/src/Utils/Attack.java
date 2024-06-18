package Utils;

import java.util.Random;


public class Attack {

    public Attack() {}

    public boolean isColonyUnderAttack(int food) {
        Random random = new Random();
        int chance = random.nextInt(50, 100);
        return food > chance;
    }

    public int assailantsCount(int food) {
        Random random = new Random();
        return random.nextInt(0, food/5);
    }

}
