module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires com.dlsc.formsfx;
    requires java.sql;
    requires java.net.http;

    opens com.example.demo to javafx.fxml;
    exports com.example.demo;
}