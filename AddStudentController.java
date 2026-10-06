package com.mycompany.application;

import java.io.FileWriter;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;

public class AddStudentController {

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtMajor;

    @FXML
    private void saveStudent(ActionEvent event) {

        String id = txtId.getText();
        String name = txtName.getText();
        String major = txtMajor.getText();

        if (id.isEmpty() || name.isEmpty() || major.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Please fill all fields");
            alert.show();
            return;
        }

        try {
            FileWriter writer = new FileWriter("students.txt", true);
            writer.write(id + "," + name + "," + major + "\n");
            writer.close();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Student saved successfully");
            alert.showAndWait();

            App.setRoot("Dashboard");

        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Error saving student");
            alert.show();
        }
    }
}
