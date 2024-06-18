package Utils;

import Villagers.HarvesterAnts;
import Villagers.PriestAnts;
import Villagers.QueenAnt;
import Villagers.WarriorAnts;

public class Population {

    public Population(){}

    public int totalCurrentPopulation(int popA, int popB, int popC, int popD) {
        return popA + popB + popC + popD;
    }

    public void colonyDeathCheck (int population) {
        if (population <= 0) {
            System.out.println("\n\u001B[31mThe colony has died out!\u001B[0m");
            System.exit(0);
        }
    }

    public void queenAloneCheck (HarvesterAnts harvesters, WarriorAnts warriors, PriestAnts priests, QueenAnt queen) {
        if (harvesters.getPopulation() == 0 && warriors.getPopulation() == 0 && priests.getPopulation() == 0) {
            queen.dieFromHunger(true);

        }

    }



}
