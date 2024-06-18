package Villagers;

import java.util.Random;

public abstract class Villagers {


    static protected int food = 10;
    static protected int favor = 0;

    public Villagers(){}

    public void contributeToSociety(){
        food-=getPopulation();
    }

    public abstract void growPopulation();

    public abstract int getPopulation();
    public abstract void dieFromAttack(int assailants);
    public abstract void dieFromHunger();
    public abstract void negativePopulationToZero();




    public static int getFood() {
        return food;
    }
    public static void negativeFoodToZero() {
        if (food < 0) {
            food = 0;
        }
    }
    public static int getFavor() {
        return favor;
    }

    public static boolean divineIntervention() {
        Random random = new Random();
        if (favor > 0 && random.nextBoolean()) {
            favor = 0;
            return true;
        } else {
            return false;
        }
    }

}
