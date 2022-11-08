package commands;

import data.EquipList;
import data.KnightInfo;
import data.WeaponList;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeleteEquipment implements Commands {
    KnightInfo knightList;
    List<EquipList> equipmentlist;
    List<WeaponList> weaponList;
    @Override
    public ResultOfCommand<String> execute() {
        Scanner scanner=new Scanner(System.in);
        if(equipmentlist.size()==0 && weaponList.size()==0){
            System.out.println("All knights has no equipment and no weapon.Firstly select equipment or weapon");
            ResultOfCommand<String> result = new ResultOfCommand<>("Failed","Nothing to delete",false);
            return result;
        }
        System.out.println("For what knight you want delete equipment:");
        knightList.printList();
        int knight = scanner.nextInt();
        System.out.println(knightList.getknight(knight).toString(knight));
        System.out.println("Which part of equip you want to delete: 1 - equipment,2 - weapon");
        int choice=scanner.nextInt();
        if(choice==1 && knight<equipmentlist.size()) {
            System.out.println("Which part of equipment you want to delete");
            equipmentlist.get(knight).printList();
            int equip = scanner.nextInt();
            if (equipmentlist.get(knight).getsize()<equip){
                System.out.println("This knight has no such type of equip");
                ResultOfCommand<String> result = new ResultOfCommand<String>("Failed", "Impossible delete", false);
                return result;
            }
            knightList.addMoney(knight,equipmentlist.get(knight).getelem(equip).getCost());
            equipmentlist.get(knight).removeelem(equip);
            System.out.println(knightList.getknight(knight).toString(knight));
            equipmentlist.get(knight).printList();
            System.out.println("Deleting works!");
            ResultOfCommand<String> result = new ResultOfCommand<String>("Succeeded", "Equipment deleted", true);
            return result;
        }
        if(choice==2 && weaponList.size()>knight){
            System.out.println("Which part of weapon you want to delete");
            weaponList.get(knight).printList();
            int weapon = scanner.nextInt();
            if (weaponList.get(knight).getsize()<weapon){
                System.out.println("This knight has no such type of equip");
                ResultOfCommand<String> result = new ResultOfCommand<>("Failed", "Unpossible delete", false);
                return result;
            }
            knightList.addMoney(knight,weaponList.get(knight).getelem(weapon).getCost());
            weaponList.get(knight).removeelem(weapon);
            System.out.println(knightList.getknight(knight).toString(knight));
            weaponList.get(knight).printList();
            System.out.println("Deleting works!");
            ResultOfCommand<String> result = new ResultOfCommand<String>("Succeeded", "Weapon deleted", true);
            return result;
        }
        else{
            System.out.println("This knight has no such type of equip");
            ResultOfCommand<String> result = new ResultOfCommand<String>("Failed", "Unpossible delete", false);
            return result;
        }
    }
    public DeleteEquipment(KnightInfo knights, List<EquipList> equipmentlist,List<WeaponList> weaponList){
        this.equipmentlist=equipmentlist;
        this.knightList =knights;
        this.weaponList=weaponList;
    }
}
