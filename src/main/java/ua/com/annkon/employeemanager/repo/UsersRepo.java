package ua.com.annkon.employeemanager.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.annkon.employeemanager.model.users.Users;

import java.util.Optional;

public interface UsersRepo extends JpaRepository<Users, Long> {
    void deleteUsersById(Long id);
    Users findByUsername(String username);

    Optional<Users> findUserById(Long id);
}
