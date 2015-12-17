package com.troshchuk.javaeelabs.lab3.dao;

import com.troshchuk.javaeelabs.lab1.dao.Operation;
import com.troshchuk.javaeelabs.lab3.domain.User;

public interface UserDAO extends Operation<User, Long> {
    String getEmail(Long id);
}
