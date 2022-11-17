package weapon;

import java.util.Scanner;

public class Weapon {
    String name;
    String type;
    double weight;
    double cost;
    double damage;
    public Weapon(String name,String type,double weight,double cost,double damage){
        this.name=name;
        this.type=type;
        this.weight=weight;
        this.cost=cost;
        this.damage=damage;
    }
    public Weapon(){
        Scanner scannerstr=new Scanner(System.in);
        Scanner scanner=new Scanner(System.in);
        System.out.print("Enter the name: ");
        this.name=scannerstr.nextLine();
        System.out.print("Enter the weight: ");
        this.weight=scanner.nextDouble();
        System.out.print("Enter the cost: ");
        this.cost=scanner.nextDouble();
        System.out.print("Enter the damage: ");
        this.damage=scanner.nextDouble();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public double getWeight() {
        return weight;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }
    public double getCost() {
        return cost;
    }
    public void setCost(double cost) {
        this.cost = cost;
    }
    public double getDamage() {
        return damage;
    }
    public void setDamage(double damage) {
        this.damage = damage;
    }

    public String toString(int i) {
        return "Weapon " +i+
                ": name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", weight=" + weight +
                ", cost=" + cost +
                ", damage=" + damage ;
    }
}
