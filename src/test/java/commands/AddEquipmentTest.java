package commands;
import data.EquipList;
import data.KnightInfo;
import data.WeaponList;
import org.junit.Test;

import java.io.ByteArrayInputStream;

import static org.junit.Assert.assertEquals;
public class AddEquipmentTest {
    private ResultOfCommand<String> result;
    private KnightInfo knight=new KnightInfo();
    private EquipList equipLists=new EquipList();
    private WeaponList weaponLists=new WeaponList();
    @Test
    public void addEquipment(){
        knight.setKnights();
        equipLists.arrayOfAll();
        String simulatedUserInput = "5" +  System.getProperty("line.separator");
        System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));
        result = new ResultOfCommand<String>("Failed","Wrong number",false);
        AddEquipment del=new AddEquipment(equipLists,weaponLists);
        assertEquals(result.Result(),del.execute().Result());
    }
}
