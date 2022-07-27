package com.service;

import com.model.User;
import com.model.UserDetail;
import sun.util.resources.cldr.mg.LocaleNames_mg;

import java.util.List;

public interface UserDetailService {

    public List<UserDetail> getAll();

    public void save(UserDetail userDetail);

    public UserDetail get(Long id);

    public void update(UserDetail userDetail);

    public void delete(Long id);
}
