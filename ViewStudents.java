package com.mycompany.application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ViewStudents {

    @FXML
    private TableView<Student> studentsTable;

    @FXML
    private TableColumn<Student, String> idColumn;

    @FXML
    private TableColumn<Student, String> nameColumn;

    @FXML
    private TableColumn<Student, String> majorColumn;

    @FXML
    public void initialize() {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        majorColumn.setCellValueFactory(new PropertyValueFactory<>("major"));

        loadStudents();
    }

    @FXML
    private void loadStudents() {
        ObservableList<Student> students = FXCollections.observableArrayList();

        try (BufferedReader reader = new BufferedReader(new FileReader("students.txt"))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");

                if (data.length == 3) {
                    String id = data[0].trim();
                    String name = data[1].trim();
                    String major = data[2].trim();

                    students.add(new Student(id, name, major));
                }
            }

            studentsTable.setItems(students);

        } catch (IOException e) {
            System.out.println("Error reading students file");
        }
    }

    @FXML
    private void handleBack() throws IOException {
        App.setRoot("Dashboard");
    }
}
