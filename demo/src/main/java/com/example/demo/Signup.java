package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;


public class Signup {
    @FXML
    private Button btnRegister;
    @FXML
    private Button exit;
    @FXML
    private TextField tffname;
    @FXML
    private TextField tflname;
    @FXML
    private TextField tfusername;
    @FXML
    private TextField tfpass;
    @FXML
    private TextField tfconfirmpass;
    @FXML
    private Label label;

    public void setBtnRegister(ActionEvent event) throws IOException {
        btnRegisteraction();
    }

    public void btnRegisteraction() throws IOException {
        if (tfpass.getText().equals(tfconfirmpass.getText())) {
            registerUser();
            setAlert();
            dashboard();
        } else {
            label.setText("Password does not match.");
        }
    }

    public void registerUser() {
        DatabaseConnection connectnow = new DatabaseConnection();
        Connection connectDB = connectnow.getDblink();

        String firstName = tffname.getText();
        String lastName = tflname.getText();
        String userName = tfusername.getText();
        String password = tfconfirmpass.getText();

        String insertFields = "insert into useraccounts (`First Name`, `Last Name`, `User Name`, `Password`) values('";
        String insertValues = firstName + "','" + lastName + "','" + userName + "','" + password + "')";
        String inserttoRegister = insertFields + insertValues;

        try {
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(inserttoRegister);
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

    public void close(){
        Stage stage = (Stage) exit.getScene().getWindow();
        stage.close();
    }

    protected void dashboard() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Stage newStage = new Stage();
        newStage.setTitle("CUBCS");
        newStage.setScene(scene);
        newStage.show();
        close();
    }

    @FXML
    protected void setAlert() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("User Created");
        alert.setHeaderText("Congratulations!");
        alert.setContentText("New user has been added!");

        if (alert.showAndWait().get() == ButtonType.OK) {
            close();
        }
    }

    @FXML
    protected void setExit(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("You are about to exit the application!");
        alert.setContentText("Are you sure you want to exit the application?");

        if (alert.showAndWait().get() == ButtonType.OK) {
            close();
        }
    }
}
