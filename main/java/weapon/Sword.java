package weapon;

import database.Insert;

import java.util.Scanner;

public class Sword extends Weapon{

    private String typeOfBlade;
    public Sword(String name,String type,double weight,double cost,double damage,String typeOfBlade){
        super(name,type,weight,cost,damage);
        this.typeOfBlade = typeOfBlade;
    }
    public Sword(){
        super();
        this.type="Sword";
        Scanner scanner=new Scanner(System.in);
        System.out.print("Enter the type of blade: ");
        this.typeOfBlade =scanner.nextLine();
        Insert insert=new Insert();
        insert.insertAxe(name, type, weight, cost, damage, typeOfBlade);
    }
    public String getTypeOfBlade() {
        return typeOfBlade;
    }

    public void setTypeOfBlade(String typeOfBlade) {
        this.typeOfBlade = typeOfBlade;
    }
    public String toString(int i) {
        return i+ ".Sword " +
                " : name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", weight=" + weight +
                ", cost=" + cost +
                ", damage=" + damage +
                ", typeofblade='" + typeOfBlade + '\'';
    }
}
