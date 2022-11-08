package weapon;

import java.util.Scanner;

public class Bow extends Weapon{
    int amOfArrows;
    String typeOfBowstring;
    public Bow(String name,String type,double weight,double cost,double damage,int amofarrows,String typeofbowstring){
        super(name,type,weight,cost,damage);
        this.amOfArrows = amofarrows;
        this.typeOfBowstring = typeofbowstring;
    }
    public Bow(){
        super();
        this.type="Bow";
        Scanner scanner=new Scanner(System.in);
        System.out.print("Enter the amount of arrows: ");
        this.amOfArrows=scanner.nextInt();
        System.out.print("Enter the amount of arrows: ");
        this.typeOfBowstring=scanner.nextLine();
    }

    @Override
    public String toString(int i) {
        return i+".Bow   " +
                " : name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", weight=" + weight +
                ", cost=" + cost +
                ", damage=" + damage +
                ", amOfArrows=" + amOfArrows +
                ", typeOfBowstring='" + typeOfBowstring + '\'';
    }
}

