package weapon;

import database.Insert;

import java.util.Scanner;

public class Knife extends Weapon{

    private String typeofknife;
    public Knife(String name,String type,double weight,double cost,double damage,String typeofknife){
        super(name,type,weight,cost,damage);
        this.typeofknife=typeofknife;
    }
    public String getTypeofknife() {
        return typeofknife;
    }

    public void setTypeofknife(String typeofknife) {
        this.typeofknife = typeofknife;
    }
    public Knife(){
        super();
        this.type="Knife";
        Scanner scanner=new Scanner(System.in);
        System.out.print("Enter the type of knife: ");
        this.typeofknife=scanner.nextLine();
        Insert insert=new Insert();
        insert.insertKnife(name, type, weight, cost, damage, typeofknife);
    }

    @Override
    public String toString(int i) {
        return i+".Knife "+
                " : name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", weight=" + weight +
                ", cost=" + cost +
                ", damage=" + damage +
                ", typeofknife='" + typeofknife + '\'';
    }
}
