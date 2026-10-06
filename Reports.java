package com.mycompany.application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import java.util.Locale;

public class Reports {

    @FXML
    private Label totalGradesLabel;

    @FXML
    private Label averageLabel;

    @FXML
    private Label highestLabel;

    @FXML
    private Label lowestLabel;

    @FXML
    public void initialize() {
        loadReport();
    }

    private void loadReport() {
        int totalGrades = 0;
        double totalScore = 0;
        double highest = Double.MIN_VALUE;
        double lowest = Double.MAX_VALUE;

        try (BufferedReader reader = new BufferedReader(new FileReader("grades.txt"))) {

            String line;

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");

                if (data.length == 3) {
                    double score = Double.parseDouble(data[2].trim());

                    totalGrades++;
                    totalScore += score;

                    if (score > highest) {
                        highest = score;
                    }

                    if (score < lowest) {
                        lowest = score;
                    }
                }
            }

            if (totalGrades > 0) {
                double average = totalScore / totalGrades;

                totalGradesLabel.setText("Total Grades: " + totalGrades);

                averageLabel.setText(
                        "Average Grade: "
                        + String.format(Locale.US, "%.2f", average)
                );

                highestLabel.setText("Highest Grade: " + highest);
                lowestLabel.setText("Lowest Grade: " + lowest);
            } else {
                totalGradesLabel.setText("No grades found");
                averageLabel.setText("Average Grade: -");
                highestLabel.setText("Highest Grade: -");
                lowestLabel.setText("Lowest Grade: -");
            }

        } catch (IOException e) {
            totalGradesLabel.setText("grades.txt file not found");
            averageLabel.setText("Average Grade: -");
            highestLabel.setText("Highest Grade: -");
            lowestLabel.setText("Lowest Grade: -");
        }
    }

    @FXML
    private void handleBack() throws IOException {
        App.setRoot("Dashboard");
    }

}
