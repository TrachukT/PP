package data;

import equipment.Equipment;
import knight.Knight;
import weapon.*;

import java.util.*;

public class WeaponList {
    private ArrayList<Weapon> allweapon=new ArrayList<>();
    public void setAllweapon(){
        this.allweapon.add(0,new Bow("Wood Bow","bow",14,45.78,5.6,10,"Flemish twist"));
        this.allweapon.add(1,new Bow("Flat bow","bow",14,25.76,6.02,6,"endless loop"));
        this.allweapon.add(2,new Axe("Hatchet","Axe",12,23.05,7.9,"flared"));
        this.allweapon.add(3,new Axe("Grub Axe","Axe",8,15.54,8.4,"sharp"));
        this.allweapon.add(4,new Knife("arm-34","knife",4,23,3.7,"utility knife"));
        this.allweapon.add(5,new Knife("mr-202","knife",7,15,4.2,"Bowie Knife"));
        this.allweapon.add(6,new Knife("yh-65","knife",5,45,5.1,"dagger"));
        this.allweapon.add(7,new Sword("Longsword","Sword",23,67.12,6.8,"cutglass"));
        this.allweapon.add(8,new Sword("Rapier","Sword",45,45.56,7.2,"glaymore"));
        this.allweapon.add(9,new Sword("Small-sword","Sword",4,67,6.9,"shortsword"));
        this.allweapon.add(10,new Lance("fgfg","Lance",4,37.09,6.6,12));
        this.allweapon.add(11,new Lance("fgfg","Lance",4,32,7.3,20));
    }
    public void updateWeapon(Scanner scanner,int i){
        System.out.print("Enter the new cost of the weapon: ");
        double cost=scanner.nextDouble();
        this.allweapon.get(i).setCost(cost);
    }
    public void addKnightWeapon(Weapon element, int index){
        this.allweapon.add(index,element);
    }
    public void removeelem(int i){
        this.allweapon.remove(i);
    }
    public void addWeapon(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Which type of weapon you want to add:" +
                "\nAxe - 1\nBow - 2\nKnife - 3\nLance - 4\nSword - 5");
        int choice=scanner.nextInt();
        switch (choice) {
            case 1:
                this.allweapon.add(this.allweapon.size(), new Axe());
                break;
            case 2:
                this.allweapon.add(this.allweapon.size(), new Bow());
                break;
            case 3:
                this.allweapon.add(this.allweapon.size(), new Knife());
                break;
            case 4:
                this.allweapon.add(this.allweapon.size(), new Lance());
                break;
            case 5:
                this.allweapon.add(this.allweapon.size(), new Sword());
                break;
            default:
                this.allweapon.add(this.allweapon.size(), new Weapon());
                break;
        }
    }
    public Weapon getelem(int i){
        return this.allweapon.get(i);
    }
    public void printList(){
        for(int i=0;i<this.allweapon.size();i++){
            System.out.println(this.allweapon.get(i).toString(i));
        }
    }
    public int getsize(){
        return this.allweapon.size();
    }
    //    public void removeWeapon(int i){
//        this.allweapon.remove(i);
//    }
    public void sortWeapon(){
        this.allweapon.sort(Comparator.comparingDouble(Weapon::getWeight));
        printList();
    }
}
