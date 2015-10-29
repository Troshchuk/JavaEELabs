package com.troshchuk.javaeelabs.lab1.dao.impl;

import com.troshchuk.javaeelabs.lab1.utils.DatabaseConnection;
import com.troshchuk.javaeelabs.lab1.dao.UserDAO;
import com.troshchuk.javaeelabs.lab1.domain.User;

import java.sql.CallableStatement;

public class UserDAOImpl extends GenericDAO<User, Long> implements UserDAO {

    public UserDAOImpl() {
        super(User.class);
    }

    public String getEmail(Long id) {
        String email =  null;
        try {
            con = DatabaseConnection.getConnection();
            if (con != null) {
                String sql = "{call getEmail (?, ?)}";
                CallableStatement stmt = con.prepareCall(sql);
                stmt.setLong(1, id);
                stmt.registerOutParameter(2, java.sql.Types.VARCHAR);
                stmt.execute();
                email = stmt.getString(2);
            }
        } catch (Exception e) {
            rollback();
        } finally {
            closeConnection();
        }
        return email;
    }
}
