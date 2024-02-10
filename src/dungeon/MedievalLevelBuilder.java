package dungeon;

public class MedievalLevelBuilder implements LevelBuilder {

    private final int numOfRooms;
    private final int numOfMonsters;
    private final int numOfTreasures;
    private int curNumOfRooms;
    private int curNumOfMonsters;
    private int curNumOfTreasures;
    private final Level level;

    public MedievalLevelBuilder(int levelNumber, int numOfRooms, int numOfMonsters, int numOfTreasures) {
        if (levelNumber < 0 || numOfRooms < 0 || numOfMonsters < 0 || numOfTreasures < 0) {
            throw new IllegalArgumentException("Number should not be negative");
        }
        this.numOfRooms = numOfRooms;
        this.numOfMonsters = numOfMonsters;
        this.numOfTreasures = numOfTreasures;
        this.curNumOfRooms = 0;
        this.curNumOfMonsters = 0;
        this.curNumOfTreasures = 0;
        level = new Level(levelNumber);
    }

    @Override
    public void addRoom(String description) {
        if (curNumOfRooms >= numOfRooms) {
            throw new IllegalStateException("Too many rooms");
        }
        level.addRoom(description);
        curNumOfRooms++;
    }

    @Override
    public void addGoblins(int roomNumber, int numOfGoblins) {
        if (roomNumber + 1 > curNumOfRooms) {
            throw new IllegalArgumentException("Room hasn't been created");
        }
        for (int i = 0; i < numOfGoblins; i++) {
            if (curNumOfMonsters >= numOfMonsters) {
                throw new IllegalStateException("Too many monsters");
            }
            level.addMonster(roomNumber, new Monster("goblin", "mischievous and very unpleasant, vengeful, and greedy" +
                    " creature whose primary purpose is to cause trouble to humankind", 7));
            curNumOfMonsters++;
        }
    }

    @Override
    public void addOrc(int roomNumber) {
        if (roomNumber + 1 > curNumOfRooms) {
            throw new IllegalArgumentException("Room hasn't been created");
        }
        if (curNumOfMonsters >= numOfMonsters) {
            throw new IllegalStateException("Too many monsters");
        }
        level.addMonster(roomNumber, new Monster("orc", "brutish, aggressive, malevolent being serving evil", 20));
        curNumOfMonsters++;
    }

    @Override
    public void addOgre(int roomNumber) {
        if (roomNumber + 1 > curNumOfRooms) {
            throw new IllegalArgumentException("Room hasn't been created");
        }
        if (curNumOfMonsters >= numOfMonsters) {
            throw new IllegalStateException("Too many monsters");
        }
        level.addMonster(roomNumber, new Monster("ogre", "large, hideous man-like being that likes to eat humans for " +
                "lunch", 50));
        curNumOfMonsters++;
    }

    @Override
    public void addHuman(int roomNumber, String name, String description, int hitpoints) {
        if (roomNumber + 1 > curNumOfRooms) {
            throw new IllegalArgumentException("Room hasn't been created");
        }
        if (curNumOfMonsters >= numOfMonsters) {
            throw new IllegalStateException("Too many monsters");
        }
        level.addMonster(roomNumber, new Monster(name, description, hitpoints));
        curNumOfMonsters++;
    }

    @Override
    public void addPotion(int roomNumber) {
        if (roomNumber + 1 > curNumOfRooms) {
            throw new IllegalArgumentException("Room hasn't been created");
        }
        if (curNumOfTreasures >= numOfTreasures) {
            throw new IllegalStateException("Too many treasures");
        }
        level.addTreasure(roomNumber, new Treasure("a healing potion", 1));
        curNumOfTreasures++;
    }

    @Override
    public void addGold(int roomNumber, int value) {
        if (roomNumber + 1 > curNumOfRooms) {
            throw new IllegalArgumentException("Room hasn't been created");
        }
        if (curNumOfTreasures >= numOfTreasures) {
            throw new IllegalStateException("Too many treasures");
        }
        level.addTreasure(roomNumber, new Treasure("pieces of gold", value));
        curNumOfTreasures++;
    }

    @Override
    public void addWeapon(int roomNumber, String description) {
        if (roomNumber + 1 > curNumOfRooms) {
            throw new IllegalArgumentException("Room hasn't been created");
        }
        if (curNumOfTreasures >= numOfTreasures) {
            throw new IllegalStateException("Too many treasures");
        }
        level.addTreasure(roomNumber, new Treasure(description, 10));
        curNumOfTreasures++;
    }

    @Override
    public void addSpecial(int roomNumber, String description, int value) {
        if (roomNumber + 1 > curNumOfRooms) {
            throw new IllegalArgumentException("Room hasn't been created");
        }
        if (curNumOfTreasures >= numOfTreasures) {
            throw new IllegalStateException("Too many treasures");
        }
        level.addTreasure(roomNumber, new Treasure(description, value));
        curNumOfTreasures++;
    }

    @Override
    public Level build() {
        if (curNumOfRooms < numOfRooms || curNumOfMonsters < numOfMonsters || curNumOfTreasures < numOfTreasures) {
            throw new IllegalStateException("Level hasn't been completed");
        }
        return level;
    }
}
