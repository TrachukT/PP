package data;

import database.Insert;
import database.Update;
import equipment.Equipment;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;

import java.util.ArrayList;
import java.util.Scanner;

public class EquipList {

    private ArrayList<Equipment> allequipment = new ArrayList<>();
    public void arrayOfAll() {
        // Scanner scan = new Scanner(System.in);
        //System.out.print("Enter amount of knights you want to add:");
        //int am=scan.nextInt();
        //for(int i=1;i<=am;i++){
        //    allequipment.add();
        //}
        this.allequipment.add(0, new Equipment("Steel Helmet", "steel", 116.45, 7.8, 6, "Helmet"));
        this.allequipment.add(1, new Equipment("Steel armor", "steel", 35.00, 34.8, 8, "Chest"));
        this.allequipment.add(2, new Equipment("Steel Boots", "steel", 24.56, 21.4, 3, "Boots"));
        this.allequipment.add(3, new Equipment("Wood Shield", "wood", 16.00, 12.8, 6, "Shield"));
        this.allequipment.add(4, new Equipment("Leather Boots", "leather", 16.00, 12.8, 4, "Boots"));
        this.allequipment.add(5, new Equipment("Leather helmet", "wood", 16.00, 12.8, 6, "Helmet"));
        this.allequipment.add(6, new Equipment("Wolfram Shield", "wolfram", 16.00, 12.8, 6, "Shield"));
        this.allequipment.add(7, new Equipment("Leather Boots", "leather", 16.00, 12.8, 6, "Boots"));
//зробити сортуувалку по типах
    }
    public ArrayList<Equipment> getAllequipment() {
        return allequipment;
    }
    public void updateEquipment(Scanner scanner, int i){
        System.out.print("Enter the new cost of the equipment: ");
        double cost=scanner.nextDouble();
        this.allequipment.get(i).setCost(cost);
        Update update=new Update();
        update.updateEquipment(i,cost);
    }
    public void updateEquipmentInterface(int i,double cost){
        this.allequipment.get(i).setCost(cost);
        Update update=new Update();
        update.updateEquipment(i,cost);
    }
    public void enterAllEquipment() throws IOException {
        FileWriter writer = new FileWriter("C:\\Users\\38098\\lr7\\src\\main\\resources\\Equipment.txt");
        for(int k=0;k<allequipment.size();k++) {
            writer.write(allequipment.get(k).getName() + "\n" + allequipment.get(k).getMaterial() + "\n" + allequipment.get(k).getCost() + "\n"+
                    allequipment.get(k).getWeight() + "\n"+allequipment.get(k).getStrength() + "\n"+allequipment.get(k).getTypeofarmour() + "\n");
        }
        writer.close();
    }
//    public void equipmentList() throws IOException {
//        FileReader fileReader = new FileReader("C:\\Users\\38098\\lr7\\src\\main\\resources\\Equipment.txt");
//        Scanner scanner = new Scanner(fileReader);
//        for (int i = 0;scanner.hasNext();i++)
//        {
//            String name = scanner.nextLine();
//            String material=scanner.nextLine();
//            double cost = scanner.nextDouble();
//            double weight=scanner.nextDouble();
//            double strength = scanner.nextDouble();
//            String typeofarmor = scanner.nextLine();
//            allequipment.add(i,new Equipment(name,material,cost,weight,strength,typeofarmor));
//        }
//        fileReader.close();
//    }
    public boolean checkForCopy(String name,String material,double cost,double weight,double strength,String type){
        for(int i=0;i<this.allequipment.size();i++) {
            if (name.equalsIgnoreCase(this.allequipment.get(i).getName()) && material.equalsIgnoreCase(this.allequipment.get(i).getMaterial()) && cost==this.allequipment.get(i).getCost()
            && weight==this.allequipment.get(i).getWeight() && strength==this.allequipment.get(i).getStrength() && type.equalsIgnoreCase(this.allequipment.get(i).getTypeofarmour())) {
                //System.out.println("Log in succeeded");
                return true;
            }
        }
        return false;
    }
    public boolean checkNameDublication(String name) {
        for (int i = 0; i < this.allequipment.size(); i++) {
            if (name.equalsIgnoreCase(this.allequipment.get(i).getName())) {
                //System.out.println("Log in succeeded");
                return true;
            }
        }
        return false;
    }
    public void addKnightEquip(Equipment element, int index){
        this.allequipment.add(index,element);
    }
    public  void addKnightEquipInterface(Equipment element){
        this.allequipment.add(element);
    }
    public void insertEquipment(Equipment equipment){
        this.allequipment.add(this.allequipment.size(), equipment);
    }//запис з бд
    public void addEquipFromInterface(String name,String material,double cost,double weight,double strength,String type){
        this.allequipment.add(this.allequipment.size(), new Equipment(name,material,cost,weight,strength,type));
        Insert insert = new Insert();
        insert.insertEquipment(name,material,cost,weight,strength,type);
    }
    public void  addNewEquipment(){
        this.allequipment.add(this.allequipment.size(), new Equipment());
    }//створення нового і занесення в бд( в конструкторі еквіпа)
    public void remove(int i){
        this.allequipment.remove(i);
    }
    public Equipment getelem(int i){
        return this.allequipment.get(i);
    }
    public int getsize(){
        return allequipment.size();
    }
    public void sortEquip(){
        allequipment.sort(Comparator.comparingDouble(Equipment::getWeight));
    }
    public void removeelem(int i){
        this.allequipment.remove(i);
    }
    public void printList(){
        //sortEquip();
        for(int i=0;i<allequipment.size();i++)
            System.out.println(allequipment.get(i).toString(i));
    }
}