package commands;

import data.Loginlist;

import java.io.IOException;
import java.util.Scanner;

public class Registration implements Commands {
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
        ResultOfCommand<String> result = new ResultOfCommand<String>("Succeeded","Registration works",true);
        return result;
    }
    public Registration(Loginlist users) {
        this.user = users;
    }
}
