package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HelloController {
    @FXML
    private Button btnExit;
    @FXML
    private TextField tfUserName;
    @FXML
    private PasswordField pwPassword;
    @FXML
    private Button btncreateacc;

    //Exit button action method.
    @FXML
    protected void setBtnExit(ActionEvent event){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("You are about to exit the application!");
        alert.setContentText("Are you sure you want to exit the application?");

        if(alert.showAndWait().get() == ButtonType.OK){
            close();
        }
    }
    public void close(){
        Stage stage = (Stage) btnExit.getScene().getWindow();
        stage.close();
    }
    //Login button action method.
    @FXML
    protected void setBtnLogin(ActionEvent event){

        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getDblink();

        String verifyLogin = "SELECT count(1) FROM useraccounts WHERE `User Name`= '" + tfUserName.getText() + "' AND Password = '" + pwPassword.getText() + "'";

        try {
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);

            while (queryResult.next()){
                if (queryResult.getInt(1) == 1){
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("WELCOME!!!");
                    alert.setHeaderText("Username and password correct!");
                    alert.showAndWait();
                    dashboard();
                }
                else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Please try again.");
                    alert.showAndWait();
                }
            }
    } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    //Main Dashboard display and close previous.
    private void dashboard() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("dashboard1.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Stage newStage = new Stage();
        newStage.setTitle("CUBCS");
        newStage.setScene(scene);
        newStage.show();
        close();
    }
    @FXML
    //Action of Create Account button taking to signup page
    private void setBtncreateacc(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("signup.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Stage newStage = new Stage();
        newStage.setTitle("CUBCS");
        newStage.setScene(scene);
        newStage.show();
        close();
    }
}