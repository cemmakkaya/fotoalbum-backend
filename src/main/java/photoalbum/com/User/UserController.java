package photoalbum.com.User;

import jakarta.annotation.security.RolesAllowed;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
public class UserController {

    private final UserService UserService;


    public UserController(UserService UserService) {
        this.UserService = UserService;
    }

    @GetMapping("api/Users")
    public ResponseEntity<List<User>> getSortedUsers() {
        List<User> Users = UserService.getUsers();
        return new ResponseEntity<>(Users, HttpStatus.OK);
    }

    @GetMapping("api/User/{id}")
    public ResponseEntity<User> one(@PathVariable Long id) {
        User User = UserService.getUser(id);
        return new ResponseEntity<>(User, HttpStatus.OK);
    }

    @PostMapping("api/User/create")
    public ResponseEntity<User> createUser(@RequestBody User User) {
        User createdUser = UserService.insertUser(User);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @PutMapping("api/User/update/{id}")
    public ResponseEntity<User> updateUser(@RequestBody User User, @PathVariable Long id) {
        User updatedUser = UserService.updateUser(User, id);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @DeleteMapping("api/User/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        UserService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}