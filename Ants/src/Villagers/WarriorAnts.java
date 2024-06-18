package Villagers;

import java.util.Random;

public class WarriorAnts extends Villagers {

    private static int population;
    public WarriorAnts(){
        population = 1;
    }

    @Override
    public void contributeToSociety() {
        super.contributeToSociety();
        food--;
    }

    @Override
    public void growPopulation() {
        if (food > population) {
            Random random = new Random();
            int growth = random.nextInt(0, 2);
            population+= growth;
            food-= 2 * growth;
        }

    }
    @Override
    public void dieFromAttack(int assailants) {
        population-= assailants;
    }
    public void dieFromHunger() {
        if (food <= 0) {
            population--;
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

    public void emergencyMobilization() {
        if (population < 10) {
            population+=10;
            food-=10;
            System.out.print("\n10 new Warriors have been spawned by the Queen!");
        }
    }
}
