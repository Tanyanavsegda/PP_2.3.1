package web.services;

import web.models.User;

import java.util.List;

public interface UsersService {
    List<User> findAll();
    User findOne(int id);
    void save(User user);
    void update(int id, User updateUser);
    void delete(int id);
}
