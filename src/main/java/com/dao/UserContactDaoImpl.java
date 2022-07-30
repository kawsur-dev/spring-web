package com.dao;

import com.model.UserContact;
import com.model.UserDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserContactDaoImpl implements UserContactDao {

    private final SessionFactory sessionFactory;

    public UserContactDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<UserContact> getAll() {
        Session session = this.sessionFactory.getCurrentSession();
        Query<UserContact> userContactQuery = session.createQuery("from UserContact", UserContact.class);
        List<UserContact> userContacts = userContactQuery.getResultList();
        return userContacts == null ? new ArrayList<UserContact>() : userContacts;
    }

    @Override
    public void save(UserContact userContact) {
        Session session = this.sessionFactory.getCurrentSession();
        session.save(userContact);
    }

    @Override
    public UserContact get(Long id) {
        Session session = this.sessionFactory.getCurrentSession();
        return session.get(UserContact.class, id);
    }

    @Override
    public void update(UserContact userContact) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(userContact);
    }

    @Override
    public void delete(Long id) {
        UserContact userContact = get(id);
        sessionFactory.getCurrentSession().delete(userContact);
    }
}
