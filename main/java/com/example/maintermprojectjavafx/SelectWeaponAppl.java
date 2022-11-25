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
import javafx.scene.control.Labeled;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import knight.Knight;
import weapon.*;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class SelectWeaponAppl implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;
    private static List<WeaponList> knightWeapon=new ArrayList<>();
    private ReadData readData=new ReadData();
    private static KnightInfo knightInfo=new KnightInfo();
    private static WeaponList weaponList=new WeaponList();
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
    private TableView<Bow> BowTable;
    @FXML
    private TableColumn<Bow,String> bowName = new TableColumn<>();
    @FXML
    private TableColumn<Bow,String> bowType = new TableColumn<>();
    @FXML
    private TableColumn<Bow, Double> bowWeight = new TableColumn<>();
    @FXML
    private TableColumn<Bow, Double> bowCost = new TableColumn<>();
    @FXML
    private TableColumn<Bow, Double> bowDamage = new TableColumn<>();
    @FXML
    private TableColumn<Bow,Integer> bowAmountOfArrows = new TableColumn<>();
    @FXML
    private TableColumn<Bow, String> bowTypeOfBowstring = new TableColumn<>();
    @FXML
    private TableView<Lance> LanceTable;
    @FXML
    private TableColumn<Lance,String> lanceName = new TableColumn<>();
    @FXML
    private TableColumn<Lance,String> lanceType = new TableColumn<>();
    @FXML
    private TableColumn<Lance, Double> lanceWeight = new TableColumn<>();
    @FXML
    private TableColumn<Lance, Double> lanceCost = new TableColumn<>();
    @FXML
    private TableColumn<Lance, Double> lanceDamage = new TableColumn<>();
    @FXML
    private TableColumn<Lance, Integer> lancelength = new TableColumn<>();
    @FXML
    private TableView<Sword> SwordTable;
    @FXML
    private TableColumn<Sword,String> swordName = new TableColumn<>();
    @FXML
    private TableColumn<Sword,String> swordType = new TableColumn<>();
    @FXML
    private TableColumn<Sword, Double> swordWeight = new TableColumn<>();
    @FXML
    private TableColumn<Sword, Double> swordCost = new TableColumn<>();
    @FXML
    private TableColumn<Sword, Double> swordDamage = new TableColumn<>();
    @FXML
    private TableColumn<Sword, String> swordblade = new TableColumn<>();
    @FXML
    private TableView<Knife> KnifeTable;
    @FXML
    private TableColumn<Knife,String> knifeName = new TableColumn<>();
    @FXML
    private TableColumn<Knife,String> knifeTypeOfWeapon = new TableColumn<>();
    @FXML
    private TableColumn<Knife, Double> knifeWeight = new TableColumn<>();
    @FXML
    private TableColumn<Knife, Double> knifeCost = new TableColumn<>();
    @FXML
    private TableColumn<Knife, Double> knifeDamage = new TableColumn<>();
    @FXML
    private TableColumn<Knife, String> typeOfKnife = new TableColumn<>();
    @FXML
    private TableView<Axe> AxeTable;
    @FXML
    private TableColumn<Axe,String> axeName = new TableColumn<>();
    @FXML
    private TableColumn<Axe,String> axeType = new TableColumn<>();
    @FXML
    private TableColumn<Axe, Double> axeWeight = new TableColumn<>();
    @FXML
    private TableColumn<Axe, Double> axeCost = new TableColumn<>();
    @FXML
    private TableColumn<Axe, Double> axeDamage = new TableColumn<>();
    @FXML
    private TableColumn<Axe, String> axeblade = new TableColumn<>();
    @FXML
    Label knighterror;
    private AllDataInterface allDataInterface =new AllDataInterface();
    private static int i=0;
    public void buttonGetData(ActionEvent event) throws IOException {
        ObservableList<Knight> weapon = readData.readKnightsInterface();
        knightTableView.setItems(weapon);
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
    public void buttonGetDataWeapons(ActionEvent event) throws IOException{
        ReadData readData=new ReadData();
        ObservableList<Bow> bow = readData.readBowForTable();
        BowTable.setItems(bow);
        ObservableList<Axe> axes = readData.readAxeForTable();
        AxeTable.setItems(axes);
        ObservableList<Lance> lances = readData.readLanceForTable();
        LanceTable.setItems(lances);
        ObservableList<Knife> knives = readData.readKnifeForTable();
        KnifeTable.setItems(knives);
        ObservableList<Sword> swords=readData.readSwordForTable();
        SwordTable.setItems(swords);
    }

    public void buttonChooseKnight(ActionEvent event) throws  IOException{
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
        //Idknight=IdW;
        //System.out.println(Idknight);
        if(knightInfo.getsize()==0) {
            readData.readKnights(knightInfo);
        }
        if(knightWeapon.size()==0){
            Loginlist loginlist=new Loginlist();
            readData.readLogins(loginlist);
            readData.readKnightsWeapon(readData.userid(loginlist,AllDataInterface.getUser()),knightInfo,weaponList,knightWeapon);
            for(int i=0;i< knightWeapon.size();i++){
                System.out.println(knightInfo.getknight(i).toString(i));
                knightWeapon.get(i).printList();
            }
            i++;
        }
        System.out.println(AllDataInterface.getUser());
        root = FXMLLoader.load(getClass().getResource("SelectWeapon.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setMaximized(true);
        stage.setResizable(true);
        scene = new Scene(root);
        stage.setTitle("Select weapon");
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
    @FXML
    Label chooseBow;
    @FXML
    Label error;
    @FXML
    Label money;
    public void buttonChooseBow(ActionEvent event){
        int Id = BowTable.getSelectionModel().getSelectedIndex();
        Bow elem= BowTable.getItems().get(Id);
        //System.out.println(elem.toString(1));
        allDataInterface.setIdofWeapon(Id);
        if(weaponList.getsize()==0) {
            readData.readWeapon(weaponList);
        }
        double amountOfMoney1=knightInfo.getknight(allDataInterface.getIdofKnight()).getAmountOfMoney();
        double allcost=0;
        checksize(allDataInterface.getIdofKnight());
        int weaponId= findid(weaponList,elem);
        if(!isExist(weaponList.getelem(weaponId), knightWeapon.get(allDataInterface.getIdofKnight()))) {
            amountOfMoney1 -= weaponList.getelem(weaponId).getCost();
            if (amountOfMoney1 <= 0){
                error.setText("Not enough money");
                return;
            }
            knightWeapon.get(allDataInterface.getIdofKnight()).addKnightWeaponInterface(weaponList.getelem(weaponId));
            chooseBow.setText("");
            System.out.println(knightInfo.getknight(allDataInterface.getIdofKnight()).toString());
            knightWeapon.get(allDataInterface.getIdofKnight()).printList();
            allcost+=weaponList.getelem(weaponId).getCost();
            money.setText("Amount of money left - "+amountOfMoney1);
            chooseBow.setText("You choosed "+weaponList.getelem(weaponId).getName());
        }
        knightInfo.cutMoney(allDataInterface.getIdofKnight(), allcost);
        i++;
        //knightInfo.printList();
   }
   @FXML
   Label chooseSword;
    public void buttonChooseSword(ActionEvent event){
        int Id = SwordTable.getSelectionModel().getSelectedIndex();
        Sword elem= SwordTable.getItems().get(Id);
        //System.out.println(elem.toString(1));
        //allDataInterface.setIdofWeapon(Id);
        if(weaponList.getsize()==0) {
            readData.readWeapon(weaponList);
        }
        double amountOfMoney1=knightInfo.getknight(allDataInterface.getIdofKnight()).getAmountOfMoney();
        double allcost=0;
        checksize(allDataInterface.getIdofKnight());
        int weaponId= findid(weaponList,elem);
        if(!isExist(weaponList.getelem(weaponId), knightWeapon.get(allDataInterface.getIdofKnight()))) {
            amountOfMoney1 -= weaponList.getelem(weaponId).getCost();
            if (amountOfMoney1 <= 0){
                error.setText("Not enough money");
                return;
            }
            knightWeapon.get(allDataInterface.getIdofKnight()).addKnightWeaponInterface(weaponList.getelem(weaponId));
            chooseSword.setText("");
            System.out.println(knightInfo.getknight(allDataInterface.getIdofKnight()).toString(allDataInterface.getIdofKnight()));
            knightWeapon.get(allDataInterface.getIdofKnight()).printList();
            allcost+=weaponList.getelem(weaponId).getCost();
            money.setText("Amount of money left - "+amountOfMoney1);
            chooseSword.setText("You choosed "+weaponList.getelem(weaponId).getName());
        }
        knightInfo.cutMoney(allDataInterface.getIdofKnight(), allcost);
        i++;
        //knightInfo.printList();
    }
    @FXML
    Label chooseKnife;
    public void buttonChooseKnife(ActionEvent event){
        int Id = KnifeTable.getSelectionModel().getSelectedIndex();
        Knife elem= KnifeTable.getItems().get(Id);
        //System.out.println(elem.toString(1));
        //allDataInterface.setIdofWeapon(Id);
        if(weaponList.getsize()==0) {
            readData.readWeapon(weaponList);
        }
        double amountOfMoney1=knightInfo.getknight(allDataInterface.getIdofKnight()).getAmountOfMoney();
        double allcost=0;
        checksize(allDataInterface.getIdofKnight());
        int weaponId= findid(weaponList,elem);
        if(!isExist(weaponList.getelem(weaponId), knightWeapon.get(allDataInterface.getIdofKnight()))) {
            amountOfMoney1 -= weaponList.getelem(weaponId).getCost();
            if (amountOfMoney1 <= 0){
                error.setText("Not enough money");
                return;
            }
            knightWeapon.get(allDataInterface.getIdofKnight()).addKnightWeaponInterface(weaponList.getelem(weaponId));
            chooseKnife.setText("");
            System.out.println(knightInfo.getknight(allDataInterface.getIdofKnight()).toString(allDataInterface.getIdofKnight()));
            knightWeapon.get(allDataInterface.getIdofKnight()).printList();
            allcost+=weaponList.getelem(weaponId).getCost();
            money.setText("Amount of money left - "+amountOfMoney1);
            chooseKnife.setText("You choosed "+weaponList.getelem(weaponId).getName());
        }
        knightInfo.cutMoney(allDataInterface.getIdofKnight(), allcost);
        i++;
        //knightInfo.printList();
    }
    @FXML
    Label chooseLance;
    public void buttonChooseLance(ActionEvent event){
        int Id = LanceTable.getSelectionModel().getSelectedIndex();
        Lance elem= LanceTable.getItems().get(Id);
        //System.out.println(elem.toString(1));
        //allDataInterface.setIdofWeapon(Id);
        if(weaponList.getsize()==0) {
            readData.readWeapon(weaponList);
        }
        double amountOfMoney1=knightInfo.getknight(allDataInterface.getIdofKnight()).getAmountOfMoney();
        double allcost=0;
        checksize(allDataInterface.getIdofKnight());
        int weaponId= findid(weaponList,elem);
        if(!isExist(weaponList.getelem(weaponId), knightWeapon.get(allDataInterface.getIdofKnight()))) {
            amountOfMoney1 -= weaponList.getelem(weaponId).getCost();
            if (amountOfMoney1 <= 0){
                error.setText("Not enough money");
                return;
            }
            knightWeapon.get(allDataInterface.getIdofKnight()).addKnightWeaponInterface(weaponList.getelem(weaponId));
            chooseLance.setText("");
            System.out.println(knightInfo.getknight(allDataInterface.getIdofKnight()).toString(allDataInterface.getIdofKnight()));
            knightWeapon.get(allDataInterface.getIdofKnight()).printList();
            allcost+=weaponList.getelem(weaponId).getCost();
            money.setText("Amount of money left - "+amountOfMoney1);
            chooseLance.setText("You choosed "+weaponList.getelem(weaponId).getName());
        }
        knightInfo.cutMoney(allDataInterface.getIdofKnight(), allcost);
        i++;
        //knightInfo.printList();
    }

    @FXML
    Label chooseAxe;
    public void buttonChooseAxe(ActionEvent event){
        int Id = AxeTable.getSelectionModel().getSelectedIndex();
        Axe elem= AxeTable.getItems().get(Id);
        //System.out.println(elem.toString(1));
        //allDataInterface.setIdofWeapon(Id);
        if(weaponList.getsize()==0) {
            readData.readWeapon(weaponList);
        }
        double amountOfMoney1=knightInfo.getknight(allDataInterface.getIdofKnight()).getAmountOfMoney();
        double allcost=0;
        checksize(allDataInterface.getIdofKnight());
        int weaponId= findid(weaponList,elem);
        if(!isExist(weaponList.getelem(weaponId), knightWeapon.get(allDataInterface.getIdofKnight()))) {
            amountOfMoney1 -= weaponList.getelem(weaponId).getCost();
            if (amountOfMoney1 <= 0){
                error.setText("Not enough money");
                return;
            }
            knightWeapon.get(allDataInterface.getIdofKnight()).addKnightWeaponInterface(weaponList.getelem(weaponId));
            chooseAxe.setText("");
            System.out.println(knightInfo.getknight(allDataInterface.getIdofKnight()).toString(allDataInterface.getIdofKnight()));
            knightWeapon.get(allDataInterface.getIdofKnight()).printList();
            allcost+=weaponList.getelem(weaponId).getCost();
            money.setText("Amount of money left - "+amountOfMoney1);
            chooseAxe.setText("You choosed "+weaponList.getelem(weaponId).getName());
        }
        knightInfo.cutMoney(allDataInterface.getIdofKnight(), allcost);
        i++;
        //knightInfo.printList();
    }
    public void BackToSelectKnight(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("SelectKnightforWeapon.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        for(int i=0;i< knightWeapon.size();i++){
            System.out.println(knightInfo.getknight(i).toString(i));
            knightWeapon.get(i).printList();
        }
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
            AllDataInterface.setKnightInfo(knightInfo);
            insert.insertKnightsWeapon(insert.userid(loginlist, AllDataInterface.getUser()), weaponList1, knightWeapon);
            AllDataInterface.setKnightsWeapon(knightWeapon);
            i = 0;
        }
        root = FXMLLoader.load(getClass().getResource("menu2.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Menu of Action");
        stage.setScene(scene);
        stage.show();
    }
    public int findid(WeaponList weaponList,Weapon elem){
        int count=0;
        for(;count<weaponList.getsize();count++){
            if(weaponList.getelem(count).getName().equals(elem.getName())){
                return (count);
            }
        }
        return -1;
    }
    public boolean isExist(Weapon element, WeaponList arrayList){
        for(int i=0;i< arrayList.getsize();i++){
            if(element.getType().equalsIgnoreCase(arrayList.getelem(i).getType())){
                error.setText("You already choose armor of this type,try again");
                return true;}
        }
        return false;
    }
    public void checksize(int i){
        if(knightWeapon.size()<=i){
            for(int k=knightWeapon.size();k<=i;k++){
                knightWeapon.add(k,new WeaponList());
            }
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
            name.setCellValueFactory(new PropertyValueFactory<Knight,String>("name"));
            age.setCellValueFactory(new PropertyValueFactory<Knight,Integer>("age"));
            century.setCellValueFactory(new PropertyValueFactory<Knight,Integer>("century"));
            nationality.setCellValueFactory(new PropertyValueFactory<Knight,String>("nationality"));
            amountOfMoney.setCellValueFactory(new PropertyValueFactory<Knight,Double>("amountOfMoney"));
            bowName.setCellValueFactory(new PropertyValueFactory<Bow,String>("name"));
            bowType.setCellValueFactory(new PropertyValueFactory<Bow,String>("type"));
            bowWeight.setCellValueFactory(new PropertyValueFactory<Bow,Double>("weight"));
            bowCost.setCellValueFactory(new PropertyValueFactory<Bow,Double>("cost"));
            bowDamage.setCellValueFactory(new PropertyValueFactory<Bow,Double>("damage"));
            bowAmountOfArrows.setCellValueFactory(new PropertyValueFactory<Bow,Integer>("amOfArrows"));
            bowTypeOfBowstring.setCellValueFactory(new PropertyValueFactory<Bow,String>("typeOfBowstring"));
            axeName.setCellValueFactory(new PropertyValueFactory<Axe,String>("name"));
            axeCost.setCellValueFactory(new PropertyValueFactory<Axe,Double>("cost"));
            axeType.setCellValueFactory(new PropertyValueFactory<Axe,String>("type"));
            axeDamage.setCellValueFactory(new PropertyValueFactory<Axe,Double>("damage"));
            axeWeight.setCellValueFactory(new PropertyValueFactory<Axe,Double>("weight"));
            axeblade.setCellValueFactory(new PropertyValueFactory<Axe,String>("bladeshape"));
            lanceName.setCellValueFactory(new PropertyValueFactory<Lance,String>("name"));
            lanceCost.setCellValueFactory(new PropertyValueFactory<Lance,Double>("cost"));
            lanceType.setCellValueFactory(new PropertyValueFactory<Lance,String>("type"));
            lanceDamage.setCellValueFactory(new PropertyValueFactory<Lance,Double>("damage"));
            lanceWeight.setCellValueFactory(new PropertyValueFactory<Lance,Double>("weight"));
            lancelength.setCellValueFactory(new PropertyValueFactory<Lance,Integer>("lengthoflance"));
            knifeName.setCellValueFactory(new PropertyValueFactory<Knife,String>("name"));
            knifeCost.setCellValueFactory(new PropertyValueFactory<Knife,Double>("cost"));
            knifeTypeOfWeapon.setCellValueFactory(new PropertyValueFactory<Knife,String>("type"));
            knifeDamage.setCellValueFactory(new PropertyValueFactory<Knife,Double>("damage"));
            knifeWeight.setCellValueFactory(new PropertyValueFactory<Knife,Double>("weight"));
            typeOfKnife.setCellValueFactory(new PropertyValueFactory<Knife,String>("typeofknife"));
            swordName.setCellValueFactory(new PropertyValueFactory<Sword,String>("name"));
            swordCost.setCellValueFactory(new PropertyValueFactory<Sword,Double>("cost"));
            swordType.setCellValueFactory(new PropertyValueFactory<Sword,String>("type"));
            swordDamage.setCellValueFactory(new PropertyValueFactory<Sword,Double>("damage"));
            swordWeight.setCellValueFactory(new PropertyValueFactory<Sword,Double>("weight"));
            swordblade.setCellValueFactory(new PropertyValueFactory<Sword,String>("typeOfBlade"));
    }
}
