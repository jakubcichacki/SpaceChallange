public class Rocket implements SpaceShip {

    public int rocketWeight;
    public int maxWeight;
    public int currentWeight = rocketWeight;
    public static int costOfRocket;
    public int cargoCarried = currentWeight - rocketWeight;
    public int cargoLimit;

    @Override
    public boolean launch() {
        return true;
    }

    @Override
    public boolean land() {
        return true;
    }

    @Override
    public boolean canCarry(Item item) {
        if (currentWeight + item.getWeight() <= maxWeight)
            return true;
        else return false;
    }

    @Override
    public int carry(Item item) {
       return currentWeight += item.getWeight();
    }

}
