package commands;

import data.KnightInfo;
import data.WeaponList;
import weapon.Weapon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SelectWeapon implements Commands {
    private KnightInfo knights;
    WeaponList allWeapon;
    private List<WeaponList> knightsWeapon;
    @Override
    public ResultOfCommand<String> execute()   {
        Scanner scanner=new Scanner(System.in);
        int choice=knights.chooseKnight(scanner);
//        System.out.println("Choose the knight you want to equip from list below:");
//        knights.printList();
//        System.out.print("Your choice - ");
//        int choice= scanner.nextInt();
//        System.out.println("You chose "+knights.getknight(choice).toString(choice));
        checksize(choice);
        if(knightsWeapon.get(choice).getsize()!=0){
            System.out.println("You already chose weapon for this knight.Pick another knight");
            ResultOfCommand<String> result = new ResultOfCommand<String>("Failed","Knight already has weapon",false);
            return result;
        }
        allWeapon.printList();
        System.out.print("Which weapon you want to add - ");
        int weapon=scanner.nextInt();
        int countOfWeapon=0;
        double money=knights.getknight(choice).getAmountOfMoney();
        double allcost=0;
        while(weapon<allWeapon.getsize() && money>0){
            if(!isExist(allWeapon.getelem(weapon), knightsWeapon.get(choice))){
                money-=allWeapon.getelem(weapon).getCost();
                if(money<=0)  break;
                knightsWeapon.get(choice).addKnightWeapon(allWeapon.getelem(weapon),countOfWeapon);
                countOfWeapon+=1;
                allcost+=allWeapon.getelem(weapon).getCost();
                System.out.println("Amount of money left - "+money);
            }
            System.out.print("Which equipment you want to add - ");
            weapon=scanner.nextInt();
        }
        knights.cutMoney(choice,allcost);
        System.out.println("Your knight:");
        System.out.println(knights.getknight(choice).toString(choice));
        System.out.println("Your knight's weapon,sorted by weight:");
        knightsWeapon.get(choice).sortWeapon();
        System.out.println("Select weapon works");
        ResultOfCommand<String> result = new ResultOfCommand<String>("Succeeded","Select weapon works",true);
        return result;
    }
    public boolean isExist(Weapon element, WeaponList arrayList){
        for(int i=0;i< arrayList.getsize();i++){
            if(element.getType().equalsIgnoreCase(arrayList.getelem(i).getType())){
                System.out.println("You already choose armor of this type,try again");
                return true;}
        }
        return false;
    }
    public void checksize(int i){
        if(knightsWeapon.size()<=i){
            for(int k=knightsWeapon.size();k<=i;k++){
                knightsWeapon.add(k,new WeaponList());
            }
        }
    }
    public  SelectWeapon(KnightInfo knightInfo,WeaponList allWeapon,List<WeaponList> weapons){
        this.knights=knightInfo;
        this.knightsWeapon=weapons;
        this.allWeapon=allWeapon;
    }
}

