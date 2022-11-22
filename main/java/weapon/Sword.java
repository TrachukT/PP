package weapon;

import database.Insert;

import java.util.Scanner;

public class Sword extends Weapon{
    protected String typeofblade;
    public Sword(String name,String type,double weight,double cost,double damage,String typeofblade){
        super(name,type,weight,cost,damage);
        this.typeofblade=typeofblade;
    }
    public Sword(){
        super();
        this.type="Sword";
        Scanner scanner=new Scanner(System.in);
        System.out.print("Enter the type of blade: ");
        this.typeofblade=scanner.nextLine();
        Insert insert=new Insert();
        insert.insertAxe(name, type, weight, cost, damage, typeofblade);
    }

    public String toString(int i) {
        return i+ ".Sword " +
                " : name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", weight=" + weight +
                ", cost=" + cost +
                ", damage=" + damage +
                ", typeofblade='" + typeofblade + '\'';
    }
}
