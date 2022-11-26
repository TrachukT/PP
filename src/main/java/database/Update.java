package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Locale;

public class Update {
    Connection connection;
    public Update(){
        Connect conn = new Connect();
        this.connection=conn.connection();
    }
    public void updateEquipment(int index,double cost){
        Statement statement;
        ResultSet resultSet;
        try {
            String query =String.format(Locale.US,"Update %s set cost = '%f' where equipmentid = '%d'","equipment",cost,index+1);
            statement=this.connection.createStatement();
            statement.executeUpdate(query);
        }catch (Exception e){
            System.out.println("Read failed"+ e);
        }
    }
    public void updateWeapon(String name,String type,double cost){
        Statement statement;
        ResultSet resultSet;
        try {
//            String id=type.toLowerCase()+"id";
//            System.out.println(id);
            String query =String.format(Locale.US,"Update %s set cost = '%f' where name= '%s'",type.toLowerCase(),cost,name);
            statement=this.connection.createStatement();
            statement.executeUpdate(query);
        }catch (Exception e){
            System.out.println("Read failed"+ e);
        }
    }
    public void cutKnightMoney(int index, double cost){
        Statement statement;
        ResultSet resultSet;
        try {
            String query =String.format(Locale.US,"Update %s set amountofmoney = '%f' where knightid = '%d'","knights",cost,index+1);
            statement=this.connection.createStatement();
            statement.executeUpdate(query);
        }catch (Exception e){
            System.out.println("Read failed"+ e);
        }
    }
}
