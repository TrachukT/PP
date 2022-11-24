package weapon;

import database.Insert;

import java.util.Scanner;

public class Lance extends Weapon{
    private int lengthoflance;
    public Lance(String name,String type,double weight,double cost,double damage,int lengthoflance){
        super(name,type,weight,cost,damage);
        this.lengthoflance=lengthoflance;
    }
    public int getLengthoflance() {
        return lengthoflance;
    }

    public void setLengthoflance(int lengthoflance) {
        this.lengthoflance = lengthoflance;
    }
    public Lance(){
        super();
        this.type="Lance";
        Scanner scanner=new Scanner(System.in);
        System.out.print("Enter the length of blade: ");
        this.lengthoflance=scanner.nextInt();
        Insert insert=new Insert();
        insert.insertLance(name, type, weight, cost, damage, lengthoflance);
    }

    @Override
    public String toString(int i) {
        return i+".Lance" +
                " : name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", weight=" + weight +
                ", cost=" + cost +
                ", damage=" + damage +
                ", lengthoflance=" + lengthoflance ;
    }
}
