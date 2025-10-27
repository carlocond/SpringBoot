package com.library.Library.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok(userService.findUserByStatus(UserStatus.ACTIVE));
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id){
        return ResponseEntity.ok(userService.findUserById(id));
    }

    //Create Update Patch e Delete

    //Create
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        return ResponseEntity.ok(userService.createUser(user));
    }

    //Update
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User userDetails){
        return ResponseEntity.ok(userService.updateUser(id, userDetails));
    }

    //Patch
    @PatchMapping("/{id}/status") //Annotazione PatchMapping utilizzata per aggiornamenti specifici di una risorsa, modifica campi senza alterarne altri
    public ResponseEntity<User> changeUserStatus(@PathVariable Long id, @RequestParam UserStatus userStatus){
        return ResponseEntity.ok(userService.changeUserStatus(id, userStatus));
    }

    //Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    //Metodo per restituire gli admin
    @GetMapping("/admins")
    public ResponseEntity<List<User>> getAdmins() {
        return ResponseEntity.ok(userService.findUsersByRole(UserRole.ADMIN));
    }
}
