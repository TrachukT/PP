package Database;

import data.EquipList;
import data.KnightInfo;
import data.Loginlist;
import equipment.Equipment;
import knight.Knight;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class ReadData {
    Connection connection;
    public ReadData(){
        Connect conn = new Connect();
        this.connection=conn.connection();
    }
    public void readLogins(Loginlist loginlist){
        Statement statement;
        ResultSet resultSet;
        try {
            String query =String.format("select * from %s","logins");
            statement=this.connection.createStatement();
            resultSet=statement.executeQuery(query);
            while (resultSet.next()){
                String email =resultSet.getString("email");
                String name=resultSet.getString("name");
                String password=resultSet.getString("password");
                loginlist.insertLogin(name,password,email);
//                System.out.print(resultSet.getString("loginid")+"). ");
//                System.out.print(resultSet.getString("email")+" ");
//                System.out.print(resultSet.getString("name")+" ");
//                System.out.println(resultSet.getString("password")+" ");

            }
        }catch (Exception e){
            System.out.println("Read failed"+ e);
        }
    }
    public void readEquip(EquipList equipList){
        Statement statement;
        ResultSet resultSet;
        try {
            String query =String.format("select * from %s","equipment");
            statement=this.connection.createStatement();
            resultSet=statement.executeQuery(query);
            int count=0;
            while (resultSet.next()){
                String name =resultSet.getString("name");
                String material =resultSet.getString("material");
                double cost=resultSet.getDouble("cost");
                double weight= resultSet.getDouble("weight");
                double strength= resultSet.getDouble("strength");
                String typeofarmor =resultSet.getString("typeofarmor");
                equipList.insertEquipment(new Equipment(name,material,cost,weight,strength,typeofarmor));
            }
        }catch (Exception e){
            System.out.println("Read failed"+ e);
        }
    }
    public void readKnights(KnightInfo knights){
        Statement statement;
        ResultSet resultSet;
        Scanner scanner=new Scanner(System.in);
        try {
            String query =String.format("select * from %s","knights");
            statement=this.connection.createStatement();
            resultSet=statement.executeQuery(query);
            int count=0;
            while (resultSet.next()){
                String name =resultSet.getString("name");
                int age =resultSet.getInt("age");
                int century =resultSet.getInt("century");
                String nationality =resultSet.getString("nationality");
                double amountOfMoney= resultSet.getDouble("amountofmoney");
                knights.insertKnight(new Knight(name,age,century,nationality,amountOfMoney));
            }
        }catch (Exception e){
            System.out.println("Read failed"+ e);
        }
    }
}
