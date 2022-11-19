package commands;
import data.EquipList;
import data.KnightInfo;
import equipment.Equipment;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class SelectEquipment implements Commands {
    private KnightInfo knightlist;
    private EquipList equiplist;
    private List<EquipList> knightequip;
    @Override
    public ResultOfCommand<String> execute() {
        Scanner scan=new Scanner(System.in);
        int choice=knightlist.chooseKnight(scan);
//        System.out.println("Choose the knight you want to equip from list below:");
//        knightlist.printList();
//        System.out.print("Your choice - ");
//        int choice= scan.nextInt();
//        System.out.println("You chose "+knightlist.getknight(choice).toString(choice));
        checksize(choice);
//        if(knightequip.get(choice).getsize()!=0){
//            System.out.println("You already chose equipment for this knight.Pick another knight");
//            ResultOfCommand<String> result = new ResultOfCommand<String>("Failed","Knight already has equipment",false);
//            return result;
//        }
        //knightequip.add(choice,new EquipList());
        equiplist.printList();
        System.out.print("Which equipment you want to add - ");
        int equip=scan.nextInt();
        int countofequipment=0;
        double money=knightlist.getknight(choice).getAmountOfMoney();
        double allcost=0;
        while(equip<equiplist.getsize() && money>0){
            if(!isExist(equiplist.getelem(equip), knightequip.get(choice))){
                money-=equiplist.getelem(equip).getCost();
                if(money<=0)  break;
                knightequip.get(choice).addKnightEquip(equiplist.getelem(equip),knightequip.get(choice).getsize());
                countofequipment+=1;
                allcost+=equiplist.getelem(equip).getCost();
                System.out.println("Amount of money left - "+money);
            }
            System.out.print("Which equipment you want to add - ");
            equip=scan.nextInt();
        }
        knightlist.cutMoney(choice,allcost);
        System.out.println("Your knight:");
        System.out.println(knightlist.getknight(choice).toString(choice));
        System.out.println("Your knight's equipment,sorted by weight:");
        knightequip.get(choice).sortEquip();
        System.out.println("Select equipment works!");
        ResultOfCommand<String> result = new ResultOfCommand<String>("Succeeded","Select equipment works",true);
        return result;
    }
    public boolean isExist(Equipment element,EquipList arrayList){
        for(int i=0;i< arrayList.getsize();i++){
            if(element.getTypeofarmour().equalsIgnoreCase(arrayList.getelem(i).getTypeofarmour())){
                System.out.println("You already choose armor of this type,try again");
                return true;}
        }
        return false;
    }
    public void checksize(int i){
        if(knightequip.size()<=i){
            for(int k=knightequip.size();k<=i;k++){
                knightequip.add(k,new EquipList());
            }
        }
    }
    public SelectEquipment(KnightInfo knights,EquipList equiplist,List<EquipList> knightequip){
        this.knightlist=knights;
        this.equiplist=equiplist;
        this.knightequip=knightequip;
    }
}
