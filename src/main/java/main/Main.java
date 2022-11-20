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
        String k="1";
        int kint=Integer.parseInt(k);
        Menu account = new Menu();
        account.menu();
    }
}