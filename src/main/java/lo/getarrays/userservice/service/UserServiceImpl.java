package lo.getarrays.userservice.service;

import lo.getarrays.userservice.domain.Role;
import lo.getarrays.userservice.domain.User;
import lo.getarrays.userservice.repo.RoleRepo;
import lo.getarrays.userservice.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceImpl implements UserService{

    private final UserRepo userRepo;
    private final RoleRepo roleRepo;

    @Override
    public User saveUser(User user) {
        log.info("saving new user - {} to db", user);
        return userRepo.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("saving new role - {} to db", role);
        return roleRepo.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        log.info("saving new role - {} to user - {} to db", roleName,username);
        User user = userRepo.findByUsername(username);
        Role role = roleRepo.findByName(roleName);
        user.getRole().add(role);
    }

    @Override
    public User getUser(String username) {
        log.info("fetch a user- {}", username);
        return userRepo.findByUsername(username);
    }

    @Override
    public List<User> getUser() {
        log.info("fetch all users");
        return userRepo.findAll();
    }
}
