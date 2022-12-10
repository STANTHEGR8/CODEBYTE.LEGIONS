package com.example.demo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class Dashboard implements Initializable {
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
    @FXML
    private TextField search;
    //Table
    @FXML
    private TableView<table> tableView;
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
    private TableColumn<table, String> bloodgroupColumn;

    public Connection getConnection(){
        try {
            DatabaseConnection connectNow = new DatabaseConnection();
            Connection con = connectNow.getDblink();
            return con;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
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
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("dashboard1.fxml"));
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

    public void btnSearchAction(ActionEvent event){
    filteredList();
    }

    public void btnDeleteAlert(ActionEvent event) {
        //Confirmation Alert.
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete");
        alert.setHeaderText("Delete this member from the list?");
        alert.setContentText("Are you sure?");

        if (alert.showAndWait().get() == ButtonType.OK) {


        //Database Connection
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection con = connectNow.getDblink();

        String FullName = tffullname.getText();

        String insertFields = "DELETE FROM `login`.`member_info` WHERE (`FullName` = '" + FullName + "');";

        executeQuery(insertFields);
        showList();
        tfClear();


        try{
            Statement statement = con.createStatement();
            statement.executeUpdate(insertFields);
        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
        }
    }
    //Used in showList()
    public ObservableList<table> getList(){
        ObservableList<table> list = FXCollections.observableArrayList();

        DatabaseConnection connectNow = new DatabaseConnection();

        Connection con = connectNow.getDblink();

        String query = "select `FullName`, `UID`, `Email`,`Mobile`, `BloodGroup` from member_info";

        Statement st;
        ResultSet rs;

        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            table tv;
            while (rs.next()){
                tv = new table(rs.getString("FullName"), rs.getInt("UID"), rs.getString("Email"), rs.getInt("Mobile"), rs.getString("BloodGroup"));
                list.add(tv);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
            return list;
    }
    public void showList(){
        ObservableList<table> list = getList();

        nameColumn.setCellValueFactory(new PropertyValueFactory<table, String>("name"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<table, String>("email"));
        mobileColumn.setCellValueFactory(new PropertyValueFactory<table, Integer>("mobile"));
        uidColumn.setCellValueFactory(new PropertyValueFactory<table, Integer>("uid"));
        bloodgroupColumn.setCellValueFactory(new PropertyValueFactory<table, String>("bloodGroup"));

        tableView.setItems(list);
    }

    public void filteredList(){
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection con = connectNow.getDblink();

        ObservableList<table> list = getList();

        nameColumn.setCellValueFactory(new PropertyValueFactory<table, String>("name"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<table, String>("email"));
        mobileColumn.setCellValueFactory(new PropertyValueFactory<table, Integer>("mobile"));
        uidColumn.setCellValueFactory(new PropertyValueFactory<table, Integer>("uid"));
        bloodgroupColumn.setCellValueFactory(new PropertyValueFactory<table, String>("bloodGroup"));

        tableView.setItems(list);

        FilteredList<table> filteredData = new FilteredList<>(list, b -> true);

        search.textProperty().addListener((observable, oldvalue, newvalue) -> {
            filteredData.setPredicate(table -> {
                if (newvalue.isEmpty() || newvalue.isBlank() || newvalue == null ){
                    return true;
                };

                String searchKeyword = newvalue.toLowerCase();

                if (table.getName().toLowerCase().indexOf(searchKeyword) != -1){
                    return true;
                } else if (table.getEmail().toLowerCase().indexOf(searchKeyword) != -1) {
                    return true;
                } else if (table.getBloodGroup().toLowerCase().indexOf(searchKeyword) != -1) {
                    return true;
                } else if (table.getUid().toString().indexOf(searchKeyword) != -1) {
                    return true;
                } else if (table.getMobile().toString().indexOf(searchKeyword) != -1) {
                    return true;
                } else
                    return false;
            });
        });

        SortedList<table> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tableView.comparatorProperty());
        tableView.setItems(sortedData);
    }
    private void executeQuery(String query) {
        Connection con = getConnection();
        Statement st;
        try{
            st = con.createStatement();
            st.executeUpdate(query);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public void setBtnAdd(ActionEvent event){
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection con = connectNow.getDblink();

        String FullName = tffullname.getText();
        String Email = tfemail.getText();
        String Mobile = tfmobile.getText();
        String UID = tfuid.getText();
        String BloodGroup = tfbloodgroup.getText();

        String insertFields = "insert into member_info(FullName, Email, UID, Mobile, BloodGroup) values('";
        String insertValues = FullName + "','" + Email + "','" + UID + "','" + Mobile + "','" + BloodGroup + "')";
        String insertDB = insertFields + insertValues;

        if (FullName.isEmpty() || Email.isEmpty() || Mobile.isEmpty() || UID.isEmpty() || BloodGroup.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please fill all the data in the textfield.");
            alert.showAndWait();

        } else {
        executeQuery(insertDB);
        showList();
        tfClear();
        }
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
        alert.setContentText("New member added to the list.");

        if (alert.showAndWait().get() == ButtonType.OK) {
        }
    }

    public void setTableView(TableView<table> tableView) {
        this.tableView = tableView;
    }

    public void tfClear(){
        tffullname.clear();
        tfemail.clear();
        tfmobile.clear();
        tfuid.clear();
        tfbloodgroup.clear();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showList();
    }

    public void getItem(javafx.scene.input.MouseEvent mouseEvent) {
        Integer index;
        index = tableView.getSelectionModel().getSelectedIndex();
        if(index <= -1){
            return;
        }
        tffullname.setText(nameColumn.getCellData(index).toString());
        tfuid.setText(uidColumn.getCellData(index).toString());
        tfemail.setText(emailColumn.getCellData(index).toString());
        tfmobile.setText(mobileColumn.getCellData(index).toString());
        tfbloodgroup.setText(bloodgroupColumn.getCellData(index).toString());
    }
}