package Villagers;

import java.util.Random;

public class HarvesterAnts extends Villagers {


    private static int population;
    public HarvesterAnts() {
        population = 3;

    }

    @Override
    public void contributeToSociety() {
        super.contributeToSociety();
        food += 3 * population;
    }

    @Override
    public void growPopulation() {
        if (population < 2 * food) {
            Random random = new Random();
            int growth = random.nextInt(0, 2);
            population+= growth;
            food-= growth;
        }
    }

    public int getPopulation(){
        return population;
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
    public void negativePopulationToZero() {
        if (population < 0) {
            population = 0;
        }
    }
    public void blessingOfTheHarvestGod () {
        Random random = new Random();
        int favorChance = random.nextInt(10,20);

        if (favor > favorChance) {
            food += population * 3;
            favor = 1;
            System.out.print("\n\u001B[32mThe Harvest God has blessed the colony! Today's harvest is twice as plentiful!\u001B[0m");
        }
    }
}
