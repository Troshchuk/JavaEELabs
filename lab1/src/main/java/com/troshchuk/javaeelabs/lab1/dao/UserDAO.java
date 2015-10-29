package com.troshchuk.javaeelabs.lab1.dao;

import com.troshchuk.javaeelabs.lab1.domain.User;

public interface UserDAO extends Operation<User, Long> {
    String getEmail(Long id);
}
