module com.example.maintermprojectjavafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.mail;
    requires java.sql;
    requires maven.plugin.api;


    opens com.example.maintermprojectjavafx to javafx.fxml;
    opens knight to javafx.fxml;
    opens database to javafx.fxml;
    opens data to javafx.fxml;
    opens commands to javafx.fxml;
    exports knight;
    exports database;
    exports data;
    exports commands;
    exports com.example.maintermprojectjavafx;
}