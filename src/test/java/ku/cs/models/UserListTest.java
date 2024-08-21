package ku.cs.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserListTest {

    @Test
    @DisplayName("User should be found in UserList")
    public void testUserListFindUser() {
        // TODO: add 3 users to UserList
        UserList userList = new UserList();
        userList.addUser("user1", "password1");
        userList.addUser("user2", "password2");
        userList.addUser("user3", "password3");
        // TODO: find one of them
        User user = userList.findUserByUsername("user2");
        // TODO: assert that UserList found User
        String expected = "user2";
        String actual = user.getUsername();
        assertEquals(expected, actual, "UserList should find the user with the correct username");
    }

    @Test
    @DisplayName("User can change password")
    public void testUserCanChangePassword() {
        // TODO: add 3 users to UserList
        UserList userList = new UserList();
        userList.addUser("user1", "password1");
        userList.addUser("user2", "password2");
        userList.addUser("user3", "password3");
        // TODO: change password of one user
        boolean actual = userList.changePassword("user2", "password2", "newPassword2");
        // TODO: assert that user can change password
        assertTrue(actual, "User should be able to change password");

    }

    @Test
    @DisplayName("User with correct password can login")
    public void testUserListShouldReturnObjectIfUsernameAndPasswordIsCorrect() {
        // TODO: add 3 users to UserList
        UserList userList = new UserList();
        userList.addUser("user1", "password1");
        userList.addUser("user2", "password2");
        userList.addUser("user3", "password3");
        // TODO: call login() with correct username and password
        User actual = userList.login("user2", "password2");
        // TODO: assert that User object is found
        assertEquals("user2", actual.getUsername(), "Username should match the expected username");
    }

    @Test
    @DisplayName("User with incorrect password cannot login")
    public void testUserListShouldReturnNullIfUsernameAndPasswordIsIncorrect() {
        // TODO: add 3 users to UserList
        UserList userList = new UserList();
        userList.addUser("user1", "password1");
        userList.addUser("user2", "password2");
        userList.addUser("user3", "password3");
        // TODO: call login() with incorrect username or incorrect password
        User actual = userList.login("user2", "wrongPassword");
        // TODO: assert that the method return null
        assertNull(actual, "Method should return null when username or password is incorrect");
    }

}