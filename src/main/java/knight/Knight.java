package knight;
import database.Insert;

import java.util.Scanner;
public class Knight {
    private double getAmountOfMoney;
    private String name;
    private int age ;
    private int century ;
    private String nationality;
    private double amountOfMoney;
    public Knight(String name, int age, int century, String nationality,double amountOfMoney) {
        this.name = name;
        this.age = age;
        this.century = century;
        this.nationality = nationality;
        this.amountOfMoney=amountOfMoney;
    }
    public Knight(){
        Scanner scan=new Scanner(System.in);
        System.out.print("Enter the name:");
        String name= scan.next();
        setName(name);
        System.out.print("Enter the age:");
        int age= scan.nextInt();
        setAge(age);
        System.out.print("Enter the century:");
        int century= scan.nextInt();
        setCentury(century);
        System.out.print("Enter the nationality:");
        String nationality= scan.next();
        setNationality(nationality);
        System.out.print("Enter the amount of money for equip:");
        this.amountOfMoney= scan.nextDouble();
        Insert insert=new Insert();
        insert.insertKnight(name,age,century,nationality,amountOfMoney);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getCentury() {
        return century;
    }

    public void setCentury(int century) {
        this.century = century;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public double getAmountOfMoney() {    return amountOfMoney;   }

    public void setAmountOfMoney(double amountOfMoney) {  this.amountOfMoney = amountOfMoney; }


    public String toString(int i) {
        return "------------------------------------------------------\nKnight number " +i+
                ": Name = " + name +
                ",Age = " + age +
                ",Century = " + century +
                ",Nationality = " + nationality+
                ",Amount of money = "+amountOfMoney;
    }
}
