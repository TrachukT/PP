package database;

import java.sql.Connection;
import java.sql.Statement;

public class Delete {
    Connection connection;
    public Delete(){
        Connect conn = new Connect();
        this.connection=conn.connection();
    }
    public void deleteKnightsEquipment(int userid){
        Statement statement;
        try {
            String query = String.format("delete from knightsequip where userid= '%s'",userid);
            statement= this.connection.createStatement();
            statement.executeUpdate(query);
            //System.out.println("Row deleteded");
        }catch (Exception e){
            System.out.println("Delete failed\n"+e);
        }
    }
    public void deleteKnightsWeapon(int userid){
        Statement statement;
        try {
            String query = String.format("delete from knightsweapon where userid= '%s'",userid);
            statement= this.connection.createStatement();
            statement.executeUpdate(query);
            //System.out.println("Row deleteded");
        }catch (Exception e){
            System.out.println("Delete failed\n"+e);
        }
    }
}
