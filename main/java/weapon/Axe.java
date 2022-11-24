package weapon;

import database.Insert;

import java.util.Scanner;

public class Axe extends Weapon{
    private String bladeshape;
    public Axe(String name,String type,double weight,double cost,double damage,String bladeshape){
        super(name, type, weight, cost, damage);
        this.bladeshape=bladeshape;
    }
    public String getBladeshape() {
        return bladeshape;
    }

    public void setBladeshape(String bladeshape) {
        this.bladeshape = bladeshape;
    }

    public Axe(){
        super();
        this.type="Axe";
        Scanner scanner=new Scanner(System.in);
        System.out.print("Enter the shape of blade: ");
        this.bladeshape=scanner.nextLine();
        Insert insert=new Insert();
        insert.insertAxe(name, type, weight, cost, damage, bladeshape);
    }
    public String toString(int i) {
        return i+".Axe   " +
                " : name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", weight=" + weight +
                ", cost=" + cost +
                ", damage=" + damage +
                ", bladeshape='" + bladeshape + '\'';
    }
}
