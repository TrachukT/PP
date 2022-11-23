package com.example.maintermprojectjavafx;

import commands.ResultOfCommand;
import data.AllDataInterface;
import data.EquipList;
import data.KnightInfo;
import data.WeaponList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class BuildReportAppl {
    private Stage stage;
    private Scene scene;
    private Parent root;
    private static KnightInfo knightInfo = new KnightInfo();
    private static List<EquipList> knightsequip = new ArrayList<>();
    private static List<WeaponList> knightsweapon = new ArrayList<>();
    private AllDataInterface allDataInterface=new AllDataInterface();
    @FXML
    Label report;
    public void buttonBuildReport(ActionEvent event){
        knightInfo=AllDataInterface.getKnightInfo();
        knightsequip = AllDataInterface.getKnightsEquip();
        if( knightInfo==null || knightInfo.getsize()==0){
            report.setText("You have no knights");
        }
        for(int i=0;i< knightInfo.getsize();i++) {
            report.setText(report.getText()+"\n"+knightInfo.getknight(i).toString(i));
            if (i<knightsequip.size() && knightsequip.get(i).getsize() != 0 ) {
                report.setText(report.getText()+"\n"+"Your knight equipment:");
                for(int m=0;m<knightsequip.get(i).getsize();m++){
                    report.setText(report.getText()+"\n"+knightsequip.get(i).getelem(m).toString(m));
                }
            }
//            if (i<knightsweapon.size() && knightsweapon.get(i).getsize() != 0) {
//                report.setText(report.getText()+"\n"+"Your knight weapon :");
//                for(int w=0;w<knightsequip.get(i).getsize();w++){
//                    report.setText(report.getText()+"\n"+knightsweapon.get(i).getelem(w).toString(w));
//                }
//            }
        }
    }
}
