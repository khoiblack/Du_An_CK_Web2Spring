package ntu.khoi.service;

import ntu.khoi.entity.User;
import ntu.khoi.repository.UserRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User login(String username, String password) {
        
        User user = userRepository.findByUsername(username);
        
        
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        
        return null;
    }
 
    public List<User> getAllStudents() {
        return userRepository.findByRole("STUDENT");
    }

    public User getById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    public void save(User user) {
        userRepository.save(user);
    }

    public void delete(Integer id) {
        userRepository.deleteById(id);
    }
}