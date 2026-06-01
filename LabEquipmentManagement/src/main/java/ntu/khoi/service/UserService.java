package ntu.khoi.service;

import ntu.khoi.entity.User;
import ntu.khoi.repository.UserRepository;
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
}