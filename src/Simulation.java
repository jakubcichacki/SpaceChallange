import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Simulation {

    ArrayList <Item> loadItems(String nameOfFile) {
        ArrayList<Item> listOfItemsFromFile = new ArrayList<>();
        File file = new File(nameOfFile);
        Scanner scanner;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("File error");
            return null;
        }

        Pattern pattern = Pattern.compile("(.+)=(.+)");

        while (scanner.hasNextLine()) {
            String lineFromFile = scanner.nextLine();
            Matcher matcher = pattern.matcher(lineFromFile);

            if (matcher.matches()) {
                Item item = new Item();
                item.setName(matcher.group(1));
                item.setWeight(Integer.parseInt(matcher.group(2)));
                listOfItemsFromFile.add(item);
            }

        }

        return listOfItemsFromFile;
    }

    ArrayList<Rocket> loadU1 (ArrayList<Item> items) {
        Rocket rocketU1 = new U1();
        ArrayList<Rocket> listOfU1s = new ArrayList<>();

        listOfU1s.add(rocketU1);
        Rocket lastRocket = listOfU1s.get(0);

        for (Item item : items) {
            if (!lastRocket.canCarry(item)) {
                rocketU1 = new U1();
                listOfU1s.add(rocketU1);
                lastRocket = listOfU1s.get(listOfU1s.size() - 1);

            }
            lastRocket.carry(item);
        }

        if (lastRocket.currentCargo == 0) {
            listOfU1s.remove(listOfU1s.size()-1);
        }

        return listOfU1s;
    }

    ArrayList<Rocket> loadU2 (ArrayList<Item> items) {
        Rocket rocketU2 = new U2();
        ArrayList<Rocket> listOfU2s = new ArrayList<>();

        listOfU2s.add(rocketU2);
        Rocket lastRocket = listOfU2s.get(0);

        for (Item item : items) {
            if (!lastRocket.canCarry(item)) {
                rocketU2 = new U2();
                listOfU2s.add(rocketU2);
                lastRocket = listOfU2s.get(listOfU2s.size() - 1);

            }
            lastRocket.carry(item);
        }

        if (lastRocket.currentCargo == 0) {
            listOfU2s.remove(listOfU2s.size()-1);
        }

        return listOfU2s;
    }

    long runSimulation(ArrayList<Rocket> rocketArrayList) {
        int numbersOfRocketsToSend = rocketArrayList.size();

        for (Rocket rocket : rocketArrayList) {
            while (!rocket.launch()) {
                numbersOfRocketsToSend++;
                rocket.launch();
            }
        }
        for (Rocket rocket : rocketArrayList) {
            while (!rocket.land()) {
                numbersOfRocketsToSend++;
                rocket.land();
            }
        }

        return Rocket.costOfRocket * numbersOfRocketsToSend;
    }


}
