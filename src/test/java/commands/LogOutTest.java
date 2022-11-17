package commands;

import org.junit.Assert;
import org.junit.Test;

public class LogOutTest {
    @Test
    public void LogOutSucces(){
        ResultOfCommand<String> result = new ResultOfCommand<String>("Succeeded","Log out works",true);
        LogOut logOut=new LogOut();
        Assert.assertEquals(result.Result(),logOut.execute().Result());
    }
}
