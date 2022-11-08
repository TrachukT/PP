package commands;

import data.EquipList;
import data.WeaponList;

import java.util.Scanner;

public class AddEquipment implements Commands {
    private WeaponList listofweapon;
    private EquipList listofequipment;
    @Override
    public ResultOfCommand<String> execute() {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Which part of equip you want to add: 1 - equipment,2 - weapon");
        int choosed=scanner.nextInt();
        if(choosed==1){
            System.out.println("Add your new equipment");
            this.listofequipment.addEquipment();
            this.listofequipment.printList();
        }
        if(choosed==2){
            System.out.println("Add your new weapon");
            this.listofweapon.addWeapon();
            this.listofweapon.printList();
        }
        else {
            System.out.println("You enter wrong number.Try again");
            ResultOfCommand<String> result = new ResultOfCommand<String>("Failed","Wrong number",false);
            return result;
        }
        System.out.println("Adding works!");
        ResultOfCommand<String> result = new ResultOfCommand<String>("Succeeded","Adding works",true);
        return result;
    }
    public AddEquipment(EquipList list,WeaponList weaponList){

        this.listofequipment=list;
        this.listofweapon=weaponList;
    }
}
