package commands;

import data.EquipList;
import data.KnightInfo;
import database.ReadData;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SelectTest {
    private KnightInfo knightlist=new KnightInfo();
    private EquipList equiplist=new EquipList();
    private List<EquipList> knightequip=new ArrayList<>();
    ReadData readData=new ReadData();
    ResultOfCommand<String> result;
//    @Test
//    public void selectEquipFail(){
//        knightequip.add(0,new EquipList());
//        knightequip.get(0).arrayOfAll();
//        readData.readKnights(knightlist);
//        String simulatedUserInput = "0" +  System.getProperty("line.separator");
//        System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));
//        result=new ResultOfCommand<>("Failed","Knight already has equipment",false);
//        SelectEquipment del=new SelectEquipment(knightlist,equiplist,knightequip);
//        Assert.assertEquals(result.Result(),del.execute().Result());
//    }
    @Test
    public void selectEquipSuccess(){
//        knightequip.add(0,new EquipList());
//        knightequip.get(0).ArrayOfAll();
        equiplist.arrayOfAll();
        readData.readKnights(knightlist);
        String simulatedUserInput = "0" +  System.getProperty("line.separator")
                +"0"+  System.getProperty("line.separator")
                +"1"+  System.getProperty("line.separator")
                +"34"+  System.getProperty("line.separator");
        System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));
        result=new ResultOfCommand<>("Succeeded","Select equipment works",true);
        SelectEquipment del=new SelectEquipment(knightlist,equiplist,knightequip);
        Assert.assertEquals(result.Result(),del.execute().Result());
    }
}
