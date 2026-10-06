module com.mycompany.application {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.application to javafx.fxml;
    exports com.mycompany.application;
}
