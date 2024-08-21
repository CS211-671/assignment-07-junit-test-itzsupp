package ku.cs.models;

import at.favre.lib.crypto.bcrypt.BCrypt;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    @DisplayName("Password should not store in plain text")
    public void testPasswordIsNotStoreInPlainText() {
        User user = new User("user01", "plain-p@ssw0rd");
        String actual = user.getPassword();
        String unexpected = "plain-p@ssw0rd";
        assertNotEquals(unexpected, actual);
    }

    @Test
    @DisplayName("Password should be verified by plain text")
    public void testPasswordShouldBeVerified() {
        User user = new User("user01", "plain-p@ssw0rd");
        boolean actual = user.validatePassword("plain-p@ssw0rd");
        assertTrue(actual);
    }

    @Test
    @DisplayName("ทดสอบชื่อผู้ใช้งาน")
    void testIsUsername() {
        User user = new User("user01");

        assertTrue(user.isUsername("user01"), "Username should match");
        assertFalse(user.isUsername("wronguser"), "Username should not match");
    }

    @Test
    @DisplayName("ทดสอบรหัสผู้ใช้งาน")
    void testSetPassword() {
        User user = new User("ีuser01");
        String rawPassword = "1234";

        user.setPassword(rawPassword);
        String hashedPassword = user.getPassword();

        assertNotEquals(rawPassword, hashedPassword, "Raw password should not match the hashed password");

        BCrypt.Result result = BCrypt.verifyer().verify(rawPassword.toCharArray(), hashedPassword);
        assertTrue(result.verified, "Hashed password should match the original password");
    }

    @Test
    void testValidatePassword() {
        // Arrange
        String rawPassword = "1234";
        User user = new User("user01", rawPassword);

        // Act & Assert
        assertTrue(user.validatePassword(rawPassword), "Password validation should succeed for the correct password");
        assertFalse(user.validatePassword("wrongPassword"), "Password validation should fail for an incorrect password");
    }

}