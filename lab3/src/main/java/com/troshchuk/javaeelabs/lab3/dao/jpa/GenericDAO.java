package com.troshchuk.javaeelabs.lab3.dao.jpa;

import com.troshchuk.javaeelabs.lab1.dao.Operation;
import com.troshchuk.javaeelabs.lab3.utils.JpaUtils;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;

public class GenericDAO<T, K extends Serializable> implements Operation<T, K> {
    protected Class<T> type;
    protected EntityManager em = JpaUtils.getEntityManager();

    public GenericDAO(Class<T> type) {
        this.type = type;
    }

    public T create(T newInstance) {
        em.getTransaction().begin();
        em.persist(newInstance);
        em.flush();
        em.getTransaction().commit();
        return newInstance;
    }

    public T read(K id) {
        em.getTransaction().begin();
        T instance = em.find(type, id);
        em.getTransaction().commit();
        return instance;
    }

    public boolean update(T transientObject) {
        em.getTransaction().begin();
        transientObject = em.merge(transientObject);
        em.getTransaction().commit();
        return transientObject != null;
    }

    public void delete(K persistentObject) {
        em.remove(read(persistentObject));
    }

    @SuppressWarnings(value = "unchecked")
    public List<T> read() {
        return em.createQuery("SELECT e FROM " + type.getName() + " e").getResultList();
    }
}
