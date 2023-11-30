package customer.loginpage;
//  import org.springframework.beans.factory.annotation.Autowired;

// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// import java.util.Collection;
// import java.util.List;

// @RestController
// @RequestMapping("/api/users")
// public class UserController {

//     @Autowired
//     private UserDataService userDataService; // Assuming you have a service layer
//     @RequestMapping(value = "", method = RequestMethod.GET)
//     public ResponseEntity<?> getEmployees()  {
//         return new  ResponseEntity<>(userDataService.getAllUsers(), HttpStatus.OK);
//     }

// Endpoint to get all users
// @GetMapping("/all")
// public ResponseEntity<Collection<UserData>> getAllUsers() {

//     Collection<UserData> users = userDataService.getAllUsers();

//     return ResponseEntity.ok(users);

// }

// Endpoint to get a user by ID
// @GetMapping("/{userId}")
// public ResponseEntity<UserData> getUserById(@PathVariable Long userId) {
//     UserData user = userDataService.getUserById(userId);
//     if (user != null) {
//         return ResponseEntity.ok(user);
//     } else {
//         return ResponseEntity.notFound().build();
//     }
// }

// Endpoint to create a new user
// @PostMapping("/create")
// public ResponseEntity<UserData> createUser(@RequestBody UserData userData) {
//     UserData createdUser = userDataService.createUser(userData);
//     return ResponseEntity.ok(createdUser);
// }

// Endpoint to update an existing user
// @PutMapping("/update/{userId}")
// public ResponseEntity<UserData> updateUser(@PathVariable Long userId, @RequestBody UserData userData) {
//     UserData updatedUser = userDataService.updateUser(userId, userData);
//     if (updatedUser != null) {
//         return ResponseEntity.ok(updatedUser);
//     } else {
//         return ResponseEntity.notFound().build();
//     }
// }

// Endpoint to delete a user by ID
// @DeleteMapping("/delete/{userId}")
// public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {
//     userDataService.deleteUser(userId);
//     return ResponseEntity.noContent().build();
// }

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/api/entities")
public class UserController {

    @Autowired
    private UserDataService yourEntityService;

    @GetMapping("/{id}")
    public UserData getById(@PathVariable Long id) {
        return yourEntityService.getById(id);
    }

    @GetMapping("/all")
    public Collection<UserData> getAll() {
        return yourEntityService.getAll();
    }

    @PostMapping
    public UserData create(@RequestBody UserData entity) {
        return yourEntityService.create(entity);
    }

    @PutMapping("/{id}")
    public UserData update(@PathVariable Long id, @RequestBody UserData entity) {
       
        return yourEntityService.update(entity);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        yourEntityService.delete(id);
    }
}
