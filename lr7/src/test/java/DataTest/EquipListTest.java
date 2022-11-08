package DataTest;

import data.EquipList;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class EquipListTest {
    @Mock
    private static EquipList list= new EquipList();
    public boolean isSorted(EquipList list){
        for(int i=0;i<list.getsize()-1;i++){
            if(list.getelem(i).getWeight()>list.getelem(i+1).getWeight()){
                return false;
            }
        }
        return true;
    }
    @BeforeClass
    public static void enter(){
        list.ArrayOfAll();
    }
    @Test
    @DisplayName("Sorting not Working")
    public void  test(){
        list.sortEquip();
        assertTrue(isSorted(list));
    }
    @Test
    @DisplayName("Getting size not working")
    public void testsize(){
        assertEquals(list.getsize(),list.getAllequipment().size());
    }
//
//    @Test
//    @DisplayName()
}
