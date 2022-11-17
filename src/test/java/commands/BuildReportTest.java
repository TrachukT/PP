package commands;

import data.EquipList;
import data.KnightInfo;
import data.WeaponList;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BuildReportTest {
    private ResultOfCommand<String> result;
    private KnightInfo knight=new KnightInfo();
    private List<EquipList> equipLists=new ArrayList<>();
    private List<WeaponList> weaponLists=new ArrayList<>();
    @Test
    public void testReportNoKnigths() throws IOException {
        result=new ResultOfCommand<>("Succeeded","There is no knights",true);
        BuildReport report=new BuildReport(knight,equipLists,weaponLists);
//        ResultOfCommand<String> res=report.execute();
        assertEquals(result.Result(),report.execute().Result());
    }
    @Test
    public void testReportsucces() throws IOException {
        result=new ResultOfCommand<String>("Succeeded","Build report works",true);
        knight.setKnights();
        BuildReport report=new BuildReport(knight,equipLists,weaponLists);
        assertEquals(result.Result(),report.execute().Result());
    }
    @Test
    public void testReportsuccesequip() throws IOException {
        result=new ResultOfCommand<String>("Succeeded","Build report works",true);
        knight.setKnights();
        equipLists.add(0,new EquipList());
        equipLists.get(0).arrayOfAll();
        BuildReport report=new BuildReport(knight,equipLists,weaponLists);
        assertEquals(result.Result(),report.execute().Result());
    }
    @Test
    public void testReportsuccesequipandweapon() throws IOException {
        result=new ResultOfCommand<String>("Succeeded","Build report works",true);
        knight.setKnights();
        equipLists.add(0,new EquipList());
        equipLists.get(0).arrayOfAll();
        weaponLists.add(0,new WeaponList());
        weaponLists.get(0).setAllweapon();
        BuildReport report=new BuildReport(knight,equipLists,weaponLists);
        assertEquals(result.Result(),report.execute().Result());
    }
}
