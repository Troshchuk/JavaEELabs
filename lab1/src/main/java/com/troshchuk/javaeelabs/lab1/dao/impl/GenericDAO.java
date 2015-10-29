package com.troshchuk.javaeelabs.lab1.dao.impl;

import com.troshchuk.javaeelabs.lab1.dao.Operation;
import com.troshchuk.javaeelabs.lab1.utils.DatabaseConnection;
import com.troshchuk.javaeelabs.lab1.annotation.Column;
import com.troshchuk.javaeelabs.lab1.annotation.Table;
import com.troshchuk.javaeelabs.lab1.utils.HelpUtils;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GenericDAO<T, K extends Serializable> implements Operation<T, K> {
    protected Connection con;

    protected Class<T> type;
    protected final String TABLE_NAME;
    protected final Method GET_ID_METHOD;
    protected final String ID_COLUMN;
    protected final List<Method> GET_METHODS;
    protected final List<Method> SET_METHODS;
    protected final List<String> COLUMNS;

    public GenericDAO(Class<T> type) {
        this.type = type;
        TABLE_NAME = type.getDeclaredAnnotation(Table.class).name();
        GET_ID_METHOD = HelpUtils.getIdMethod(type);
        ID_COLUMN = GET_ID_METHOD.getDeclaredAnnotation(Column.class).name();
        GET_METHODS = HelpUtils.getColumnsMethods(type);
        SET_METHODS = HelpUtils.getSetsMethods(GET_METHODS, type);
        COLUMNS = HelpUtils.toColumns(GET_METHODS);
    }

    public K create(T newInstance) {
        try {
            con = DatabaseConnection.getConnection();
            if (con != null) {
                con.setAutoCommit(false);
                String query = "INSERT INTO " + TABLE_NAME + " (" + columnsToString() + ") VALUES (?";
                for (int i = 1; i < COLUMNS.size(); i++) {
                    query += ", ?";
                }
                query += ")";
                PreparedStatement statement = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
                int i = 1;
                for (Method method : GET_METHODS) {
                    statement.setObject(i, method.invoke(newInstance));
                    i++;
                }
                int affectedRows = statement.executeUpdate();
                if (affectedRows == 0) {
                    throw new SQLException("Creating user failed, no rows affected.");
                }

                ResultSet rs = statement.getGeneratedKeys();
                rs.next();
                K id = (K) rs.getObject(1);

                con.commit();

                return id;
            }
        } catch (Exception e) {
            rollback();
        } finally {
            closeConnection();
        }

        return null;
    }

    public T read(K id) {
        try {
            con = DatabaseConnection.getConnection();
            if (con != null) {
                PreparedStatement statement = con.prepareStatement("SELECT " + columnsToString() + " FROM " + TABLE_NAME + " WHERE " + ID_COLUMN + " = ?");
                statement.setObject(1, id);
                ResultSet rs = statement.executeQuery();

                if (rs.next()) {
                    T newInstance = type.newInstance();
                    for (int i = 0; i < GET_METHODS.size(); i++) {
                        SET_METHODS.get(i).invoke(newInstance, rs.getObject(COLUMNS.get(i)));
                    }
                    return newInstance;
                }
            }
        } catch (Exception e) {
            rollback();
        } finally {
            closeConnection();
        }

        return null;
    }

    public boolean update(T transientObject) {
        boolean result = false;
        try {
            con = DatabaseConnection.getConnection();
            if (con != null) {
                con.setAutoCommit(false);
                String query = "UPDATE " + TABLE_NAME + " SET " + columnsToString().replace(",", "=?,") + "=? WHERE " + ID_COLUMN + "= ?";
                PreparedStatement statement = con.prepareStatement(query);

                int i = 1;
                for (Method method : GET_METHODS) {
                    statement.setObject(i, method.invoke(transientObject));
                    i++;
                }
                statement.setObject(i, GET_ID_METHOD.invoke(transientObject));
                result = statement.executeUpdate() > 0;
                con.commit();
                return result;
            }
        } catch (Exception e) {
            rollback();
        } finally {
            closeConnection();
        }
        return result;
    }

    public boolean delete(K persistentObject) {
        boolean result = false;
        try {
            con = DatabaseConnection.getConnection();
            if (con != null) {
                con.setAutoCommit(false);

                PreparedStatement statement = con.prepareStatement("DELETE FROM " + TABLE_NAME + " WHERE " + ID_COLUMN + " = ?");
                statement.setObject(1, persistentObject);

                result = statement.executeUpdate() > 0;
                con.commit();
                return result;
            }
        } catch (Exception e) {
            rollback();
        } finally {
            closeConnection();
        }
        return result;
    }

    public List<T> read() {
        List<T> resultList = new ArrayList<T>();

        try {
            con = DatabaseConnection.getConnection();
            if (con != null) {
                PreparedStatement statement = con.prepareStatement("SELECT " + columnsToString() + " FROM " + TABLE_NAME);
                ResultSet rs = statement.executeQuery();

                while (rs.next()) {
                    T newInstance = type.newInstance();
                    for (int i = 0; i < GET_METHODS.size(); i++) {
                        SET_METHODS.get(i).invoke(newInstance, rs.getObject(COLUMNS.get(i)));
                    }
                    resultList.add(newInstance);
                }
            }
        } catch (Exception e) {
            rollback();
        } finally {
            closeConnection();
        }

        return resultList;
    }

    protected String columnsToString() {
        return String.join(", ", COLUMNS);
    }

    protected void closeConnection() {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void rollback() {
        try {
            if (con != null) {
                con.rollback();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
