# 🎓 Student Grade Management System (JavaFX)

A desktop application built with **Java, JavaFX and FXML** for managing students and their grades. An admin can log in, add students, record course grades, browse the student list and view a statistics report. Data is stored in simple text files.

---

## ✨ Features

| Screen | What it does |
|---|---|
| **Login** | Admin authentication before accessing the system |
| **Dashboard** | Side menu to navigate between all features |
| **Add Student** | Save a new student (ID, name, major) with empty-field validation |
| **Add Grades** | Pick a student from a dropdown, enter course and score — validates the score is numeric and between 0 and 100 |
| **View Students** | Table view of all registered students |
| **Reports** | Total number of grades, average, highest and lowest score |

---

## 🛠️ Tech Stack

- **Java 11+** with **JavaFX 21** (controls + FXML)
- **Maven** with `javafx-maven-plugin`
- **FXML** for UI layouts and **CSS** for styling
- **File I/O** (`students.txt`, `grades.txt`) for data persistence

### Concepts Applied
- MVC-style separation: FXML views + Java controllers + model classes (`Student`, `Grade`)
- Encapsulation with getters/setters and `toString()` for serialization
- Event handling with `@FXML`
- Input validation and exception handling (`NumberFormatException`, `IOException`)
- Scene navigation through a single `App.setRoot()` method
- `TableView` binding with `PropertyValueFactory` and `ObservableList`

---

## 📁 Project Structure

```
├── pom.xml
├── students.txt                  # Student records: id,name,major
├── grades.txt                    # Grade records: studentId,course,score
└── src/main/
    ├── java/
    │   ├── module-info.java
    │   └── com/mycompany/application/
    │       ├── App.java                  # Entry point & scene navigation
    │       ├── Login.java
    │       ├── Dashboard.java
    │       ├── AddStudentController.java
    │       ├── AddGradesController.java
    │       ├── ViewStudents.java
    │       ├── Reports.java
    │       ├── Student.java              # Model
    │       └── Grade.java                # Model
    └── resources/
        ├── styles/addstudent.css
        └── com/mycompany/application/   # FXML views
            ├── Login.fxml
            ├── Dashboard.fxml
            ├── AddStudent.fxml
            ├── AddGrade.fxml
            ├── viewStudents.fxml
            └── Reports.fxml
```

---

## ▶️ How to Run

**Requirements:** JDK 11 or later and Maven (or open it directly in NetBeans / IntelliJ).

```bash
mvn clean javafx:run
```

**Demo login**

| Username | Password |
|---|---|
| `admin` | `1234` |

> The text files are read from the working directory, so run the app from the project root.

---

## 🚀 Possible Improvements
- Store data in a database instead of text files
- Edit / delete students and grades
- Per-student and per-course reports
- Secure authentication instead of hard-coded credentials
