package com.dao;

import com.model.UserDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDetailDaoImpl implements UserDetailDao {

    private final SessionFactory sessionFactory;

    public UserDetailDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<UserDetail> getAll() {
        Session session = this.sessionFactory.getCurrentSession();
        Query<UserDetail> userDetailQuery = session.createQuery("from UserDetail", UserDetail.class);
        List<UserDetail> userDetails = userDetailQuery.getResultList();
        return userDetails == null ? new ArrayList<UserDetail>() : userDetails;
    }

    @Override
    public void save(UserDetail userDetail) {
        Session session = this.sessionFactory.getCurrentSession();
        session.save(userDetail);
    }

    @Override
    public UserDetail get(Long id) {
        Session session = this.sessionFactory.getCurrentSession();
        return session.get(UserDetail.class, id);
    }

    @Override
    public void update(UserDetail userDetail) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(userDetail);
    }

    @Override
    public void delete(Long id) {
        UserDetail userDetail = get(id);
        sessionFactory.getCurrentSession().delete(userDetail);
    }
}
