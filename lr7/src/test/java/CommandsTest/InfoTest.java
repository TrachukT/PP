package CommandsTest;

import commands.Info;
import commands.ResultOfCommand;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;

public class InfoTest {
    @Mock
    private static ResultOfCommand<String> result;
    @BeforeClass
    public static void setResult(){
        result=new ResultOfCommand<>("Succeeded","Action possible",true);
    }
    @Test
    @DisplayName("Info not working")
    public void testInfo() throws Exception {
        Info info=new Info();
        ResultOfCommand<String> res=info.execute();
        assertEquals(result.getResult(),res.getResult());
    }
}
