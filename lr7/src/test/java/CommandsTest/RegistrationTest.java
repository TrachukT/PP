package CommandsTest;

import commands.Registration;
import commands.ResultOfCommand;
import commands.SelectWeapon;
import data.Loginlist;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class RegistrationTest {
    private Loginlist user=new Loginlist();
    private ResultOfCommand<String> result;
    @Test
    public void registrationFails() throws IOException {
        user.loginList();
        result = new ResultOfCommand<String>("Failed","User already exist",false);
        String simulatedUserInput = "1" +  System.getProperty("line.separator")
                +"1" +  System.getProperty("line.separator")+
                "1" +  System.getProperty("line.separator");
        System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));
        Registration registration=new Registration(user);
        Assert.assertEquals(result.Result(),registration.execute().Result());
    }
    @Test
    public void registrationSuccess() throws IOException {
        user.loginList();
        result = new ResultOfCommand<String>("Succeeded","Registration works",true);
        String simulatedUserInput = "fllkl" +  System.getProperty("line.separator")
                +"fllkl" +  System.getProperty("line.separator")
                +"fllkl" +  System.getProperty("line.separator");
        System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));
        Registration registration=new Registration(user);
        Assert.assertEquals(result.Result(),registration.execute().Result());
    }

}
