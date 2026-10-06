package com.mycompany.application;

import java.io.IOException;
import javafx.fxml.FXML;

public class Dashboard {

    @FXML
    private void openAddStudent() throws IOException {
        App.setRoot("AddStudent");
    }

    @FXML
    private void openAddGrades() throws IOException {
        App.setRoot("AddGrade");
    }

    @FXML
    private void openViewStudents() throws IOException {
        App.setRoot("viewStudents");
    }

    @FXML
    private void openReports() throws IOException {
        App.setRoot("Reports");
    }

    @FXML
    private void logout() throws IOException {
        App.setRoot("Login");
    }
}
