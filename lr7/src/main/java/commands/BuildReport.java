package commands;

import data.EquipList;
import data.KnightInfo;
import data.WeaponList;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BuildReport implements Commands {
    private List<ResultOfCommand<String>> result;
    private List<java.util.Date> dates;
    private KnightInfo knight;
    private List<EquipList> equipLists;
    private List<WeaponList> weaponLists;
    @Override
    public ResultOfCommand<String> execute() throws IOException {
        if(knight.getsize()==0){
            System.out.println("You have no knights");
            ResultOfCommand<String> result = new ResultOfCommand<String>("Succeeded","Action possible",true);
            return result;
        }
        for(int i=0;i<knight.getsize();i++) {
            System.out.println(knight.getknight(i).toString(i));
            if (i<equipLists.size() && equipLists.get(i).getsize() != 0 ) {
                System.out.println("Your knight equipment:");
                equipLists.get(i).printList();
            }
            if (i<weaponLists.size() && weaponLists.get(i).getsize() != 0) {
                System.out.println("Your knight weapon :");
                weaponLists.get(i).printList();
            }
        }
        if(dates.isEmpty() && result.isEmpty()){
            ResultOfCommand<String> result = new ResultOfCommand<String>("Succeeded","Lists are empty",true);
            return result;
        }
        FileWriter fileWriter=new FileWriter("C:\\Users\\38098\\lr7\\src\\main\\resources\\Report.txt");
        for(int i=0;i< result.size() && i<dates.size();i++){
            System.out.println("Time of action: "+dates.get(i));
            System.out.println("Info about action: "+result.get(i).Result());
            fileWriter.write(dates.get(i)+"\n"+ result.get(i).getResult()+"\n"+result.get(i).getInformation()+"\n"+result.get(i).isSuccessful()+"\n");
        }
        fileWriter.close();
        System.out.println("Building report works!");
        ResultOfCommand<String> result = new ResultOfCommand<String>("Succeeded","Build report works",true);
        return result;
    }
    public BuildReport(KnightInfo knight, List<EquipList> equipLists, List<WeaponList> weaponLists,List<ResultOfCommand<String>> res,List<java.util.Date> dates){
        this.knight=knight;
        this.equipLists=equipLists;
        this.weaponLists=weaponLists;
        this.dates=dates;
        this.result=res;
    }
}

