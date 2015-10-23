package com.troshchuk.photoLibrary.dao;

import java.io.Serializable;
import java.sql.SQLException;

public interface Operation<T, K extends Serializable> {
    K create(T newInstance) throws SQLException;
    T read(K id) throws SQLException;
    boolean update(T transientObject) throws SQLException;
    boolean delete(K persistentObject) throws SQLException;
}
