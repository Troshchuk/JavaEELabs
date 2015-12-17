package com.troshchuk.javaeelabs.lab3.dao;

import com.troshchuk.javaeelabs.lab3.dao.jpa.UserDAOImpl;
import com.troshchuk.javaeelabs.lab3.domain.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class UserDAOTest {
    private com.troshchuk.javaeelabs.lab3.dao.UserDAO userDAO = new UserDAOImpl();
    private long id;
    private String email = "example@example.com";

    @Before
    public void testCreate() throws Exception {
        User user = new User(email);
        User newUser = userDAO.create(user);
        id = newUser.getId();
        assertTrue(newUser.getId() > 0);
    }

    @Test
    public void testRead() throws Exception {
        User user = userDAO.read(id);
        assertNotNull(user);
        assertEquals(id, user.getId());
        assertEquals(email, user.getEmail());
    }

    @Test
    public void testUpdate() throws Exception {
        String newEmail = "example@ukr.net";
        User user = new User(newEmail);
        user.setId(id);
        assertTrue(userDAO.update(user));
        assertEquals(newEmail, userDAO.read(id).getEmail());
    }

    @Test
    public void testGetEmail() throws SQLException {
        assertEquals(userDAO.getEmail(id), email);
    }

    @After
    public void testDelete() throws Exception {
        userDAO.delete(id);
        assertNull(userDAO.read(id));
    }
}