module com.example.capstone {
    requires javafx.controls;
    requires javafx.fxml;
    requires junit;


    opens com.example.capstone to javafx.fxml;
    exports com.example.capstone;
    exports com.example.capstone.ships;
    opens com.example.capstone.ships to javafx.fxml;
}