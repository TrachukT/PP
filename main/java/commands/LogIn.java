package commands;

import data.Login;
import data.Loginlist;

import java.util.List;
import java.util.Scanner;

public class LogIn implements Commands {
    private List<Login> chooseduser;
    private Loginlist userlist;
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
        this.chooseduser.add(0,user);
        System.out.println(this.chooseduser.toString());
        ResultOfCommand<String> result = new ResultOfCommand<String>("Succeeded","Login works",true);
        return result;
    }
    public LogIn(List<Login> chooseduser,Loginlist users) {
        this.chooseduser=chooseduser;
        this.userlist = users;
    }
}
