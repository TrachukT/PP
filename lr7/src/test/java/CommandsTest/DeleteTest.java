package CommandsTest;

import commands.DeleteEquipment;
import commands.ResultOfCommand;
import data.EquipList;
import data.KnightInfo;
import data.WeaponList;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class DeleteTest {
    private KnightInfo knight=new KnightInfo();
    private List<EquipList> equipLists=new ArrayList<>();
    private List<WeaponList> weaponLists=new ArrayList<>();
    @Test
    public void deleteTestNoKnights(){
        ResultOfCommand<String> res = new ResultOfCommand<>("Failed","No knights",false);
        DeleteEquipment del=new DeleteEquipment(knight,equipLists,weaponLists);
        assertEquals(res.Result(),del.execute().Result());
    }
    @Test
    public void deleteTestEquip(){
        knight.setKnights();
        equipLists.add(0,new EquipList());
        equipLists.get(0).ArrayOfAll();
        String simulatedUserInput = "0" +  System.getProperty("line.separator")
                +"1" +  System.getProperty("line.separator")
                +"2" +  System.getProperty("line.separator");
        System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));
        ResultOfCommand<String> res = new ResultOfCommand<String>("Succeeded", "Equipment deleted", true);
        DeleteEquipment del=new DeleteEquipment(knight,equipLists,weaponLists);
        assertEquals(res.Result(),del.execute().Result());
    }
    @Test
    public void deleteTestWeapon(){
        knight.setKnights();
        weaponLists.add(0,new WeaponList());
        weaponLists.get(0).setAllweapon();
        String simulatedUserInput = "0" +  System.getProperty("line.separator")
                +"2" +  System.getProperty("line.separator")
                +"2" +  System.getProperty("line.separator");
        System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));
        ResultOfCommand<String> res = new ResultOfCommand<String>("Succeeded", "Weapon deleted", true);
        DeleteEquipment del=new DeleteEquipment(knight,equipLists,weaponLists);
        assertEquals(res.Result(),del.execute().Result());
    }
    @Test
    public void deleteTestWeaponOutOfRange(){
        knight.setKnights();
        weaponLists.add(0,new WeaponList());
        weaponLists.get(0).setAllweapon();
        String simulatedUserInput = "0" +  System.getProperty("line.separator")
                +"2" +  System.getProperty("line.separator")
                +"15" +  System.getProperty("line.separator");
        System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));
        ResultOfCommand<String> res = new ResultOfCommand<String>("Failed", "Impossible delete", false);
        DeleteEquipment del=new DeleteEquipment(knight,equipLists,weaponLists);
        assertEquals(res.Result(),del.execute().Result());
    }
    @Test
    public void deleteTestEquipOutOfRange(){
        knight.setKnights();
        equipLists.add(0,new EquipList());
        equipLists.get(0).ArrayOfAll();
        String simulatedUserInput = "0" +  System.getProperty("line.separator")
                +"1" +  System.getProperty("line.separator")
                +"15" +  System.getProperty("line.separator");
        System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));
        ResultOfCommand<String> res = new ResultOfCommand<String>("Failed", "Impossible delete", false);
        DeleteEquipment del=new DeleteEquipment(knight,equipLists,weaponLists);
        assertEquals(res.Result(),del.execute().Result());
    }
    @Test
    public void deleteTestWrongNumber(){
        knight.setKnights();
        equipLists.add(0,new EquipList());
        equipLists.get(0).ArrayOfAll();
        String simulatedUserInput = "0" +  System.getProperty("line.separator")
                +"4" +  System.getProperty("line.separator");
        System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));
        ResultOfCommand<String> res = new ResultOfCommand<String>("Failed", "Impossible delete", false);
        DeleteEquipment del=new DeleteEquipment(knight,equipLists,weaponLists);
        assertEquals(res.Result(),del.execute().Result());
    }
}
