package photoalbum.com.User;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> getUsers() {
        return repository.findByOrderByFirstName();
    }

    public User getUser(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User with id " + id + " not found"));
    }

    public User insertUser(User user) {
        return repository.save(user);
    }

    public User updateUser(User user, Long id) {
        return repository.findById(id)
                .map(processorOrig -> {
                    processorOrig.setUsername(user.getUsername());
                    processorOrig.setFirstName(user.getFirstName());
                    processorOrig.setSecondName(user.getSecondName());
                    return repository.save(processorOrig);
                })
                .orElseGet(() -> repository.save(user));
    }
    public void deleteUser(Long id) {
        repository.deleteById(id);
    }

}