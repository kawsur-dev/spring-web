package com.service;

import com.dao.UserContactDao;
import com.dao.UserDetailDao;
import com.model.UserContact;
import com.model.UserDetail;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserContactServiceImpl implements UserContactService {

    private final UserContactDao userContactDao;

    public UserContactServiceImpl(UserContactDao userContactDao) {
        this.userContactDao = userContactDao;
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserContact> getAll() {
        return userContactDao.getAll();
    }

    @Override
    public void save(UserContact userContact) {
        userContactDao.save(userContact);
    }

    @Override
    public UserContact get(Long id) {
        return userContactDao.get(id);
    }

    @Override
    public void update(UserContact userContact) {
        userContactDao.update(userContact);
    }

    @Override
    public void delete(Long id) {
        userContactDao.delete(id);
    }
}
