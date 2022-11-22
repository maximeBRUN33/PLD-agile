module com.agile {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.agile to javafx.fxml;
    exports com.agile;
}
