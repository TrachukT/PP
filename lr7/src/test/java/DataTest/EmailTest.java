package DataTest;

import data.Email;
import org.junit.Test;

public class EmailTest {
    @Test
    public void EmailTest(){
        Email email=new Email();
        email.send();
    }
}
