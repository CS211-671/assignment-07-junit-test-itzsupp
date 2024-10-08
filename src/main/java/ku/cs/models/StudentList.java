package ku.cs.models;

import java.util.ArrayList;

public class StudentList {
    private static ArrayList<Student> students;

    public StudentList() {
        students = new ArrayList<>();
    }

    public static void addNewStudent(String id, String name) {
        id = id.trim();
        name = name.trim();
        if (!id.isEmpty() && !name.isEmpty()) {
            Student exist = findStudentById(id);
            if (exist == null) {
                students.add(new Student(id, name));
            }
        }
    }

    public static void addNewStudent(String id, String name, double score) {
        id = id.trim();
        name = name.trim();
        if (!id.isEmpty() && !name.isEmpty()) {
            Student exist = findStudentById(id);
            if (exist == null) {
                students.add(new Student(id, name, score));
            }
        }
    }

    public static Student findStudentById(String id) {
        for (Student student : students) {
            if (student.isId(id)) {
                return student;
            }
        }
        return null;
    }

    public static void giveScoreToId(String id, double score) {
        Student exist = findStudentById(id);
        if (exist != null) {
            exist.addScore(score);
        }
    }

    public static String viewGradeOfId(String id) {
        Student exist = findStudentById(id);
        if (exist != null) {
            return exist.grade();
        }
        return null;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }
}