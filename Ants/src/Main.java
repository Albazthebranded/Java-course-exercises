import Utils.Attack;
import Villagers.*;
import Utils.Population;

public class Main {

    static {
        System.out.print("\n\u001B[34mThis is a simulator of an ant colony.\nThe colony will start with a Queen,\n3 harvester ants, one warrior and one priest.\nHigher food amounts increase the chance for the\ncolony to come under attack.\nAnts have a religion and their gods will sometimes assist them.\u001B[0m\n");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main (String[] args) {

        developAntSociety();

    }

    public static void developAntSociety() {
        HarvesterAnts harvesters = new HarvesterAnts();
        WarriorAnts warriors = new WarriorAnts();
        QueenAnt queen = new QueenAnt();
        PriestAnts priests = new PriestAnts();
        Population population = new Population();
        Attack attack = new Attack();
        int dayCounter = 0;
        int attackCD = 0;
        boolean isQueenAlive = true;

        while (isQueenAlive) {

            dayCounter++;

            harvesters.contributeToSociety();
            harvesters.blessingOfTheHarvestGod();
            harvesters.growPopulation();
            harvesters.dieFromHunger();
            harvesters.negativePopulationToZero();
            System.out.printf("\nOn day %d, there are %d Harvester Ants in the colony.", dayCounter, harvesters.getPopulation());

            warriors.contributeToSociety();
            warriors.growPopulation();
            warriors.dieFromHunger();
            warriors.negativePopulationToZero();
            System.out.printf("\nOn day %d, there are %d Warrior Ants in the colony.", dayCounter, warriors.getPopulation());

            priests.contributeToSociety();
            priests.growPopulation();
            priests.dieFromHunger();
            priests.negativePopulationToZero();
            System.out.printf("\nOn day %d, there are %d Priest Ants in the colony.", dayCounter, priests.getPopulation());

            queen.contributeToSociety();
            queen.growPopulation();
            queen.dieFromHunger();
            queen.negativePopulationToZero();
            population.queenAloneCheck(harvesters, warriors, priests, queen);

            Villagers.negativeFoodToZero();

            System.out.printf("\nOn day %d, the Queen is alive and well.", dayCounter);
            System.out.printf("\nOn day %d, the amount of food the colony has is %d.", dayCounter, Villagers.getFood());
            System.out.printf("\nOn day %d, the colony has %d Favor with the Ant Gods.", dayCounter, Villagers.getFavor());

            System.out.printf("\nOn day %d, there are %d ants in the colony.", dayCounter, population.totalCurrentPopulation(harvesters.getPopulation(), warriors.getPopulation(), queen.getPopulation(), priests.getPopulation()));

            if (attack.isColonyUnderAttack(Villagers.getFood()) && attackCD == 0) {

                attackCD = 4;

                System.out.print("\nThe colony is under attack!");

                int assailantsCount = attack.assailantsCount(Villagers.getFood());

                System.out.printf("\nThere are %d enemies!", assailantsCount);

                if (Villagers.divineIntervention()) {
                    System.out.print("\n\u001B[33mThe Ant God of Death has smitten the invaders!\u001B[0m");
                    assailantsCount = 0;
                }

                int warriorsStartOfCombat = warriors.getPopulation();
                warriors.dieFromAttack(assailantsCount);
                assailantsCount -= warriorsStartOfCombat;
                warriors.negativePopulationToZero();
                System.out.printf("\n%d Warrior Ants have survived the attack.", warriors.getPopulation());

                if (assailantsCount > 0) {
                    int priestStartOfCombat = priests.getPopulation();
                    priests.dieFromAttack(assailantsCount);
                    assailantsCount -= priestStartOfCombat;
                    priests.negativePopulationToZero();
                    System.out.printf("\n%d Priest Ants have survived the attack.", priests.getPopulation());

                }
                if (assailantsCount > 0) {
                    int harvesterStartOfCombat = harvesters.getPopulation();
                    harvesters.dieFromAttack(assailantsCount);
                    assailantsCount -= harvesterStartOfCombat;
                    harvesters.negativePopulationToZero();
                    System.out.printf("\n%d Harvester Ants have survived the attack.", harvesters.getPopulation());

                }
                if (assailantsCount > 0) {
                    queen.dieFromAttack(assailantsCount);
                    System.out.print("\nThe Queen has survived the attack.");
                }
                warriors.emergencyMobilization();
            }

            System.out.println("\n------------------------------------------------------------------------------");

            if(attackCD <= 4 && attackCD > 0) {
                attackCD--;
            }

            if (queen.getPopulation() <= 0) {
                isQueenAlive = false;
            }

             try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
