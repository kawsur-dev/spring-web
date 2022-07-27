package com.dao;

import com.model.User;
import com.model.UserDetail;

import java.util.List;

public interface UserDetailDao {

    public List<UserDetail> getAll();

    public void save(UserDetail userDetail);

    public UserDetail get(Long id);

    public void update(UserDetail userDetail);

    public void delete(Long id);
}
