package main;

import commands.Menu;
import data.WeaponList;
import database.ReadData;

public class Main {
    public static void main(String[] args) throws Exception {
        Menu account = new Menu();
        account.menu();
    }
}