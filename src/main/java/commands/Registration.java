package commands;

import data.Login;
import data.Loginlist;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Registration implements Commands {
    private List<Login> chooseduser;
    private Loginlist user;
    @Override
    public ResultOfCommand<String> execute() throws IOException {
        Scanner scan=new Scanner(System.in);
        user.printlist();
        System.out.println("Enter your mail adress");
        String mail= scan.next();
        if(!user.checkmail(mail)){
            System.out.println("There is already user with this email.\nPlease login or chose another mail");
            ResultOfCommand<String> result = new ResultOfCommand<String>("Failed","User already exist",false);
            return result;
        }
        System.out.println("Enter your name");
        String name= scan.next();
        System.out.println("Enter your password");
        String password= scan.next();
        System.out.println("You are registered!Please login into your created account");
        user.addLogin(name,password,mail);
        chooseduser.add(0,new Login(name,password,mail));
        ResultOfCommand<String> result = new ResultOfCommand<String>("Succeeded","Registration works",true);
        return result;
    }
    public Registration(List<Login> chooseduser, Loginlist users) {
        this.chooseduser=chooseduser;
        this.user = users;
    }
}
