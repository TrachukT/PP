package DataTest;
import data.KnightInfo;
import org.hamcrest.core.IsEqual;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.mockito.Mock;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class KnightInfoTest {
    @Mock
    private static KnightInfo knights=new KnightInfo();
    @BeforeClass
    public static void  enter(){
        knights.setKnights();
    }
    public boolean IsEmpt(KnightInfo knights){
        if(knights.getsize()==0)
            return false;
        return true;
    }
    @Test
    @DisplayName("Set not working")
    public void testSetKnights(){
        assertTrue(IsEmpt(knights));
    }
    public boolean Isequals(double money,double leftmoney){
        if(money!=leftmoney)
            return false;
        return true;
    }
    @Test
    @DisplayName("Money changing wrong")
    public void testCutMoney(){
        double m= knights.getknight(1).getAmountOfMoney();
        knights.cutMoney(1,23.45);
        assertTrue(Isequals(m,(knights.getknight(1).getAmountOfMoney()+23.45)));
    }

    @Test
    @DisplayName("Adding not works")
    public void testAddMoney(){
        double m= knights.getknight(1).getAmountOfMoney();
        knights.addMoney(1,40.05);
        assertTrue(Isequals(m+40.05,knights.getknight(1).getAmountOfMoney()));
    }
    @Test
    public void addKnightTest(){
        String simulatedUserInput = "fllkl" +  System.getProperty("line.separator")
                +"18" +  System.getProperty("line.separator")
                +"15" +  System.getProperty("line.separator")
                +"judas" +  System.getProperty("line.separator")
                +"1900" +  System.getProperty("line.separator");
        System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));
        Scanner scanner=new Scanner(System.in);
        knights.addKnight(scanner);
    }


}
