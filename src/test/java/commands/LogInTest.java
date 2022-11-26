package commands;

import data.Login;
import data.Loginlist;
import database.ReadData;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class LogInTest {
   private Loginlist users=new Loginlist();
   private  ResultOfCommand<String> result;
   private ReadData readData=new ReadData();
   private List<Login> user=new ArrayList<>();
   @Test
   public void LoginFail() throws IOException {
       readData.readLogins(users);
       result = new ResultOfCommand<String>("Critical error","No login in base",false);
       String simulatedUserInput = "0" +  System.getProperty("line.separator")
               +"1" +  System.getProperty("line.separator")
               +"2" +  System.getProperty("line.separator");
       System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));
       LogIn logIn=new LogIn(user,users);
       assertEquals(result.Result(),logIn.execute().Result());
   }
   @Test
    public void LoginSucces() throws IOException {
        readData.readLogins(users);
        result = new ResultOfCommand<String>("Succeeded","Login works",true);
        String simulatedUserInput = "1" +  System.getProperty("line.separator")
                +"1" +  System.getProperty("line.separator")
                +"1" +  System.getProperty("line.separator");
        System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));
        LogIn logIn=new LogIn(user,users);
        assertEquals(result.Result(),logIn.execute().Result());
    }

}
