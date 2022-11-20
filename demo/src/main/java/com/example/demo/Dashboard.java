package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ResourceBundle;

public class Dashboard {
    //Button
    @FXML
    private Button btnClose;
    //Textfields
    @FXML
    private TextField tffullname;
    @FXML
    private TextField tfemail;
    @FXML
    private TextField tfuid;
    @FXML
    private TextField tfmobile;
    @FXML
    private TextField tfbloodgroup;
    //Table
    @FXML
    private TableView<table> table;
    //Table Columns
    @FXML
    private TableColumn<table, String> nameColumn;
    @FXML
    private TableColumn<table, String> emailColumn;
    @FXML
    private TableColumn<table, Integer> uidColumn;
    @FXML
    private TableColumn<table, Integer> mobileColumn;
    @FXML
    private TableColumn<table, String> bloodgroup;

    public void initialize(URL url, ResourceBundle resourceBundle){
        nameColumn.setCellValueFactory(new PropertyValueFactory<table, String>("name"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<table, String>("email"));
        uidColumn.setCellValueFactory(new PropertyValueFactory<table, Integer>("uid"));
        mobileColumn.setCellValueFactory(new PropertyValueFactory<table, Integer>("mobile"));
        bloodgroup.setCellValueFactory(new PropertyValueFactory<table, String>("bloodgroup"));

    }

    //Close button action method.
    public void setBtnClose(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("You are about to exit the application!");
        alert.setContentText("Are you sure you want to exit the application?");

        if (alert.showAndWait().get() == ButtonType.OK) {
            close();
        }
    }

    public void close() {
        Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();
    }

    public void setBtnHome(ActionEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 600, 400);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stage stage = new Stage();
        stage.setTitle("CUBCS");
        stage.setScene(scene);
        stage.show();
        close();
    }

    public void btnDeleteAlert(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete");
        alert.setHeaderText("Delete this member from the list?");
        alert.setContentText("Are you sure?");

        if (alert.showAndWait().get() == ButtonType.OK) {
        }
    }

    public void setBtnAdd(ActionEvent event){
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection con = connectNow.getDbLink2();

        String FullName = tffullname.getText();
        String Email = tfemail.getText();
        String Mobile = tfmobile.getText();
        String UID = tfuid.getText();
        String BloodGroup = tfbloodgroup.getText();
        System.out.println(FullName);

        String insertFields = "INSERT INTO member_info(FullName, Email, UID, Mobile, BloodGroup) VALUES('";
        String insertValues = FullName + "','" + Email + "','" + Mobile + "','" + UID + "','" + BloodGroup + "')";
        String insertDB = insertFields + insertValues;

        try{
            Statement statement = con.createStatement();
            statement.executeUpdate(insertDB);
            btnAddAlert();

        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }

    private void btnAddAlert() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText("New member added!");
        alert.setContentText("New member is enlisted to the list.");

        if (alert.showAndWait().get() == ButtonType.OK) {
        }
    }
}