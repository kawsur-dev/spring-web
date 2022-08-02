package com.service;

import java.util.List;

public interface UserContactService {

    public List<UserContact> getAll();

    public void save(UserContact userContact);

    public UserContact get(Long id);

    public void update(UserContact userContact);

    public void delete(Long id);
}
