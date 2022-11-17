package Database;

import equipment.Equipment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

public class Insert {
    Connection connection;
    public Insert(){
        Connect conn = new Connect();
        this.connection=conn.connection();
    }
    public void insertLogIn(String email,String name,String password){
        Statement statement;
        try {
            String query = String.format("insert into logins(email,name,password) values('%s','%s','%s');",email,name,password);
            statement= this.connection.createStatement();
            statement.executeUpdate(query);
            System.out.println("Row inserted");
        }catch (Exception e){
            System.out.println("Insert failed\n"+e);
        }
    }
    public  void insertEquipment(String name,String material,double cost,double weight, double strength,String typeofarmour){
        Statement statement;
        try {
            String query = String.format(Locale.US,"insert into equipment(name,material,cost,weight,strength,typeofarmor) values('%s','%s','%f','%f','%f','%s');",name,material, cost, weight,strength,typeofarmour);
            statement= this.connection.createStatement();
            statement.executeUpdate(query);
            System.out.println("Row inserted");
        }catch (Exception e){
            System.out.println("Insert failed\n"+e);
        }
    }
}
