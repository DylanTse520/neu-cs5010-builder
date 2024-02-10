package dungeon;

public interface LevelBuilder {

    void addRoom(String description);

    void addGoblins(int roomNumber, int numOfGoblins);

    void addOrc(int roomNumber);

    void addOgre(int roomNumber);

    void addHuman(int roomNumber, String name, String description, int hitpoints);

    void addPotion(int roomNumber);

    void addGold(int roomNumber, int value);

    void addWeapon(int roomNumber, String description);

    void addSpecial(int roomNumber, String description, int value);

    Level build();

}
