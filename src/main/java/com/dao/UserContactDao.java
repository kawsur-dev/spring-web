package com.dao;

import com.model.UserContact;
import com.model.UserDetail;

import java.util.List;

public interface UserContactDao {

    public List<UserContact> getAll();

    public void save(UserContact userContact);

    public UserContact get(Long id);

    public void update(UserContact userContact);

    public void delete(Long id);
}
