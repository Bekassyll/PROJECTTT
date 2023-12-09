
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import java.util.ArrayList;
import java.util.List;
// Интерфейс для создания юнитов

interface UnitFactory {
    Unit createUnit();
}

// Конкретные фабрики для создания юнитов разных типов
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

// Интерфейс для базового класса юнитов
interface Unit {
    void attack();

    void defend();
}

// Конкретные классы юнитов
class Infantry implements Unit {
    @Override
    public void attack() {
        System.out.println("Пехота атакует!");
    }

    @Override
    public void defend() {
        System.out.println("Пехота защищает позиции!");
    }
}

class Cavalry implements Unit {
    @Override
    public void attack() {
        System.out.println("Кавалерия атакует!");
    }

    @Override
    public void defend() {
        System.out.println("Кавалерия быстро реагирует на угрозу!");
    }
}

// Класс стратегии
interface BattleStrategy {
    void executeStrategy();
}

// Конкретные стратегии для боя
class AttackStrategy implements BattleStrategy {
    @Override
    public void executeStrategy() {
        System.out.println("Стратегия: Нападение!");
    }
}

class DefenseStrategy implements BattleStrategy {
    @Override
    public void executeStrategy() {
        System.out.println("Стратегия: Защита!");
    }
}

// Класс игрового объекта
class GameObject {
    private List<Unit> units = new ArrayList<>();

    public void addUnit(Unit unit) {
        units.add(unit);
    }

    public void executeAction(BattleStrategy strategy) {
        strategy.executeStrategy();
        for (Unit unit : units) {
            unit.attack();
            unit.defend();
        }
    }
}

// Класс для запуска игры
public class StrategyGame {
    public static void main(String[] args) {
        GameObject gameObject = new GameObject();

        // Создаем фабрики для юнитов
        UnitFactory infantryFactory = new InfantryFactory();
        UnitFactory cavalryFactory = new CavalryFactory();

        // Создаем юнитов через фабрики
        Unit infantryUnit = infantryFactory.createUnit();
        Unit cavalryUnit = cavalryFactory.createUnit();

        // Добавляем юнитов в игровой объект
        gameObject.addUnit(infantryUnit);
        gameObject.addUnit(cavalryUnit);

        // Выполняем стратегию боя
        BattleStrategy attackStrategy = new AttackStrategy();
        gameObject.executeAction(attackStrategy);
        BattleStrategy defenseStrategy = new DefenseStrategy();
        gameObject.executeAction(defenseStrategy);
    }
}