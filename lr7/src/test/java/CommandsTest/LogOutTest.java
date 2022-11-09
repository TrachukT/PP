package CommandsTest;

import commands.LogOut;
import commands.ResultOfCommand;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;
public class LogOutTest {
    @Test
    public void LogOutSucces(){
        ResultOfCommand<String> result = new ResultOfCommand<String>("Succeeded","Log out works",true);
        LogOut logOut=new LogOut();
        Assert.assertEquals(result.Result(),logOut.execute().Result());
    }
}
