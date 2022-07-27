package com.service;

import com.dao.UserDao;
import com.dao.UserDetailDao;
import com.model.User;
import com.model.UserDetail;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserDetailServiceImpl implements UserDetailService {

    private final UserDetailDao userDetailDao;

    public UserDetailServiceImpl(UserDetailDao userDetailDao) {
        this.userDetailDao = userDetailDao;
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserDetail> getAll() {
        return userDetailDao.getAll();
    }

    @Override
    public void save(UserDetail userDetail) {
        userDetailDao.save(userDetail);
    }

    @Override
    public UserDetail get(Long id) {
        return userDetailDao.get(id);
    }

    @Override
    public void update(UserDetail userDetail) {
        userDetailDao.update(userDetail);
    }

    @Override
    public void delete(Long id) {
        userDetailDao.delete(id);
    }
}
