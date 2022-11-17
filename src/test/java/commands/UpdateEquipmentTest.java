package commands;

import data.EquipList;
import data.WeaponList;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;

public class UpdateEquipmentTest {
    private ResultOfCommand<String> result;
    private WeaponList weaponList=new WeaponList();
    private EquipList equipList=new EquipList();
    @Test
    public void UpdateFail(){
        result=new ResultOfCommand<>("Failed","Wrong number",false);
        String simulatedUserInput = "0" +  System.getProperty("line.separator");
        System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));
        UpdateEquipment weapon=new UpdateEquipment(equipList,weaponList);
        Assert.assertEquals(result.Result(),weapon.execute().Result());
    }
    @Test
    public void UpdateEquip(){
        equipList.arrayOfAll();
        weaponList.setAllweapon();
        result=new ResultOfCommand<>("Succeeded","Update equipment works",true);
        String simulatedUserInput = "1" +  System.getProperty("line.separator")
                +"1" +  System.getProperty("line.separator")
                +"10,23" +  System.getProperty("line.separator");
        System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));
        UpdateEquipment weapon=new UpdateEquipment(equipList,weaponList);
        Assert.assertEquals(result.Result(),weapon.execute().Result());
    }
    @Test
    public void UpdateWeapon(){
        equipList.arrayOfAll();
        weaponList.setAllweapon();
        result = new ResultOfCommand<String>("Succeeded","Update weapon works",true);
        String simulatedUserInput = "2" +  System.getProperty("line.separator")
                +"3" +  System.getProperty("line.separator")
                +"10,23" +  System.getProperty("line.separator");
        System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));
        UpdateEquipment weapon=new UpdateEquipment(equipList,weaponList);
        Assert.assertEquals(result.Result(),weapon.execute().Result());
    }
}
