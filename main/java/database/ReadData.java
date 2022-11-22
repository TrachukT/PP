package database;

import data.*;
import equipment.Equipment;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import knight.Knight;
import weapon.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
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
            String query =String.format("select * from %s ORDER BY loginid ASC ","logins");
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
    public ObservableList<Equipment> readEquipForTable(){
        Statement statement;
        ResultSet resultSet;
        ObservableList<Equipment> list = FXCollections.observableArrayList();;
        try {
            String query =String.format("select * from %s ORDER BY equipmentid ASC","equipment");
            statement=this.connection.createStatement();
            resultSet=statement.executeQuery(query);
            while (resultSet.next()){
                String name =resultSet.getString("name");
                String material =resultSet.getString("material");
                double cost=resultSet.getDouble("cost");
                double weight= resultSet.getDouble("weight");
                double strength= resultSet.getDouble("strength");
                String typeofarmor =resultSet.getString("typeofarmor");
                list.add(new Equipment(name,material,cost,weight,strength,typeofarmor));
            }
        }catch (Exception e){
            System.out.println("Read failed"+ e);
        }
        return list;
    }
    public void readEquip(EquipList equipList){
        Statement statement;
        ResultSet resultSet;
        try {
            String query =String.format("select * from %s ORDER BY equipmentid ASC","equipment");
            statement=this.connection.createStatement();
            resultSet=statement.executeQuery(query);
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
            String query =String.format("select * from %s ORDER BY knightid ASC","knights");
            statement=this.connection.createStatement();
            resultSet=statement.executeQuery(query);
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
    public void readWeapon(WeaponList weaponList) {
        Statement statement;
        ResultSet resultSet;
        String name;
        String type;
        double weight;
        double cost;
        double damage;
        try {
            String query = String.format("select * from %s", "bow");
            statement = this.connection.createStatement();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                name = resultSet.getString("name");
                type = resultSet.getString("type");
                weight = resultSet.getDouble("weight");
                cost = resultSet.getDouble("cost");
                damage = resultSet.getDouble("damage");
                int amofarrows = resultSet.getInt("amountofarows");
                String typeofbowstring = resultSet.getString("typeofbowstring");
                weaponList.insertWeaponFromDB(new Bow(name, type, weight, cost, damage, amofarrows, typeofbowstring));
            }
            query = String.format("select * from %s", "axe");
            statement = this.connection.createStatement();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                name = resultSet.getString("name");
                type = resultSet.getString("type");
                weight = resultSet.getDouble("weight");
                cost = resultSet.getDouble("cost");
                damage = resultSet.getDouble("damage");
                String bladeshape = resultSet.getString("bladeshape");
                weaponList.insertWeaponFromDB(new Axe(name, type, weight, cost, damage, bladeshape));
            }
            query = String.format("select * from %s", "knife");
            statement = this.connection.createStatement();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                name = resultSet.getString("name");
                type = resultSet.getString("type");
                weight = resultSet.getDouble("weight");
                cost = resultSet.getDouble("cost");
                damage = resultSet.getDouble("damage");
                String typeofknife = resultSet.getString("typeofknife");
                weaponList.insertWeaponFromDB(new Knife(name, type, weight, cost, damage, typeofknife));
            }
            query = String.format("select * from %s", "sword");
            statement = this.connection.createStatement();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                name = resultSet.getString("name");
                type = resultSet.getString("type");
                weight = resultSet.getDouble("weight");
                cost = resultSet.getDouble("cost");
                damage = resultSet.getDouble("damage");
                String typeofblade = resultSet.getString("typeofblade");
                weaponList.insertWeaponFromDB(new Sword(name, type, weight, cost, damage, typeofblade));
            }
            query = String.format("select * from %s", "lance");
            statement = this.connection.createStatement();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                name = resultSet.getString("name");
                type = resultSet.getString("type");
                weight = resultSet.getDouble("weight");
                cost = resultSet.getDouble("cost");
                damage = resultSet.getDouble("damage");
                int lengthoflance = resultSet.getInt("lengthoflance");
                weaponList.insertWeaponFromDB(new Lance(name, type, weight, cost, damage, lengthoflance));
            }
        } catch (Exception e) {
            System.out.println("Read failed" + e);
        }
    }
    public void readKnightsEquipment(Login user, Loginlist loginlist,KnightInfo knightlist,EquipList equipList,List<EquipList> knightsequipment){
        String query;
        Statement statement;
        ResultSet resultSet;
        double allcost=0.0;
        try {
        query = String.format("select * from %s where userid = '%d'", "knightsequip",userid(loginlist,user));
        statement = this.connection.createStatement();
        resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            allcost=0.0;
            int knightid = resultSet.getInt("knightid")-1;
            int equipmentid = resultSet.getInt("equipmentid")-1;
            checksize(knightsequipment,knightid);
            knightsequipment.get(knightid).addKnightEquip(equipList.getelem(equipmentid),knightsequipment.get(knightid).getsize());
            allcost+= equipList.getelem(equipmentid).getCost();
            knightlist.cutMoney(knightid,allcost);
        }
        } catch (Exception e) {
        System.out.println("Read failed" + e);
        }
    }
    public void readKnightsWeapon(Login user, Loginlist loginlist,KnightInfo knightlist,WeaponList weaponList,List<WeaponList> knightsweapon){
        String query;
        Statement statement;
        ResultSet resultSet;
        //double allcost=0.0;
        try {
            query = String.format("select * from %s where userid = '%d'", "knightsweapon",userid(loginlist,user));
            statement = this.connection.createStatement();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int knightid = resultSet.getInt("knightid")-1;
                weaponid(knightsweapon,weaponList,resultSet.getString("bow"),knightlist,knightid);
                weaponid(knightsweapon,weaponList,resultSet.getString("axe"),knightlist,knightid);
                weaponid(knightsweapon,weaponList,resultSet.getString("knife"),knightlist,knightid);
                weaponid(knightsweapon,weaponList,resultSet.getString("sword"),knightlist,knightid);
                weaponid(knightsweapon,weaponList,resultSet.getString("lance"),knightlist,knightid);
            }
        } catch (Exception e) {
            System.out.println("Read failed" + e);
        }
    }

    public void weaponid(List<WeaponList> knightsweapon,WeaponList weaponList,String name,KnightInfo knightlist,int knightid){
        if(name.equalsIgnoreCase("NULL")){
            return;
        }
        double allcost=0.0;
        for(int count=0;count<weaponList.getsize();count++){
            if(weaponList.getelem(count).getName().equals(name)){
                checksizeweapon(knightsweapon,knightid);
                knightsweapon.get(knightid).addKnightWeapon(weaponList.getelem(count),knightsweapon.get(knightid).getsize());
                allcost+= weaponList.getelem(count).getCost();
                knightlist.cutMoney(knightid,allcost);
            }
        }
    }
    public void checksize(List<EquipList> knightsequip,int i){
        if(knightsequip.size()<=i){
            for(int k=knightsequip.size();k<=i;k++){
                knightsequip.add(k,new EquipList());
            }
        }
    }
    public void checksizeweapon(List<WeaponList> knightsweapon,int i){
        if(knightsweapon.size()<=i){
            for(int k=knightsweapon.size();k<=i;k++){
                knightsweapon.add(k,new WeaponList());
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
}
