package com.example.maintermprojectjavafx;

import data.*;
import database.Insert;
import database.ReadData;
import equipment.Equipment;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import knight.Knight;
import weapon.Weapon;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class DeleteEquipmentAppl implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;
    private AllDataInterface allDataInterface =new AllDataInterface();
    private static int i=0;
    private static List<WeaponList> knightWeapon=new ArrayList<>();
    private static List<EquipList> knightequip=new ArrayList<>();
    private ReadData readData=new ReadData();
    private static KnightInfo knightInfo=new KnightInfo();
    private static WeaponList weaponList=new WeaponList();
    private static EquipList equipList=new EquipList();

    @FXML
    TableView<Knight> knightTableView;
    @FXML
    private TableColumn<Knight,String> name = new TableColumn<>();
    @FXML
    private TableColumn<Knight,Integer> age = new TableColumn<>();
    @FXML
    private TableColumn<Knight,Integer> century = new TableColumn<>();
    @FXML
    private TableColumn<Knight,String> nationality = new TableColumn<>();
    @FXML
    private TableColumn<Knight,Double> amountOfMoney = new TableColumn<>();
    @FXML
    private TableView<Equipment> EquipTable;
    @FXML
    private TableColumn<Equipment,String> equipName = new TableColumn<>();
    @FXML
    private TableColumn<Equipment,String> equipMaterial = new TableColumn<>();
    @FXML
    private TableColumn<Equipment, Double> equipCost = new TableColumn<>();
    @FXML
    private TableColumn<Equipment, Double> equipWeight = new TableColumn<>();
    @FXML
    private TableColumn<Equipment, Double> equipStrength = new TableColumn<>();
    @FXML
    private TableColumn<Equipment,String> equipTypeofarmor = new TableColumn<>();
    @FXML
    private TableView<Weapon> WeaponTable;
    @FXML
    private TableColumn<Weapon,String> nameWeapon = new TableColumn<>();
    @FXML
    private TableColumn<Weapon,String> typeWeapon = new TableColumn<>();
    @FXML
    private TableColumn<Weapon, Double> weightWeapon = new TableColumn<>();
    @FXML
    private TableColumn<Weapon, Double> costWeapon = new TableColumn<>();
    @FXML
    private TableColumn<Weapon, Double> damage = new TableColumn<>();

    public void buttonGetData(ActionEvent event) throws IOException {
        ObservableList<Knight> knights = readData.readKnightsInterface();
        knightTableView.setItems(knights);
        if(i==0) {
            //Loginlist loginlist = new Loginlist();
            knightWeapon = AllDataInterface.getKnightsWeapon();
            knightInfo = AllDataInterface.getKnightInfo();
            for (int i = 0; i < knightWeapon.size(); i++) {
                System.out.println(knightInfo.getknight(i).toString(i));
                knightWeapon.get(i).printList();
            }
        }
    }
    @FXML
    Label knighterror;
    public void buttonChooseKnight(ActionEvent event) throws IOException {
        if(knightInfo==null){
            knighterror.setText("Press button Get Data to see the list of knights");
            return;
        }
        int IdW = knightTableView.getSelectionModel().getSelectedIndex();
        if(IdW==-1){
            knighterror.setText("Press to the knight you want to choose");
            return;
        }
        allDataInterface.setIdofKnight(IdW);
        System.out.println(this.allDataInterface.getIdofKnight());
        if(knightInfo.getsize()==0) {
            readData.readKnights(knightInfo);
        }
        if(i==0){
            Loginlist loginlist=new Loginlist();
            readData.readLogins(loginlist);
            readData.readEquip(equipList);
            readData.readWeapon(weaponList);
//            readData.readKnightsEquipment(readData.userid(loginlist, AllDataInterface.getUser()),knightInfo,equipList,knightequip);
//            readData.readKnightsWeapon(readData.userid(loginlist, AllDataInterface.getUser()),knightInfo,weaponList,knightWeapon);
            knightInfo=AllDataInterface.getKnightInfo();
            knightequip=AllDataInterface.getKnightsEquip();
            knightWeapon=AllDataInterface.getKnightsWeapon();
            for(int i=0;i< knightWeapon.size();i++){
                System.out.println(knightInfo.getknight(i).toString(i));
                knightWeapon.get(i).printList();
            }
            i++;
        }
        System.out.println(AllDataInterface.getUser());
        root = FXMLLoader.load(getClass().getResource("DeleteEquipment.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setMaximized(true);
        stage.setResizable(true);
        scene = new Scene(root);
        stage.setTitle("Delete knights equip");
        stage.setScene(scene);
        stage.show();
    }
    public  void buttonGetDeleteData(ActionEvent event) throws IOException{
        Loginlist loginlist=new Loginlist();
        readData.readLogins(loginlist);
        System.out.println(allDataInterface.getIdofKnight());
        WeaponList weaponList1=new WeaponList();
        readData.readWeapon(weaponList1);
        readData.readEquip(equipList);
        KnightInfo knightInfo1=new KnightInfo();
        readData.readKnights(knightInfo1);
        ObservableList<Equipment> equipment= readData.readKnightsEquipmentforDelete(readData.userid(loginlist, AllDataInterface.getUser()),allDataInterface.getIdofKnight(),knightInfo1,equipList);
        EquipTable.setItems(equipment);
        ObservableList<Weapon> weapons= readData.readKnightsWeaponforDelete(readData.userid(loginlist, AllDataInterface.getUser()),allDataInterface.getIdofKnight(),knightInfo1,weaponList1);
        WeaponTable.setItems(weapons);
    }
    public void buttonDeleteEquipment(ActionEvent event)throws  IOException{
        int equipId=EquipTable.getSelectionModel().getSelectedIndex();
        Equipment equipment = EquipTable.getItems().get(equipId);
        if(equipId==-1){
            knighterror.setText("Press to the equipment you want to delete");
            return;
        }
        System.out.println(allDataInterface.getIdofKnight());
        System.out.println(knightInfo.getknight(allDataInterface.getIdofKnight()).toString(1));
        allDataInterface.setIdofEquipment(equipId);
        knightequip.get(allDataInterface.getIdofKnight()).printList();
        knightInfo.addMoney(allDataInterface.getIdofKnight(), knightequip.get(allDataInterface.getIdofKnight()).getelem(equipId).getCost());
        knightequip.get(allDataInterface.getIdofKnight()).removeelem(equipId);
        System.out.println(knightInfo.getknight(allDataInterface.getIdofKnight()).toString(allDataInterface.getIdofKnight()));
        knightequip.get(allDataInterface.getIdofKnight()).printList();
        Loginlist loginlist=new Loginlist();
        readData.readLogins(loginlist);
        Insert insert=new Insert();
        EquipList equipList1=new EquipList();
        readData.readEquip(equipList1);
        insert.insertKnightEquipment(insert.userid(loginlist, AllDataInterface.getUser()), equipList1, knightequip);
        AllDataInterface.setKnightsEquip(knightequip);
    }
    public void buttonDeleteWeapon(ActionEvent event)throws  IOException{
        int weaponId=WeaponTable.getSelectionModel().getSelectedIndex();
        Weapon equipment = WeaponTable.getItems().get(weaponId);
        if(weaponId==-1){
            knighterror.setText("Press to the weapon you want to delete");
            return;
        }
        System.out.println(allDataInterface.getIdofKnight());
        System.out.println(knightInfo.getknight(allDataInterface.getIdofKnight()).toString(1));
        allDataInterface.setIdofWeapon(weaponId);
        knightWeapon.get(allDataInterface.getIdofKnight()).printList();
        knightInfo.addMoney(allDataInterface.getIdofKnight(), knightWeapon.get(allDataInterface.getIdofKnight()).getelem(weaponId).getCost());
        knightWeapon.get(allDataInterface.getIdofKnight()).removeelem(weaponId);
        System.out.println(knightInfo.getknight(allDataInterface.getIdofKnight()).toString(allDataInterface.getIdofKnight()));
        knightWeapon.get(allDataInterface.getIdofKnight()).printList();
        Loginlist loginlist=new Loginlist();
        readData.readLogins(loginlist);
        Insert insert=new Insert();
        WeaponList weaponList1=new WeaponList();
        readData.readWeapon(weaponList1);
        insert.insertKnightsWeapon(insert.userid(loginlist, AllDataInterface.getUser()), weaponList1, knightWeapon);
        AllDataInterface.setKnightsWeapon(knightWeapon);
    }

    public void BackToSelectKnight(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("SelectKnightForDelete.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
//        for(int i=0;i< knightInfo.getsize();i++){
//            System.out.println(knightInfo.getknight(i).toString(i));
//            knightequip.get(i).printList();
//            knightWeapon.get(i).printList();
//        }
        stage.setTitle("Select knight");
        stage.setScene(scene);
        stage.show();
    }
    public void buttonBackToMenu(ActionEvent event) throws IOException {
        if(i!=0) {
            Insert insert = new Insert();
            Loginlist loginlist = new Loginlist();
            readData.readLogins(loginlist);
            WeaponList weaponList1=new WeaponList();
            readData.readWeapon(weaponList1);
            EquipList equipList1=new EquipList();
            readData.readEquip(equipList1);
            AllDataInterface.setKnightInfo(knightInfo);
            insert.insertKnightsWeapon(insert.userid(loginlist, AllDataInterface.getUser()), weaponList1, knightWeapon);
            AllDataInterface.setKnightsWeapon(knightWeapon);
            insert.insertKnightEquipment(insert.userid(loginlist, AllDataInterface.getUser()), equipList1, knightequip);
            AllDataInterface.setKnightsEquip(knightequip);
            i = 0;
        }
        root = FXMLLoader.load(getClass().getResource("menu2.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Menu of Action");
        stage.setScene(scene);
        stage.show();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        name.setCellValueFactory(new PropertyValueFactory<Knight,String>("name"));
        age.setCellValueFactory(new PropertyValueFactory<Knight,Integer>("age"));
        century.setCellValueFactory(new PropertyValueFactory<Knight,Integer>("century"));
        nationality.setCellValueFactory(new PropertyValueFactory<Knight,String>("nationality"));
        amountOfMoney.setCellValueFactory(new PropertyValueFactory<Knight,Double>("amountOfMoney"));
        equipName.setCellValueFactory(new PropertyValueFactory<Equipment,String>("name"));
        equipMaterial.setCellValueFactory(new PropertyValueFactory<Equipment,String>("material"));
        equipCost.setCellValueFactory(new PropertyValueFactory<Equipment,Double>("cost"));
        equipWeight.setCellValueFactory(new PropertyValueFactory<Equipment,Double>("weight"));
        equipStrength.setCellValueFactory(new PropertyValueFactory<Equipment,Double>("strength"));
        equipTypeofarmor.setCellValueFactory(new PropertyValueFactory<Equipment,String>("typeofarmour"));
        nameWeapon.setCellValueFactory(new PropertyValueFactory<Weapon,String>("name"));
        typeWeapon.setCellValueFactory(new PropertyValueFactory<Weapon,String>("type"));
        weightWeapon.setCellValueFactory(new PropertyValueFactory<Weapon,Double>("weight"));
        costWeapon.setCellValueFactory(new PropertyValueFactory<Weapon,Double>("cost"));
        damage.setCellValueFactory(new PropertyValueFactory<Weapon,Double>("damage"));
    }
}
