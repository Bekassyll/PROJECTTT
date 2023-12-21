import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


// INTERFACE FOR CREATE UNITS
interface UnitFactory {
    Unit createUnit();
}

// FACTORYS FOR CREATE UNITS
class InfantryFactory implements UnitFactory {
    @Override
    public Unit createUnit() {
        return new Infantry();
    }
}

class CavalryFactory implements UnitFactory {
    @Override
    public Unit createUnit() {
        return new Cavalry();
    }
}

class ArchersFactory implements UnitFactory {
    @Override
    public Unit createUnit() {
        return new Archers();
    }
}

class CatapultFactory implements UnitFactory {
    @Override
    public Unit createUnit() {
        return new Catapult();
    }
}

// INTERFACE FOR UNIT COMMANDS
interface Unit {
    void haveunits();
    void attack();

    void defend();

    void retreat();

    void back();

    void forward();

}

// UNIT CLASSES
class Infantry implements Unit {
    public void haveunits() {
        System.out.println("You have 100 infantry");
    }
    @Override
    public void attack() {
        System.out.println("Infantry attacks!");
    }

    @Override
    public void defend() {
        System.out.println("Infantry defends positions!");
    }

    public void retreat() {
        System.out.println("The infantry is retreating from the battlefield!");
    }

    public void back() {
        System.out.println("Infantry back 30 steps!");
    }

    public void forward() {
        System.out.println("Infantry forward 30 steps!");
    }
}

class Cavalry implements Unit {
    public void haveunits() {
        System.out.println("You have 70 cavalrymen");
    }
    @Override
    public void attack() {
        System.out.println("Cavalry attacks!");
    }

    @Override
    public void defend() {
        System.out.println("The cavalry quickly responds to the threat!");
    }

    public void retreat() {
        System.out.println("The cavalry is retreating from the battlefield!");
    }

    public void back() {
        System.out.println("Cavalry back 30 steps!");
    }

    public void forward() {
        System.out.println("Cavalry forward 30 steps!");
    }
}

class Archers implements Unit {
    public void haveunits() {
        System.out.println("You have 50 archers");
    }
    @Override
    public void attack() {
        System.out.println("Archers shoot!");
    }

    @Override
    public void defend() {
        System.out.println("The archers retreat into position!");
    }

    public void retreat() {
        System.out.println("The archers are retreating from the battlefield!");
    }

    public void back() {
        System.out.println("Archers back 30 steps!");
    }

    public void forward() {
        System.out.println("Archers forward 30 steps!");
    }
}

class Catapult implements Unit {
    public void haveunits() {
        System.out.println("You have 10 catapults");
    }
    @Override
    public void attack() {
        System.out.println("Catapult salvo!");
    }

    @Override
    public void defend() {
        System.out.println("Defend the Catapult!");
    }

    public void retreat() {
        System.out.println("Catapults retreat!");
    }

    public void back() {
        System.out.println("Catapults back!");
    }

    public void forward() {
        System.out.println("Catapults forward!");
    }
}

// INTERFACE STRATEGY
interface BattleStrategy {
    void executeStrategy();
}

// STRATEGY FOR WAR
class AttackStrategy implements BattleStrategy {
    @Override
    public void executeStrategy() {
        System.out.println("Strategy: Attack!");
    }
}

class DefenseStrategy implements BattleStrategy {
    @Override
    public void executeStrategy() {
        System.out.println("Strategy: Defense!");
    }
}

class RetreatStrategy implements BattleStrategy {
    @Override
    public void executeStrategy() {
        System.out.println("Strategy: Retreat!");
    }
}

class BackStrategy implements BattleStrategy {
    @Override
    public void executeStrategy() {
        System.out.println("Strategy: Back!");
    }
}

class ForwardStrategy implements BattleStrategy {
    @Override
    public void executeStrategy() {
        System.out.println("Strategy: Forward!");
    }
}


// GAME OBJECTS
class GameObject {
    private final List<Unit> units = new ArrayList<>();
    private final List<Unit> firstplayerUnits = new ArrayList<>();
    private final List<Unit> secondplayerUnits = new ArrayList<>();
    public void addUnit(Unit unit) {
        units.add(unit);
    }

    public void addFirstPlayerUnits(Unit unit) {
        firstplayerUnits.add(unit);
    }

    public void addSecondPlayerUnits(Unit unit) {
        secondplayerUnits.add(unit);
    }


    public void executeUnits(BattleStrategy ignoredStrategy) {
        for (Unit unit : units) {
            unit.haveunits();
        }
    }

    public void executeAttack(BattleStrategy strategy) {
        strategy.executeStrategy();
        for (Unit unit : units) {
            unit.attack();
        }
    }

    public void executeDefend(BattleStrategy strategy) {
        strategy.executeStrategy();
        for (Unit unit : units) {
            unit.defend();
        }
    }

    public void executeRetreat(BattleStrategy strategy) {
        strategy.executeStrategy();
        for (Unit unit : units) {
            unit.retreat();
        }
    }

    public void executeBack(BattleStrategy strategy) {
        strategy.executeStrategy();
        for (Unit unit : units) {
            unit.back();
        }
    }

    public void executeForward(BattleStrategy strategy) {
        strategy.executeStrategy();
        for (Unit unit : units) {
            unit.forward();
        }
    }
}

// GAME START
public class StrategyGame {
    public static void main(String[] args) {

        GameObject gameObject = new GameObject();
        int initialInfantryCount = 100;
        int initialCavalryCount = 70;
        int initialArchersCount = 50;
        int initialCatapultCount = 10;

        // COUNT UNITS
        int initialFirstPlayer = initialInfantryCount + initialCavalryCount + initialArchersCount + initialCatapultCount;
        int initialSecondPlayer = initialInfantryCount + initialCavalryCount + initialArchersCount + initialCatapultCount;
        Scanner scanner = new Scanner(System.in);

        // CREATE FACTORY FOR UNITS
        UnitFactory infantryFactory = new InfantryFactory();
        UnitFactory cavalryFactory = new CavalryFactory();
        UnitFactory archersFactory = new ArchersFactory();
        UnitFactory catapultFactory = new CatapultFactory();

        // CREATE UNITS WITH FACTORY
        Unit infantryUnit = infantryFactory.createUnit();
        Unit cavalryUnit = cavalryFactory.createUnit();
        Unit archersUnit = archersFactory.createUnit();
        Unit catapultUnit = catapultFactory.createUnit();


        // ADD UNITS OF GAME OBJECT
        gameObject.addUnit(infantryUnit);
        gameObject.addUnit(cavalryUnit);
        gameObject.addUnit(archersUnit);
        gameObject.addUnit(catapultUnit);

        GameObject firstSide = new GameObject();
        GameObject secondSide = new GameObject();

        firstSide.addFirstPlayerUnits(infantryUnit);
        firstSide.addFirstPlayerUnits(cavalryUnit);
        firstSide.addFirstPlayerUnits(archersUnit);
        firstSide.addFirstPlayerUnits(catapultUnit);

        secondSide.addSecondPlayerUnits(infantryUnit);
        secondSide.addSecondPlayerUnits(cavalryUnit);
        secondSide.addSecondPlayerUnits(archersUnit);
        secondSide.addSecondPlayerUnits(catapultUnit);

        int firstPlayerLoss = 0;
        int secondPlayerLoss = 0;
        for (int i = 0; i < 2; i++) {
            System.out.println("Player " + (i + 1) + ", choose a strategy: (1 - Attack!, 2 - Defense!, 3 - Retreat!, 4 - Back!, 5 - Forward!)");
            int strategyChoice = scanner.nextInt();
            System.out.println("---------------------------------------------------");
            BattleStrategy selectedStrategy;

            int attackLoss = 45;
            int defenseLoss = 29;

            // LOSSES FOR FIRST AND SECOND PLAYER
            firstPlayerLoss = 0;
            secondPlayerLoss = 0;


            switch (strategyChoice) {
                case 1:
                    selectedStrategy = new AttackStrategy();
                    gameObject.executeAttack(selectedStrategy);
                    firstPlayerLoss = initialFirstPlayer * attackLoss / 100;
                    secondPlayerLoss = initialSecondPlayer * attackLoss / 100;
                    System.out.println("---------------------------------------------------");
                    System.out.println("Army composition:");
                    gameObject.executeUnits(selectedStrategy);
                    System.out.println("---------------------------------------------------");
                    break;
                case 2:
                    selectedStrategy = new DefenseStrategy();
                    gameObject.executeDefend(selectedStrategy);
                    firstPlayerLoss = initialFirstPlayer * defenseLoss / 100;
                    secondPlayerLoss = initialSecondPlayer * attackLoss / 100;
                    System.out.println("---------------------------------------------------");
                    System.out.println("Army composition:");
                    gameObject.executeUnits(selectedStrategy);
                    System.out.println("---------------------------------------------------");
                    break;
                case 3:
                    selectedStrategy = new RetreatStrategy();
                    gameObject.executeRetreat(selectedStrategy);
                    System.out.println("---------------------------------------------------");
                    System.out.println("Army composition:");
                    gameObject.executeUnits(selectedStrategy);
                    System.out.println("---------------------------------------------------");
                    break;
                case 4:
                    selectedStrategy = new BackStrategy();
                    gameObject.executeBack(selectedStrategy);
                    System.out.println("---------------------------------------------------");
                    System.out.println("Army composition:");
                    gameObject.executeUnits(selectedStrategy);
                    System.out.println("---------------------------------------------------");
                    System.out.println("\nYou stepped back. Simply movement is selected. Select again.");
                    i--; // AGAIN CHOOSE
                    break;
                case 5:
                    selectedStrategy = new ForwardStrategy();
                    gameObject.executeForward(selectedStrategy);
                    System.out.println("---------------------------------------------------");
                    System.out.println("Army composition:");
                    gameObject.executeUnits(selectedStrategy);
                    System.out.println("---------------------------------------------------");
                    System.out.println("\nYou have approached the enemy. Simply movement is selected. Select again.");
                    i--;
                    break;
                default:
                    System.out.println("An invalid strategy was selected. Select again.");
                    i--; // AGAIN CHOOSE
            }
        }


        System.out.println("Total number of first player soldiers: " + initialFirstPlayer);
        System.out.println("Total number of second player soldiers: " + initialSecondPlayer);

        // OUTPUT LOSS
        System.out.println("Losses based on selected strategies:");
        System.out.println("Losses for the first player: " + firstPlayerLoss);
        System.out.println("Losses for the second player: " + secondPlayerLoss);

        int remainingFirstPlayer = initialFirstPlayer - firstPlayerLoss;
        int remainingSecondPlayer = initialSecondPlayer - secondPlayerLoss;

        System.out.println("Remaining soldiers for the first player: " + remainingFirstPlayer);
        System.out.println("Remaining soldiers for the second player: " + remainingSecondPlayer);

        scanner.close();
    }
}
