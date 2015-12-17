package com.troshchuk.javaeelabs.lab3.dao.jpa;

import com.troshchuk.javaeelabs.lab3.dao.UserDAO;
import com.troshchuk.javaeelabs.lab3.domain.User;

import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

public class UserDAOImpl extends GenericDAO<User, Long> implements UserDAO {
    public static final String PROCEDURE_NAME = "getEmail";

    public UserDAOImpl() {
        super(User.class);
    }

    public String getEmail(Long id) {
        String email =  null;
        StoredProcedureQuery storedProcedure = em.createStoredProcedureQuery(PROCEDURE_NAME);

        storedProcedure.registerStoredProcedureParameter("USR_ID", Long.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter("EM", String.class, ParameterMode.OUT);
        storedProcedure.setParameter("USR_ID", id);
// execute SP
        storedProcedure.execute();
        email = (String) storedProcedure.getOutputParameterValue("EM");;
        return email;
    }
}
