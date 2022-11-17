package main;
import Database.Connect;
import Database.Insert;
import Database.ReadData;
import commands.Menu;
import data.Email;
import data.EquipList;
import equipment.Equipment;

public class Main {
    public static void main(String[] args) throws Exception {
//        Connect connect=new Connect();
//        connect.connection();
//        Insert insert=new Insert();
//        insert.insertLogIn("3","3","3");
//        ReadData readData=new ReadData();
//        readData.ReadLogins();
        //Equipment equipment=new Equipment();
        Menu account = new Menu();
        account.menu();
    }
}