package Villagers;

import java.util.Random;

public class PriestAnts extends Villagers {

    private static int population;
    public PriestAnts(){
        population = 1;
    }

    @Override
    public void contributeToSociety() {
        super.contributeToSociety();
        food--;
        favor += 2 * population;
    }
    @Override
    public void growPopulation() {
        if (food > favor) {
            population++;
            food--;
        }
    }
    @Override
    public void dieFromAttack(int assailants) {
        population-= assailants;
    }
    public void dieFromHunger() {
        if (food <= 0) {
            population=-1;
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
