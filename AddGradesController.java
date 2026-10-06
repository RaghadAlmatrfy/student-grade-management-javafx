package com.mycompany.application;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AddGradesController {

    @FXML
    private ComboBox<String> studentComboBox;

    @FXML
    private TextField courseField;

    @FXML
    private TextField scoreField;

    @FXML
    public void initialize() {
        loadStudentIDs();
    }

    private void loadStudentIDs() {
        File file = new File("students.txt");

        if (!file.exists()) {
            return;
        }

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");

                if (parts.length > 0) {
                    studentComboBox.getItems().add(parts[0]);
                }
            }
        } catch (FileNotFoundException e) {
            showAlert(AlertType.ERROR, "Error", "Failed to read students file.");
        }
    }

    @FXML
    private void handleSaveGrade() {
        String selectedStudent = studentComboBox.getValue();
        String course = courseField.getText().trim();
        String scoreText = scoreField.getText().trim();

        if (selectedStudent == null || course.isEmpty() || scoreText.isEmpty()) {
            showAlert(AlertType.WARNING, "Warning", "Please fill in all fields.");
            return;
        }

        try {
            double score = Double.parseDouble(scoreText);

            if (score < 0 || score > 100) {
                showAlert(AlertType.WARNING, "Warning", "The score must be between 0 and 100.");
                return;
            }

            Grade gradeObj = new Grade(selectedStudent, course, score);

            try (FileWriter fw = new FileWriter("grades.txt", true); BufferedWriter bw = new BufferedWriter(fw); PrintWriter out = new PrintWriter(bw)) {

                out.println(gradeObj.toString());

                showAlert(AlertType.INFORMATION, "Success", "Grade saved successfully!");

                courseField.clear();
                scoreField.clear();
                studentComboBox.setValue(null);

            } catch (IOException e) {
                showAlert(AlertType.ERROR, "Error", "An error occurred while writing to the file.");
            }

        } catch (NumberFormatException e) {
            showAlert(AlertType.WARNING, "Warning", "Please enter a valid numerical value for the score.");
        }
    }

    @FXML
    private void handleBack() throws IOException {
        App.setRoot("Dashboard");
    }

    private void showAlert(AlertType type, String title, String content) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
