package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.io.IOException;

public class Dashboard1 {
    @FXML
    private Button memberList;
    @FXML
    private Button exit;
    @FXML
    private Button notice;
    @FXML
    private Button importantLinks;

    @FXML
    protected void setMemberList(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("dashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Stage newStage = new Stage();
        newStage.setTitle("CUBCS");
        newStage.setScene(scene);
        newStage.show();
        close();
    }

    @FXML
    protected void setNotice(ActionEvent event) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("notice.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Stage newStage = new Stage();
        newStage.setTitle("CUBCS");
        newStage.setScene(scene);
        newStage.show();
        close();
    }

    @FXML
    protected void setImportantLinks(ActionEvent event) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("links.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Stage newStage = new Stage();
        newStage.setTitle("CUBCS");
        newStage.setScene(scene);
        newStage.show();
        close();
    }

    @FXML
    protected void setexit(ActionEvent event){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("You are about to exit the application!");
        alert.setContentText("Are you sure you want to exit the application?");

        if (alert.showAndWait().get() == ButtonType.OK) {
            close();
        }
    }
        public void close(){
            Stage stage = (Stage) exit.getScene().getWindow();
            stage.close();
        }
    }
