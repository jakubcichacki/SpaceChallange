public interface SpaceShip {

    boolean launch();
    boolean land();
    int carry(Item item);
    boolean canCarry(Item item);

}
