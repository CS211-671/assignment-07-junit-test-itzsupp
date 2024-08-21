package ku.cs.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentListTest {

    StudentList s1;

    @BeforeEach
    public void init() {
        s1 = new StudentList();
        StudentList.addNewStudent("6610451168", "P", 85.0);
        StudentList.addNewStudent("6610450351", "Maggy", 50.0);

    }

    @Test
    @DisplayName("ทดสอบการเพิ่มนิสิต")
    public void testAddNewStudentSuccess() {
        Student student = StudentList.findStudentById("6610451168");
        assertNotNull(student);
        assertEquals("6610451168", student.getId());
        assertEquals("P", student.getName());
    }

    @Test
    @DisplayName("ทดสอบการค้นหาด้วยรหัสนิสิต")
    public void testFindStudentById() {
        Student student = StudentList.findStudentById("6610451168");

        assertNotNull(student);
        assertEquals("6610451168", student.getId());
        assertEquals("P", student.getName());
    }

    @Test
    @DisplayName("ทดสอบระบบให้คะแนน")
    public void testGiveScoreToExistingStudent() {
        StudentList.giveScoreToId("6610451168", 85.0);

        Student student = StudentList.findStudentById("6610451168");
        assertNotNull(student);

    }

    @Test
    @DisplayName("การทดสอบดูเกรดด้วยรหัสนิสิต")
    public void testViewGradeOfExistingStudent() {
        String grade = StudentList.viewGradeOfId("6610451168");

        assertNotNull(grade);
        assertEquals("A", grade);
    }
}