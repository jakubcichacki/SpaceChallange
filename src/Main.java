import javax.lang.model.type.ArrayType;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {

    public static void main(String args[]) {

        Simulation simulation = new Simulation();

        ArrayList<Item> loadItemsPhase1 = simulation.loadItems("phase-1.txt");
        ArrayList<Item> loadItemsPhase2 = simulation.loadItems("phase-2.txt");

        ArrayList<Rocket> fleetU1Phase1 = simulation.loadU1(loadItemsPhase1);
        ArrayList<Rocket> fleetU1Phase2 = simulation.loadU1(loadItemsPhase2);

        int budgetU1 = simulation.runSimulation(fleetU1Phase1) + simulation.runSimulation(fleetU1Phase2);
        System.out.println("Budget needed for mission with U1 rockets: " + budgetU1 + ".");

        ArrayList<Rocket> fleetU2Phase1 = simulation.loadU2(loadItemsPhase1);
        ArrayList<Rocket> fleetU2Phase2 = simulation.loadU2(loadItemsPhase2);

        int budgetU2 = simulation.runSimulation(fleetU2Phase1) + simulation.runSimulation(fleetU2Phase2);
        System.out.println("Budget needed for mission with U2 rockets: " + budgetU2 + ".");

    }
}
