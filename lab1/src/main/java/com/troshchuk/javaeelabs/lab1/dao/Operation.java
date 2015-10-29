package com.troshchuk.javaeelabs.lab1.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

public interface Operation<T, K extends Serializable> {
    K create(T newInstance);
    T read(K id);
    boolean update(T transientObject);
    boolean delete(K persistentObject);
    List<T> read();
}
