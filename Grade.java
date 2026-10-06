package com.mycompany.application;
public class Grade {
    private String studentId;
    private String courseName;
    private double score;

    public Grade(String studentId, String courseName, double score) {
        this.studentId = studentId;
        this.courseName = courseName;
        this.score = score;
    }

    public String getStudentId() { 
        return studentId; 
    }
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getCourseName() {
        return courseName;
    }
    public void setCourseName(String courseName) {
        this.courseName = courseName; 
    }

    public double getScore() { 
        return score; 
    }
    public void setScore(double score) { 
        this.score = score; 
    }
    
    @Override
    public String toString() {
        return studentId + "," + courseName + "," + score;
    }
}

