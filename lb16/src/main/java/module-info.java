module com.example.lb16 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.lb16 to javafx.fxml;
    exports com.example.lb16;
}