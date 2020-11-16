package web.service;

import web.model.Role;
import web.model.User;
import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> allUsers();
    void add(User user);
    void delete(User user);
    void edit(User user);
    Optional<User> getById(Long id);
    List<Role> allRoles();
    Optional<Role> getRoleByRoleName(String roleName);
    Optional<User> getUserByName(String name);
}
