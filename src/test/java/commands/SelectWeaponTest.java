package commands;

import data.KnightInfo;
import data.WeaponList;
import database.ReadData;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

public class SelectWeaponTest {
    private KnightInfo knights=new KnightInfo();
    WeaponList allWeapon=new WeaponList();
    private List<WeaponList> knightsWeapon = new ArrayList<>();
    private  ResultOfCommand<String> result;
    ReadData readData=new ReadData();
//    @Test
//    public void selectWeaponFail(){
//        allWeapon.setAllweapon();
//        readData.readKnights(knights);
//        knightsWeapon.add(0,new WeaponList());
//        knightsWeapon.get(0).setAllweapon();
//        String simulatedUserInput = "0" +  System.getProperty("line.separator");
//        System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));
//        SelectWeapon weapon=new SelectWeapon(knights,allWeapon,knightsWeapon);
//        result = new ResultOfCommand<String>("Failed","Knight already has weapon",false);
//        Assert.assertEquals(result.Result(),weapon.execute().Result());
//    }
    @Test
    public void selectWeaponSuccess(){
//        knightequip.add(0,new EquipList());
//        knightequip.get(0).ArrayOfAll();
        allWeapon.setAllweapon();
        readData.readKnights(knights);
        String simulatedUserInput = "0" +  System.getProperty("line.separator")
                +"0"+  System.getProperty("line.separator")
                +"2"+  System.getProperty("line.separator")
                +"34"+  System.getProperty("line.separator");
        System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));
        result=new ResultOfCommand<>("Succeeded","Select weapon works",true);
        SelectWeapon del=new SelectWeapon(knights,allWeapon,knightsWeapon);
        Assert.assertEquals(result.Result(),del.execute().Result());
    }

}
