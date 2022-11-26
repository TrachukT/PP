package database;

import data.*;
import equipment.Equipment;

import java.sql.Connection;
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
    public void insertKnightEquipment(int userID, EquipList equipList, List<EquipList> knightsEquipment){
        Statement statement;
        int equipid;
        Delete delete=new Delete();
        delete.deleteKnightsEquipment(userID);
        for(int i=0;i< knightsEquipment.size();i++){
            for(int k=0;k<knightsEquipment.get(i).getsize();k++) {
                try {
                    String query;
                        equipid = findid(equipList, knightsEquipment.get(i).getelem(k));
                        query = String.format(Locale.US, "insert into knightsequip(userid, knightid, equipmentid)  values('%d','%d','%d');", userID, i + 1, equipid);
                        statement = this.connection.createStatement();
                        statement.executeUpdate(query);
                        System.out.println("Equipment inserted");
                } catch (Exception e) {
                    System.out.println("Equipment insert failed\n" + e);
                }
            }
        }
    }
    public void insertKnightsWeapon(int userID, WeaponList weaponList,List<WeaponList> knightsWeapon){
        Statement statement;
        //int equipid;
        Delete delete=new Delete();
        delete.deleteKnightsWeapon(userID);
        for(int i=0;i< knightsWeapon.size();i++){
            if(knightsWeapon.get(i).getsize()!=0){
                String bow=weaponname(knightsWeapon.get(i),"bow");
                String axe=weaponname(knightsWeapon.get(i),"axe");
                String knife=weaponname(knightsWeapon.get(i),"knife");
                String sword=weaponname(knightsWeapon.get(i),"sword");
                String lance=weaponname(knightsWeapon.get(i),"lance");
            //for(int k=0;k<knightsWeapon.get(i).getsize();k++) {
                try {
                    String query;
                    query = String.format(Locale.US, "insert into knightsweapon(userid, knightid, bow,axe,knife,sword,lance)  values('%d','%d','%s','%s','%s','%s','%s');", userID, i + 1,bow,axe,knife,sword,lance);
                    statement = this.connection.createStatement();
                    statement.executeUpdate(query);
                    System.out.println("Weapon inserted");
                } catch (Exception e) {
                    System.out.println("Weapon Insert failed\n" + e);
                }
            }
        }
    }
    public String weaponname(WeaponList weaponList,String type){
            for(int count=0;count<weaponList.getsize();count++){
                if(weaponList.getelem(count).getType().equalsIgnoreCase(type)){
                    return weaponList.getelem(count).getName();
                }
            }
            return "NULL";
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
        return -1;
    }


}
