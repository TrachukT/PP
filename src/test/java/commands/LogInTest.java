package commands;

import data.Loginlist;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import static org.junit.Assert.assertEquals;

public class LogInTest {
   private Loginlist users=new Loginlist();
   private  ResultOfCommand<String> result;
   @Test
   public void LoginFail() throws IOException {
       users.loginList();
       result = new ResultOfCommand<String>("Critical error","No login in base",false);
       String simulatedUserInput = "0" +  System.getProperty("line.separator")
               +"1" +  System.getProperty("line.separator")
               +"2" +  System.getProperty("line.separator");
       System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));
       LogIn logIn=new LogIn(users);
       assertEquals(result.Result(),logIn.execute().Result());
   }
   @Test
    public void LoginSucces() throws IOException {
        users.loginList();
        result = new ResultOfCommand<String>("Succeeded","Login works",true);
        String simulatedUserInput = "1" +  System.getProperty("line.separator")
                +"1" +  System.getProperty("line.separator")
                +"1" +  System.getProperty("line.separator");
        System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));
        LogIn logIn=new LogIn(users);
        assertEquals(result.Result(),logIn.execute().Result());
    }

}
