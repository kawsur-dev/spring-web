package com.service;

import java.util.List;

public interface UserDetailService {

    public List<UserDetail> getAll();

    public void save(UserDetail userDetail);

    public UserDetail get(Long id);

    public void update(UserDetail userDetail);

    public void delete(Long id);
}
