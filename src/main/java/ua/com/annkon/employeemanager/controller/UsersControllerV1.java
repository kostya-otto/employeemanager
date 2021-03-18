package ua.com.annkon.employeemanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.com.annkon.employeemanager.model.users.Users;
import ua.com.annkon.employeemanager.service.UsersService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UsersControllerV1 {
    private final UsersService usersService;

    @Autowired
    public UsersControllerV1(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Users>> getAllUsers(){
        List<Users> usersList = usersService.findAll();
        if (usersList == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(usersList, HttpStatus.OK);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Users> addNewUser(
            @RequestBody Users user
    ){
        Users newUser = usersService.addNewUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.OK);
    }

    @PutMapping("/edit")
    public ResponseEntity<Users> updateUser(@RequestBody Users user) {
        Users updatedUser = usersService.updateUser(user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUserById(@PathVariable("id") Long id){
        usersService.deleteUserById(id);
        return new  ResponseEntity<>(HttpStatus.OK);
    }
}
