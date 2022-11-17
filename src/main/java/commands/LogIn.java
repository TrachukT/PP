package commands;

import data.Login;
import data.Loginlist;

import java.util.Scanner;

public class LogIn implements Commands {
    Loginlist userlist;
    @Override
    public ResultOfCommand<String> execute()  {
        userlist.printlist();
        Scanner scan=new Scanner(System.in);
        System.out.print("Enter your mail adress - ");
        String mail= scan.next();
        System.out.print("Enter your name - ");
        String name= scan.next();
        System.out.print("Enter your password - ");
        String password= scan.next();
        Login user=new Login(name,password,mail);
        if(!userlist.finduser(user)){
            ResultOfCommand<String> result = new ResultOfCommand<String>("Critical error","No login in base",false);
            return result;
        }
        ResultOfCommand<String> result = new ResultOfCommand<String>("Succeeded","Login works",true);
        return result;
    }
    public LogIn(Loginlist users) {
        this.userlist = users;
    }
}
