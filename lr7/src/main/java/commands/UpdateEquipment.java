package commands;

import data.EquipList;
import data.WeaponList;

import java.util.Scanner;

public class UpdateEquipment implements Commands {
    private WeaponList weaponList;
    private EquipList equipList;
    @Override
    public ResultOfCommand<String> execute()  {
        Scanner scanner=new Scanner(System.in);
        System.out.print("Which part of equip you want to update: 1 - equipment,2 - weapon:");
        int choice=scanner.nextInt();
        if(choice==1){
            this.equipList.printList();
            System.out.print("Enter what equipment info you want to update:");
            choice = scanner.nextInt();
            this.equipList.updateEquipment(choice);
            this.equipList.printList();
            System.out.println("Update is successful!");
            ResultOfCommand<String> result = new ResultOfCommand<String>("Succeeded","Update equipment works",true);
            return result;
        }
        if(choice==2){
            this.weaponList.printList();
            System.out.print("Enter what weapon info you want to update:");
            choice = scanner.nextInt();
            this.weaponList.updateWeapon(choice);
            this.weaponList.printList();
            System.out.println("Update is successful!");
            ResultOfCommand<String> result = new ResultOfCommand<String>("Succeeded","Update weapon works",true);
            return result;
        }
        else {
            System.out.println("You enter wrong number.Try again");
            ResultOfCommand<String> result = new ResultOfCommand<String>("Failed","Wrong number",false);
            return result;
        }
    }

    public UpdateEquipment(EquipList list,WeaponList weaponList){

        this.equipList =list;
        this.weaponList =weaponList;
    }
}
