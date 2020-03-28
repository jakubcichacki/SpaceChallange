/*
Rocket cost = $120 Million
Rocket weight = 18 Tonnes
Max weight (with cargo) = 29 Tonnes
Chance of launch explosion = 4% * (cargo carried / cargo limit)
Chance of landing crash = 8% * (cargo carried / cargo limit)
 */


import java.util.Random;

public class U2 extends Rocket {

    public U2() {
        rocketWeight = 18000;
        maxWeight = 29000;
        costOfRocket = 120000000;
        cargoLimit = 11000;
    }

    private Random random = new Random();
    private double chance = random.nextDouble();
    private double percentExplosion = 0.04;
    private double percentCrash = 0.08;

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
