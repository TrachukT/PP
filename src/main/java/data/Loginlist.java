package data;

import database.Insert;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Loginlist {
    private ArrayList<Login> logins=new ArrayList<>();
//    public void loginList() throws IOException {
//        FileReader fileReader = new FileReader("C:\\Users\\38098\\lr7\\src\\main\\resources\\Logins.txt");
//        Scanner scanner = new Scanner(fileReader);
//        for (int i = 0;scanner.hasNext();i++)
//        {
//            String email = scanner.nextLine();
//            String name = scanner.nextLine();
//            String password = scanner.nextLine();
//            logins.add(i,new Login(name,password,email));
//        }
//        fileReader.close();
//    }
    public int getsize(){
        return this.logins.size();
    }
    public void insertLogin(String name,String password,String mail) {//зчитування з бд
        logins.add(logins.size(),new Login(name,password,mail));
    }
    public void addLogin(String name,String password,String mail) {//запис при реєстрації
        logins.add(logins.size(),new Login(name,password,mail));
        Insert insert=new Insert();
        insert.insertLogIn(mail,name, password);
    }
    public void enterall() throws IOException {
        FileWriter writer = new FileWriter("C:\\Users\\38098\\lr7\\src\\main\\resources\\Logins.txt");
        for(int k=0;k<logins.size();k++) {
            writer.write(logins.get(k).getMail() + "\n" + logins.get(k).getName() + "\n" + logins.get(k).getPassword() + "\n");
        }
        writer.close();
    }
    public boolean checkmail(String mail){
        for(int i=0;i<logins.size();i++){
            if(mail.equals(logins.get(i).getMail()))
                return false;
        }
        return true;
    }
    public boolean checkUsername(String username,String mail){
        for(int i=0;i<logins.size();i++){
            if(username.equalsIgnoreCase(logins.get(i).getName()) && !(mail.equalsIgnoreCase(logins.get(i).getMail())))
                return false;
        }
        return true;
    }
    public boolean checkpassword(Login user){
        for(int i=0;i<logins.size();i++){
            if(user.getMail().equalsIgnoreCase(logins.get(i).getMail()) && user.getName().equalsIgnoreCase(logins.get(i).getName()) && !(user.getPassword().equalsIgnoreCase(logins.get(i).getPassword()))){
                //System.out.println("Log in succeeded");
                return true;
            }
        }
        //System.out.println("Log in failed");
        return false;
    }
    public Login getelem(int i){
        return this.logins.get(i);
    }
    public boolean finduser(Login user){
        for(int i=0;i<logins.size();i++){
            if(user.getMail().equalsIgnoreCase(logins.get(i).getMail()) && user.getName().equalsIgnoreCase(logins.get(i).getName()) && user.getPassword().equalsIgnoreCase(logins.get(i).getPassword())){
                //System.out.println("Log in succeeded");
                return true;
            }
        }
        //System.out.println("Log in failed");
        return false;
    }
    public  void printlist(){
        for(int i=0;i<logins.size();i++){
            System.out.println(logins.get(i).toString());
        }
    }

}
