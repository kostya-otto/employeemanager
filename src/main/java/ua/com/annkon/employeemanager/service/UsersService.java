package ua.com.annkon.employeemanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.annkon.employeemanager.exception.UserNotFoundException;
import ua.com.annkon.employeemanager.model.Employee;
import ua.com.annkon.employeemanager.model.users.Users;
import ua.com.annkon.employeemanager.repo.RolesRepo;
import ua.com.annkon.employeemanager.repo.UsersRepo;

import java.util.List;

@Service
@Transactional
public class UsersService {

    private final UsersRepo usersRepo;
    private final RolesRepo rolesRepo;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UsersService(UsersRepo usersRepo,
                        RolesRepo rolesRepo,
                        BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.usersRepo = usersRepo;
        this.rolesRepo = rolesRepo;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }



    public Users addNewUser(Users user){
        return usersRepo
                .save(user);
    }


    public List<Users> findAll(){
        return usersRepo.findAll();
    }

    public Users updateUser(Users users){
        return usersRepo.save(users);
    }

    public Users findUserById(Long id) {
        return usersRepo.findUserById(id).orElseThrow(
                ()-> new UserNotFoundException("By " + id + " user not found")
        );
    }

    public void deleteUserById(Long id){
        usersRepo.deleteUsersById(id);
    }
}
