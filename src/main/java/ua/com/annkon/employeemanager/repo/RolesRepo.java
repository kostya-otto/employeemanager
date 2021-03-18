package ua.com.annkon.employeemanager.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.annkon.employeemanager.model.users.Roles;

public interface RolesRepo extends JpaRepository<Roles, Long> {
    Roles findByName(String role);
}
