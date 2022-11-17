package commands;

import Database.ReadData;
import data.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Menu {
    private List<ResultOfCommand<String>> report=new ArrayList<>();
    private List<java.util.Date> dates=new ArrayList<>();
    public void printequip(){
        System.out.print("Select the action:\nSelect equipment for knight - 1" +
                "            \nAdd new equipment - 2\nDelete equipment - 3\nSelect Weapon - 4\nLog out - 5\nUpdate equipment - 6\nBuild report - 7\nYour choice - ");
    }

    public void menu() throws Exception {
        ReadData readData=new ReadData();
        Loginlist usersdata = new Loginlist();
        readData.readLogins(usersdata);
        usersdata.printlist();
        Map<Integer, Commands> commands = new HashMap<>();
        int resindex=report.size();
        commands.put(1,new Info());
        commands.put(2,new Registration(usersdata));
        commands.put(3,new LogIn(usersdata));
        System.out.print("Welcome to menu.\nEnter what do you want to do?\nInfo - 1\nRegistration - 2\nLog in - 3\nExit - 0\nYour choice - ");
        Scanner scan = new Scanner(System.in);
        int numOfCommand = scan.nextInt();
        while(numOfCommand != 0)
        {
            ResultOfCommand<String> result= commands.get(numOfCommand).execute();
            long time=System.currentTimeMillis();
            dates.add(resindex,new Date(time));
            report.add(resindex,result);
            resindex++;
            if(numOfCommand==3 && result.isSuccessful()){
                menuOfEquipment();
            }
            System.out.print("Welcome to menu.\nEnter what do you want to do?\nInfo - 1\nRegistration - 2\nLog in - 3\nExit - 0\nYour choice - ");
            numOfCommand = scan.nextInt();
        }
        enterreport();
        usersdata.printlist();
        usersdata.enterall();
    }

    public void menuOfEquipment() throws Exception
    {
        EquipList allequip = new EquipList();
        ReadData readData=new ReadData();
        readData.readEquip(allequip);
        //allequip.printList();
        WeaponList allWeapon = new WeaponList();
        allWeapon.setAllweapon();
        KnightInfo listknights=new KnightInfo();
        readData.readKnights(listknights);
        listknights.printList();
        List<EquipList> knightsEquipment=new ArrayList<>();
        List<WeaponList> knightsWeapon=new ArrayList<>();
        printequip();
        Map<Integer, Commands> equipment=new HashMap<>();
        equipment.put(1,new SelectEquipment(listknights,allequip,knightsEquipment));
        equipment.put(2, new AddEquipment(allequip,allWeapon));
        equipment.put(3,new DeleteEquipment(listknights,knightsEquipment,knightsWeapon));
        equipment.put(4,new SelectWeapon(listknights,allWeapon,knightsWeapon));
        equipment.put(5,new LogOut());
        equipment.put(6,new UpdateEquipment(allequip,allWeapon));
        equipment.put(7,new BuildReport(listknights,knightsEquipment,knightsWeapon));
        Scanner scan = new Scanner(System.in);
        int numberOfAction = scan.nextInt();
        while(numberOfAction != 0){
            ResultOfCommand<String> result= equipment.get(numberOfAction).execute();;
            long time=System.currentTimeMillis();
            dates.add(report.size(),new Date(time));
            report.add(report.size(),result);
            if(numberOfAction==5)
                break;
            printequip();
            numberOfAction = scan.nextInt();
        }
        allequip.enterAllEquipment();
    }
    public void enterreport() throws IOException {
        FileWriter writer=new FileWriter("C:\\Users\\38098\\lr7\\src\\main\\resources\\Report.txt");
        boolean error=false;
        for(int i=0;i< report.size() && i<dates.size();i++){
//            System.out.println("Time of action: "+dates.get(i));
//            System.out.println("Info about action: "+report.get(i).Result());
            writer.write(dates.get(i)+"\n"+ report.get(i).getResult()+"\n"+report.get(i).getInformation()+"\n"+report.get(i).isSuccessful()+"\n");
            if(report.get(i).getResult().equalsIgnoreCase("Critical error"))
                error=true;
        }
        writer.close();
        if(error){
            Email email=new Email();
            email.send();
        }
    }
}
