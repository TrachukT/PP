package com.example.maintermprojectjavafx;

import data.Login;
import data.Loginlist;
import database.ReadData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class RegistrationAppl {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    Label error;
    @FXML
    TextField email;
    @FXML
    TextField username;
    @FXML
    TextField password;
    @FXML
    Label registered;
    public void ButtonRegister(ActionEvent event) throws IOException {
        String emailText = email.getText();
        String usernameText = username.getText();
        String passwordText = password.getText();
        System.out.println("fgfgfgfgf\n"+emailText+"\nfplg;flg");
        ReadData readData = new ReadData();
        Loginlist usersdata = new Loginlist();
        readData.readLogins(usersdata);
        Login user = new Login(usernameText,passwordText,emailText);
        if (usersdata.finduser(user)){
            error.setMinWidth(300);
            error.setText("You are already registered.Please login.");
            return;
        }
        if(emailText.equals("") || usernameText.equals("") || passwordText.equals("")){
            error.setMinWidth(300);
            error.setText("You entered not all infotmation.Please fill all fields");
            return;
        }
        if(!usersdata.checkmail(emailText)){
            error.setMinWidth(300);
            error.setText("There is already account with this email");
        }
        else if (!usersdata.checkUsername(usernameText,emailText)){
            error.setMinWidth(300);
            error.setText("This username is already in the base,enter another one");
        }
        else if(!usersdata.finduser(user)){
            usersdata.addLogin(usernameText,passwordText,emailText);
            error.setText("");
            registered.setMinWidth(320);
            registered.setMinHeight(33);
            error.setText("");
            registered.setText("Congratulations!You are registered.\nLog into created account.");
            //switchBack(event);
        }
    }
    public void switchMenuOfActions(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("menu2.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Menu of actions");
        stage.setScene(scene);
        stage.show();
    }
    public void switchBack(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Log into system");
        stage.setScene(scene);
        stage.show();
    }
}
