package com.example.maintermprojectjavafx;

import data.AllDataInterface;
import data.EquipList;
import data.KnightInfo;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import knight.Knight;
import org.w3c.dom.Text;

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
    private AllDataInterface allDataInterface=new AllDataInterface();
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
    public void buttonGetData(ActionEvent event) throws  IOException{
        ReadData readData=new ReadData();
        ObservableList<Knight> equipment = readData.readKnightsInterface();
        knightsTable.setItems(equipment);
    }
    public void buttonChooseKnight(ActionEvent event) throws  IOException{
        int IdW = knightsTable.getSelectionModel().getSelectedIndex();
        this.allDataInterface.setIdofKnight(IdW);
        System.out.println(this.allDataInterface.getIdofKnight());
        root = FXMLLoader.load(getClass().getResource("SelectEquipment.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Select equipment");
        stage.setScene(scene);
        stage.show();
    }
    public void BackToSelectKnight(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("SelectKnightforEquip.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Select knight");
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
        String nameT =  nameText.getText();
        int ageT = Integer.parseInt(ageText.getText());
        int centuryT = Integer.parseInt(centuryText.getText());
        String nationalityT = nationalityText.getText();
        double amountofmoneyT = Double.parseDouble(amountofmoneyText.getText());
        KnightInfo knightInfo=new KnightInfo();
        knightInfo.addKnightInterface(nameT, ageT, centuryT, nationalityT, amountofmoneyT);
        BackToSelectKnight(event);
        //buttonGetData(event);
    }
    public void buttonGetDataEquipment(ActionEvent event) throws IOException{
        ReadData readData=new ReadData();
        ObservableList<Equipment> equipment = readData.readEquipForTable();
        EquipTable.setItems(equipment);
    }
    public void chooseEquipment(ActionEvent event){
        int Id = EquipTable.getSelectionModel().getSelectedIndex();
        //allDataInterface.setIdofEquipment(Id);
        List<EquipList> equipLists=new ArrayList<>();
        System.out.println("\nfgfg\n"+this.allDataInterface.getIdofKnight());
//        equipUpdateLabel.setVisible(true);
//        costText.setVisible(true);
    }
    public void buttonBackToMenu(ActionEvent event) throws IOException {
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
        nameEquip.setCellValueFactory(new PropertyValueFactory<Equipment,String>("name"));
        materialEquip.setCellValueFactory(new PropertyValueFactory<Equipment,String>("material"));
        costEquip.setCellValueFactory(new PropertyValueFactory<Equipment,Double>("cost"));
        weightEquip.setCellValueFactory(new PropertyValueFactory<Equipment,Double>("weight"));
        strengthEquip.setCellValueFactory(new PropertyValueFactory<Equipment,Double>("strength"));
        typeofarmorEquip.setCellValueFactory(new PropertyValueFactory<Equipment,String>("typeofarmour"));
    }
}
