package com.example.maintermprojectjavafx;

import data.AllDataInterface;
import data.EquipList;
import data.WeaponList;
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
import weapon.Weapon;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UpdateEquipmentAppl implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private TableView<Equipment> EquipTable;
    @FXML
    private TableColumn<Equipment,String> name = new TableColumn<>();
    @FXML
    private TableColumn<Equipment,String> material = new TableColumn<>();
    @FXML
    private TableColumn<Equipment, Double> cost = new TableColumn<>();
    @FXML
    private TableColumn<Equipment, Double> weight = new TableColumn<>();
    @FXML
    private TableColumn<Equipment, Double> strength = new TableColumn<>();
    @FXML
    private TableColumn<Equipment,String> typeofarmor = new TableColumn<>();
    private AllDataInterface allDataInterface=new AllDataInterface();
    @FXML
    private TextField costText;
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
    @FXML
    private TextField updatecostText;
    @FXML
    private Label equipUpdateLabel;
    @FXML
    private Label weaponUpdateLabel;
    @FXML
    private Label weaponresult;
    @FXML
    private Label equipresult;
    public void buttonEquipment(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("UpdateExistedEquipment.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Update Equipment");
        stage.setScene(scene);
        stage.show();
    }
    public void buttonBackToMenu(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("menu2.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        //stage.setTitle("Menu of Action");
        stage.setScene(scene);
        stage.show();
    }
    public void buttonBack(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("updateEquipment.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Update Ammunition");
        stage.setScene(scene);
        stage.show();
    }
    public void chooseEquip(ActionEvent event){
        equipresult.setText("");
        int Id = EquipTable.getSelectionModel().getSelectedIndex();
        Equipment equipment=EquipTable.getItems().get(Id);
        EquipList equipList=new EquipList();
        ReadData readData=new ReadData();
        readData.readEquip(equipList);
        Id = findidequip(equipList,equipment);
        allDataInterface.setIdofEquipment(Id);
        equipUpdateLabel.setVisible(true);
        costText.setVisible(true);
    }
    public void SubmitUpdateEquip(ActionEvent event) throws IOException {
        double cost=Double.parseDouble(costText.getText());
        //System.out.println(allDataInterface.getIdofEquipment());
        EquipList equipList=new EquipList();
        ReadData readData=new ReadData();
        if(equipList.getsize()==0)
            readData.readEquip(equipList);
        equipList.updateEquipmentInterface(this.allDataInterface.getIdofEquipment(),cost);
        equipresult.setText("Update equipment successful");
        buttonGetDataEquipment(event);
    }
    public int findidequip(EquipList equipList, Equipment elem){
        int count=0;
        for(;count<equipList.getsize();count++){
            if(equipList.getelem(count).getName().equals(elem.getName())){
                return (count);
            }
        }
        return -1;
    }
    public void chooseWeapon(ActionEvent event){
        weaponresult.setText("");
        int IdW = WeaponTable.getSelectionModel().getSelectedIndex();
        Weapon weapon= WeaponTable.getItems().get(IdW);
        WeaponList weaponList=new WeaponList();
        ReadData readData=new ReadData();
        if(weaponList.getsize()==0)
            readData.readWeapon(weaponList);
        IdW = findidweapon(weaponList,weapon);
        allDataInterface.setIdofWeapon(IdW);
        weaponUpdateLabel.setVisible(true);
        updatecostText.setVisible(true);
    }
    public void SubmitUpdateWeapon(ActionEvent event) throws IOException {
        double costWeapon=Double.parseDouble(updatecostText.getText());
        //System.out.println(allDataInterface.getIdofWeapon());
        WeaponList weaponList=new WeaponList();
        ReadData readData=new ReadData();
        readData.readWeapon(weaponList);
        weaponList.updateWeaponInterface(this.allDataInterface.getIdofWeapon(),costWeapon);
        weaponresult.setText("Update weapon successful");
        buttonGetDataWeapon(event);
    }
    public int findidweapon(WeaponList weaponList,Weapon elem){
        int count=0;
        for(;count<weaponList.getsize();count++){
            if(weaponList.getelem(count).getName().equals(elem.getName())){
                return (count);
            }
        }
        return -1;
    }
    public void buttonWeapon(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("UpdateExistedWeapon.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Update Weapon");
        stage.setScene(scene);
        stage.show();
    }
    public void buttonGetDataEquipment(ActionEvent event) throws IOException{
        ReadData readData=new ReadData();
        ObservableList<Equipment> equipment = readData.readEquipForTable();
        EquipTable.setItems(equipment);
    }
    public void buttonGetDataWeapon(ActionEvent event) throws IOException{
        ReadData readData=new ReadData();
        ObservableList<Weapon> weapon = readData.readWeaponForTable();
        WeaponTable.setItems(weapon);
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        name.setCellValueFactory(new PropertyValueFactory<Equipment,String>("name"));
        material.setCellValueFactory(new PropertyValueFactory<Equipment,String>("material"));
        cost.setCellValueFactory(new PropertyValueFactory<Equipment,Double>("cost"));
        weight.setCellValueFactory(new PropertyValueFactory<Equipment,Double>("weight"));
        strength.setCellValueFactory(new PropertyValueFactory<Equipment,Double>("strength"));
        typeofarmor.setCellValueFactory(new PropertyValueFactory<Equipment,String>("typeofarmour"));
        nameWeapon.setCellValueFactory(new PropertyValueFactory<Weapon,String>("name"));
        typeWeapon.setCellValueFactory(new PropertyValueFactory<Weapon,String>("type"));
        weightWeapon.setCellValueFactory(new PropertyValueFactory<Weapon,Double>("weight"));
        costWeapon.setCellValueFactory(new PropertyValueFactory<Weapon,Double>("cost"));
        damage.setCellValueFactory(new PropertyValueFactory<Weapon,Double>("damage"));
    }
}
