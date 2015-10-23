package com.troshchuk.photoLibrary.dao;

import com.troshchuk.photoLibrary.domain.Role;
import com.troshchuk.photoLibrary.domain.User;

import java.util.Set;

public interface UserDAO extends Operation<User, Long> {
    String getEmail(Long id);
}
