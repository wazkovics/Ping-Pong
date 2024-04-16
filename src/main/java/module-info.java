module com.example.week4 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.j;


    opens com.example.week4 to javafx.fxml;
    exports com.example.week4;
    exports com.example.week4.DatabaseManager;
    opens com.example.week4.DatabaseManager to javafx.fxml;
}