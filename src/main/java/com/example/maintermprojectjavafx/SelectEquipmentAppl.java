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
import org.w3c.dom.Text;
import weapon.Weapon;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class SelectEquipmentAppl implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    TableView<Knight> knightsTable;
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
    private AllDataInterface allDataInterface =new AllDataInterface();
    @FXML
    TextField nameText;
    @FXML
    TextField ageText;
    @FXML
    TextField centuryText;
    @FXML
    TextField nationalityText;
    @FXML
    TextField amountofmoneyText;
    @FXML
    private TableView<Equipment> EquipTable;
    @FXML
    private TableColumn<Equipment,String> nameEquip = new TableColumn<>();
    @FXML
    private TableColumn<Equipment,String> materialEquip = new TableColumn<>();
    @FXML
    private TableColumn<Equipment, Double> costEquip = new TableColumn<>();
    @FXML
    private TableColumn<Equipment, Double> weightEquip = new TableColumn<>();
    @FXML
    private TableColumn<Equipment, Double> strengthEquip = new TableColumn<>();
    @FXML
    private TableColumn<Equipment,String> typeofarmorEquip = new TableColumn<>();
    @FXML
    Label error;
    @FXML
    Label addedlist;
    @FXML
    Label money;
    private static List<EquipList> knigthequip=new ArrayList<>();
    private ReadData readData=new ReadData();
    private static KnightInfo knightInfo=new KnightInfo();
    private static EquipList equipList=new EquipList();
    private static int i=0;
    public void buttonGetData(ActionEvent event) throws  IOException{
        ReadData readData=new ReadData();
        ObservableList<Knight> equipment = readData.readKnightsInterface();
        knightsTable.setItems(equipment);
        if(i==0) {
            Loginlist loginlist = new Loginlist();
            knigthequip = AllDataInterface.getKnightsEquip();
            knightInfo = AllDataInterface.getKnightInfo();
        }
    }
    public void buttonChooseKnight(ActionEvent event) throws  IOException{
        int IdW = knightsTable.getSelectionModel().getSelectedIndex();
        allDataInterface.setIdofKnight(IdW);
        if(IdW==-1){
            return;
        }
        if(knightInfo.getsize()==0) {
            readData.readKnights(knightInfo);
        }
        if(i==0){
            Loginlist loginlist=new Loginlist();
            readData.readLogins(loginlist);
            knigthequip=new ArrayList<>();
            knigthequip = AllDataInterface.getKnightsEquip();
            i++;
        }
        root = FXMLLoader.load(getClass().getResource("SelectEquipment.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Select equipment");
        stage.setScene(scene);
        stage.show();
    }

    public void buttonAddKnight(ActionEvent event) throws  IOException{
        root = FXMLLoader.load(getClass().getResource("AddKnight.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Add knight");
        stage.setScene(scene);
        stage.show();
    }
    public void AddNewKnight(ActionEvent event)throws IOException {
        addknighterror.setText("");
        String nameT =  nameText.getText();
        int ageT = Integer.parseInt(ageText.getText());
        int centuryT = Integer.parseInt(centuryText.getText());
        String nationalityT = nationalityText.getText();
        double amountofmoneyT = Double.parseDouble(amountofmoneyText.getText());
        KnightInfo knightInfo=new KnightInfo();
        readData.readKnights(knightInfo);
        if(!checkExistedName(knightInfo,nameT)) {
            knightInfo.addKnightInterface(nameT, ageT, centuryT, nationalityT, amountofmoneyT);
            BackToSelectKnight(event);
        }
        //buttonGetData(event);
    }
    @FXML
    Label addknighterror;
    public boolean checkExistedName(KnightInfo knightInfo,String name){
        for (int i=0;i<knightInfo.getsize();i++) {
            if (knightInfo.getknight(i).getName().equalsIgnoreCase(name)) {
                addknighterror.setText("There is already knight with this name.\nPlease enter another name");
                return true;
            }
        }
        return false;
    }
    public void buttonGetDataEquipment(ActionEvent event) throws IOException{
        ReadData readData=new ReadData();
        ObservableList<Equipment> equipment = readData.readEquipForTable();
        EquipTable.setItems(equipment);
        checksize(allDataInterface.getIdofKnight(),knigthequip);
        checkExistedequip();
    }
    public void chooseEquipment(ActionEvent event){
        int Id = EquipTable.getSelectionModel().getSelectedIndex();
        Equipment equipment = EquipTable.getItems().get(Id);
       if(equipList.getsize()==0) {
           readData.readEquip(equipList);
       }
        Id=findid(equipList,equipment);
        allDataInterface.setIdofEquipment(Id);
        double amountOfMoney1=knightInfo.getknight(allDataInterface.getIdofKnight()).getAmountOfMoney();
        double allcost=0;
        if(!isExist(equipList.getelem(Id), knigthequip.get(allDataInterface.getIdofKnight()))) {
            amountOfMoney1 -= equipList.getelem(Id).getCost();
            if (amountOfMoney1 <= 0){
                error.setText("Not enough noney");
            return;
            }
            knigthequip.get(allDataInterface.getIdofKnight()).addKnightEquipInterface(equipList.getelem(Id));
            addedlist.setText(addedlist.getText()+"\n you add "+equipList.getelem(Id).getName());
            allcost+=equipList.getelem(Id).getCost();
            money.setText("Amount of money left - "+amountOfMoney1);
            i++;
        }
        knightInfo.cutMoney(allDataInterface.getIdofKnight(), allcost);
        knigthequip.get(allDataInterface.getIdofKnight()).sortEquip();
        //knightInfo.printList();
    }
    public int findid(EquipList equipList, Equipment elem){
        int count=0;
        for(;count<equipList.getsize();count++){
            if(equipList.getelem(count).getName().equals(elem.getName())){
                return (count);
            }
        }
        return -1;
    }
    public void checkExistedequip(){
        for(int l=0;l<knigthequip.get(allDataInterface.getIdofKnight()).getsize();l++){
            addedlist.setText(addedlist.getText()+"\n you already has "+knigthequip.get(allDataInterface.getIdofKnight()).getelem(l).getName());
        }
        money.setText("Amount of money left - "+knightInfo.getknight(allDataInterface.getIdofKnight()).getAmountOfMoney());
    }
    public boolean isExist(Equipment element,EquipList arrayList){
        if(arrayList.getsize()==4){
            error.setText("You already choose 1 equip of each type");
            return true;
        }
        for(int i=0;i< arrayList.getsize();i++){
            if(element.getTypeofarmour().equalsIgnoreCase(arrayList.getelem(i).getTypeofarmour())){
                error.setText("You already choose armor of this type,try again");
                return true;}
        }
        return false;
    }
    public void checksize(int i,List<EquipList> knightequip){
        if(knightequip.size()<=i){
            for(int k=knightequip.size();k<=i;k++){
                knightequip.add(k,new EquipList());
            }
        }
    }
    public void BackToSelectKnight(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("SelectKnightforEquip.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
//        for(int i=0;i< knigthequip.size();i++){
//            //System.out.println(knightInfo.getknight(i).toString(i));
//            knigthequip.get(i).printList();
//        }
        stage.setTitle("Select knight");
        stage.setScene(scene);
        stage.show();
    }
    public void buttonBackToMenu(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("menu2.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        if(i!=0) {
            Insert insert = new Insert();
            Loginlist loginlist = new Loginlist();
            AllDataInterface.setKnightInfo(knightInfo);
            readData.readLogins(loginlist);
            EquipList equipList1 = new EquipList();
            readData.readEquip(equipList1);
            insert.insertKnightEquipment(insert.userid(loginlist, AllDataInterface.getUser()), equipList1, knigthequip);
            AllDataInterface.setKnightsEquip(knigthequip);
            knigthequip=new ArrayList<>();
        }
        i=0;
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
        nameEquip.setCellValueFactory(new PropertyValueFactory<Equipment,String>("name"));
        materialEquip.setCellValueFactory(new PropertyValueFactory<Equipment,String>("material"));
        costEquip.setCellValueFactory(new PropertyValueFactory<Equipment,Double>("cost"));
        weightEquip.setCellValueFactory(new PropertyValueFactory<Equipment,Double>("weight"));
        strengthEquip.setCellValueFactory(new PropertyValueFactory<Equipment,Double>("strength"));
        typeofarmorEquip.setCellValueFactory(new PropertyValueFactory<Equipment,String>("typeofarmour"));
    }
}
