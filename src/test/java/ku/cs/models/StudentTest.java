package ku.cs.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    Student s1;

    @BeforeEach
    void init(){
        s1 = new Student("6610451168", "P");
    }

    @Test
    @DisplayName("ทดสอบการคิดเกรด")
    void testAddScore(){
        //Student s1 = new Student("6610451168", "P");
        assertEquals(0, s1.getScore());
        s1.addScore(70);
        assertEquals(70, s1.getScore());
        s1.addScore(10);
        assertEquals(80, s1.getScore());
    }

    @Test
    @DisplayName("ทดสอบการเพิ่มคะแนน 60.8 คะแนน และให้ Object คำนวนเกรดออกมา")
    void testCalculateGrade(){
        Student s1 = new Student("6610451168", "P");
        s1.addScore(60.8);
        assertEquals("C", s1.grade());
    }

    @Test
    @DisplayName("ทดสอบการเปลี่ยนชื่อ")
    void testChangeNameWithValidName() {
        Student s1 = new Student("6610451168", "P");
        s1.changeName("John");
        assertEquals("John", s1.getName());
    }

    @Test
    @DisplayName("ทดสอบการตรวจรหัสนิสิต")
    void testIsId(){
        Student s1 = new Student("6610451168", "P");
        assertTrue(s1.isId("6610451168"));
    }

}