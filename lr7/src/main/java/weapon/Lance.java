package weapon;

import java.util.Scanner;

public class Lance extends Weapon{
    int lengthoflance;
    public Lance(String name,String type,double weight,double cost,double damage,int lengthoflance){
        super(name,type,weight,cost,damage);
        this.lengthoflance=lengthoflance;
    }
    public Lance(){
        super();
        this.type="Lance";
        Scanner scanner=new Scanner(System.in);
        System.out.print("Enter the length of blade: ");
        this.lengthoflance=scanner.nextInt();
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
