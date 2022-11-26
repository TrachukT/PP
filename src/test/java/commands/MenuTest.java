package commands;

import data.Login;
import data.Loginlist;
import database.ReadData;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

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
        Loginlist loginlist=new Loginlist();
        ReadData readData=new ReadData();
        readData.readLogins(loginlist);
        menu.menuOfEquipment(loginlist.getelem(3),loginlist);
    }
}
