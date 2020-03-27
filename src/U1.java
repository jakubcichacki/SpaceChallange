/*
Rocket cost = $100 Million
Rocket weight = 10 Tonnes
Max weight (with cargo) = 18 Tonnes
Chance of launch explosion = 5% * (cargo carried / cargo limit)
Chance of landing crash = 1% * (cargo carried / cargo limit)
 */

import java.util.Random;

public class U1 extends Rocket {

    public U1() {
        rocketWeight = 10000;
        maxWeight = 18000;
        costOfRocket = 100000000;
    }

    private Random random = new Random();
    private double chance = random.nextDouble();
    private double percentExplosion = 0.05;
    private double percentCrash = 0.01;

    @Override
    public boolean launch() {
        double chanceOfLaunchExplosion = percentExplosion * (cargoCarried / cargoLimit);
        if(chanceOfLaunchExplosion >= chance)
            return false;
        else return true;
    }

    @Override
    public boolean land() {
        double chanceOfLaunchCrash = percentCrash * (cargoCarried / cargoLimit);
        if(chanceOfLaunchCrash >= chance)
            return false;
        else return true;
    }
}
