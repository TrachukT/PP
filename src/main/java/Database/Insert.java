package Database;

import data.EquipList;
import data.Login;
import data.Loginlist;
import equipment.Equipment;
import org.apache.maven.plugin.logging.Log;
import org.postgresql.util.internal.Nullness;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
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
    public  void insertKnight(String name,int age,int century,String nationality, double amountofmoney){
        Statement statement;
        try {
            String query = String.format(Locale.US,"insert into knights(name,age,century,nationality,amountofmoney) values('%s','%d','%d','%s','%f');",name,age,century,nationality,amountofmoney);
            statement= this.connection.createStatement();
            statement.executeUpdate(query);
            System.out.println("Row inserted");
        }catch (Exception e){
            System.out.println("Insert failed\n"+e);
        }
    }
    public  void insertBow(String name,String type,double weight,double cost,double damage,int amofarrows, String  typeofbowstring){
        Statement statement;
        try {
            String query = String.format(Locale.US,"insert into bow(name, type, weight, cost, damage, amountofarows, typeofbowstring) values('%s','%s','%f','%f','%f','%d','%s');",name, type, weight, cost, damage, amofarrows, typeofbowstring);
            statement= this.connection.createStatement();
            statement.executeUpdate(query);
            System.out.println("Row inserted");
        }catch (Exception e){
            System.out.println("Insert failed\n"+e);
        }
    }
    public  void insertAxe(String name,String type,double weight,double cost,double damage,String  bladeshape){
        Statement statement;
        try {
            String query = String.format(Locale.US,"insert into axe(name, type, weight, cost, damage,bladeshape)  values('%s','%s','%f','%f','%f','%s');",name, type, weight, cost, damage,bladeshape);
            statement= this.connection.createStatement();
            statement.executeUpdate(query);
            System.out.println("Row inserted");
        }catch (Exception e){
            System.out.println("Insert failed\n"+e);
        }
    }
    public  void insertKnife(String name,String type,double weight,double cost,double damage,String  typeofknife){
        Statement statement;
        try {
            String query = String.format(Locale.US,"insert into axe(name, type, weight, cost, damage,typeofknife)  values('%s','%s','%f','%f','%f','%s');",name, type, weight, cost, damage,typeofknife);
            statement= this.connection.createStatement();
            statement.executeUpdate(query);
            System.out.println("Row inserted");
        }catch (Exception e){
            System.out.println("Insert failed\n"+e);
        }
    }
    public  void insertSword(String name,String type,double weight,double cost,double damage,String  typeofblade){
        Statement statement;
        try {
            String query = String.format(Locale.US,"insert into axe(name, type, weight, cost, damage,bladeshape)  values('%s','%s','%f','%f','%f','%s');",name, type, weight, cost, damage,typeofblade);
            statement= this.connection.createStatement();
            statement.executeUpdate(query);
            System.out.println("Row inserted");
        }catch (Exception e){
            System.out.println("Insert failed\n"+e);
        }
    }
    public  void insertLance(String name,String type,double weight,double cost,double damage,int  lengthoflnace){
        Statement statement;
        try {
            String query = String.format(Locale.US,"insert into axe(name, type, weight, cost, damage,lengthoflance)  values('%s','%s','%f','%f','%f','%d');",name, type, weight, cost, damage,lengthoflnace);
            statement= this.connection.createStatement();
            statement.executeUpdate(query);
            System.out.println("Row inserted");
        }catch (Exception e){
            System.out.println("Insert failed\n"+e);
        }
    }
    public void insertKnightResults(Loginlist loginlist, Login user, EquipList equipList, List<EquipList> knightsEquipment){
        Statement statement;
        int equipid;
        Delete delete=new Delete();
        delete.deleteKnightsEquipment(userid(loginlist, user));
        for(int i=0;i< knightsEquipment.size();i++){
            for(int k=0;k<knightsEquipment.get(i).getsize();k++) {
                try {
                    String query;
                        equipid = findid(equipList, knightsEquipment.get(i).getelem(k));
                        query = String.format(Locale.US, "insert into knightsequip(userid, knightid, equipmentid)  values('%d','%d','%s');", userid(loginlist, user), i + 1, equipid);
                        statement = this.connection.createStatement();
                        statement.executeUpdate(query);
                        System.out.println("Row inserted");
                } catch (Exception e) {
                    System.out.println("Insert failed\n" + e);
                }
            }
        }
    }
    public int userid(Loginlist loginlist, Login user){
        int count=0;
        for(;count<loginlist.getsize();count++){
            if(loginlist.getelem(count).getName().equals(user.getName())&& loginlist.getelem(count).getMail().equals(user.getMail())){
                return (count+1);
            }
        }
        return 0;
    }
    public int findid(EquipList equipList,Equipment equipment){
        int count=0;
        for(;count<equipList.getsize();count++){
            if(equipList.getelem(count).getName().equals(equipment.getName())){
                return (count+1);
            }
        }
        return 0;
    }


}
