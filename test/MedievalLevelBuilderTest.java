import dungeon.Level;
import dungeon.MedievalLevelBuilder;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MedievalLevelBuilderTest {
    private MedievalLevelBuilder medievalLevelBuilder;

    @Before
    public void setUp() {
        medievalLevelBuilder = new MedievalLevelBuilder(1, 1, 10, 4);
    }

    @Test
    public void test() {
        medievalLevelBuilder.addRoom("Room NO.0");
        medievalLevelBuilder.addGoblins(0, 7);
        medievalLevelBuilder.addOrc(0);
        medievalLevelBuilder.addOgre(0);
        medievalLevelBuilder.addHuman(0, "Aragorn", "Ranger of the North", 100);
        medievalLevelBuilder.addPotion(0);
        medievalLevelBuilder.addGold(0, 10);
        medievalLevelBuilder.addWeapon(0, "Trident");
        medievalLevelBuilder.addSpecial(0, "Ring", 100);
        Level level = medievalLevelBuilder.build();
        assertEquals("""
                Level 1 contains 1 rooms:

                Room 0 -- Room NO.0
                Monsters:
                \tgoblin (hitpoints = 7) is a mischievous and very unpleasant, vengeful, and greedy creature whose primary purpose is to cause trouble to humankind
                \tgoblin (hitpoints = 7) is a mischievous and very unpleasant, vengeful, and greedy creature whose primary purpose is to cause trouble to humankind
                \tgoblin (hitpoints = 7) is a mischievous and very unpleasant, vengeful, and greedy creature whose primary purpose is to cause trouble to humankind
                \tgoblin (hitpoints = 7) is a mischievous and very unpleasant, vengeful, and greedy creature whose primary purpose is to cause trouble to humankind
                \tgoblin (hitpoints = 7) is a mischievous and very unpleasant, vengeful, and greedy creature whose primary purpose is to cause trouble to humankind
                \tgoblin (hitpoints = 7) is a mischievous and very unpleasant, vengeful, and greedy creature whose primary purpose is to cause trouble to humankind
                \tgoblin (hitpoints = 7) is a mischievous and very unpleasant, vengeful, and greedy creature whose primary purpose is to cause trouble to humankind
                \torc (hitpoints = 20) is a brutish, aggressive, malevolent being serving evil
                \togre (hitpoints = 50) is a large, hideous man-like being that likes to eat humans for lunch
                \tAragorn (hitpoints = 100) is a Ranger of the North
                Treasures:
                \ta healing potion (value = 1)
                \tpieces of gold (value = 10)
                \tTrident (value = 10)
                \tRing (value = 100)
                """, level.toString());
    }

}
