package CommandsTest;

import commands.Menu;
import org.junit.Test;

import java.io.ByteArrayInputStream;

public class MenuTest {
    @Test
    public void menuTest() throws Exception {
        String input = "1" +System.getProperty("line.separator")
                +"0" +System.getProperty("line.separator");
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Menu menu=new Menu();
        menu.menu();
    }
    @Test
    public void menuEquip() throws Exception {
        String input = "7" +System.getProperty("line.separator")
        +"5" +System.getProperty("line.separator");
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Menu menu=new Menu();
        menu.menuOfEquipment();
    }
}
