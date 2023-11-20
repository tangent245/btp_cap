package customer.loginpage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class UserDataService {

    // @Autowired
    // private UserDataRepository userRepository;

    @Autowired
    private UserDao userDao;

    // Get all users
    public Collection<UserData> getAllUsers() {

        return userDao.jgetAllUsers();
    }

    // Get user by ID
    // public UserData getUserById(Long userId) {
    // Optional<UserData> userOptional = userRepository.findById(userId);
    // return userOptional.orElse(null);
    // }

    // Create a new user
    // public UserData createUser(UserData userData) {
    // return userRepository.save(userData);
    // }

    // Update an existing user
    // public UserData updateUser(Long userId, UserData userData) {
    // Optional<UserData> existingUserOptional = userRepository.findById(userId);

    // if (existingUserOptional.isPresent()) {
    // UserData existingUser = existingUserOptional.get();
    // // Update fields based on your requirements
    // existingUser.setUsername(userData.getUsername());
    // existingUser.setEmail(userData.getEmail());
    // existingUser.setPassword(userData.getPassword());
    // existingUser.setFullName(userData.getFullName());
    // existingUser.setDateOfBirth(userData.getDateOfBirth());
    // existingUser.setStatus(userData.getStatus());

    // return userRepository.save(existingUser);
    // } else {
    // return null; // User not found
    // }
    // }

    // Delete a user by ID
    // public void deleteUser(Long userId) {
    // userRepository.deleteById(userId);
    // }
    // }
}
