package Villagers;

import java.util.Random;

public class QueenAnt extends Villagers {

    private static int population;

    public QueenAnt() {
        population = 1;

    }

    @Override
    public void contributeToSociety() {
        super.contributeToSociety();
        food-=4;

    }

    @Override
    public void growPopulation() {
    }
    @Override
    public void dieFromAttack(int assailants) {
        population--;
        System.out.println("\n\u001B[31mThe Queen has been killed by the enemy! The colony dies with her.\u001B[0m");
        System.exit(0);
    }
    public void dieFromHunger() {
        if (food <= 0) {
            Random random = new Random();
            int queenDeathChance = random.nextInt(1, 10);
            if (queenDeathChance == 10) {
                population = 0;
                System.out.println("\n\u001B[31mThe Queen has died from hunger! The colony dies with her.\u001B[0m");
                System.exit(0);
            }
        }
    }
    public void dieFromHunger(boolean alone) {
        if (alone) {
            population = 0;
            System.out.println("\n\u001B[31mThe Queen has died from hunger! The colony dies with her.\u001B[0m");
            System.exit(0);
        }
    }

    public int getPopulation(){
        return population;
    }
    public void negativePopulationToZero() {
        if (population < 0) {
            population = 0;
        }
    }
}
