package com.troshchuk.javaeelabs.lab1.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

public interface Operation<T, K extends Serializable> {
    T create(T newInstance);
    T read(K id);
    boolean update(T transientObject);
    void delete(K persistentObject);
    List<T> read();
}
