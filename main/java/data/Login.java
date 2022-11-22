package data;

import java.util.Scanner;

public class Login {
    private String name;
    private String password;

    private String mail;
    public Login(String name, String password, String mail){
        this.name=name;
        this.password=password;
        this.mail=mail;
    }
    public Login(){
        Scanner scan=new Scanner(System.in);
        System.out.print("Enter the name: ");
        this.name= scan.next();
        System.out.print("Enter the password: ");
        this.password= scan.next();
        System.out.print("Enter the email: ");
        this.mail= scan.next();
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Login{" +" mail = " + mail +
                ", name= " + name  +
                ", password = " + password +
                '}';
    }
}
