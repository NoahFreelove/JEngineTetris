module com.jenginetetris {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.jenginetetris to javafx.fxml;
    exports com.jenginetetris;
}