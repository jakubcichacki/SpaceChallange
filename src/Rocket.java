public class Rocket implements SpaceShip {

    public int rocketWeight;
    public int maxWeight;
    public int currentCargo = 0;
    public int cargoLimit;
    public static long costOfRocket;

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
        return currentCargo + item.getWeight() <= cargoLimit;
    }

    @Override
    public int carry(Item item) {
        return currentCargo += item.getWeight();
    }

}
