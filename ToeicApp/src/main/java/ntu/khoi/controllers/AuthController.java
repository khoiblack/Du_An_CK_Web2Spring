package ntu.khoi.controllers;

import jakarta.servlet.http.HttpSession;
import ntu.khoi.dto.LoginDto;
import ntu.khoi.models.User;
import ntu.khoi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    
    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("loginData", new LoginDto());
        return "login"; 
    }

    
    @PostMapping("/login")
    public String handleLogin(@ModelAttribute("loginData") LoginDto loginDto, HttpSession session, Model model) {
        Optional<User> userOptional = userRepository.findByUsername(loginDto.getUsername());

        
        if (userOptional.isPresent() && userOptional.get().getPassword().equals(loginDto.getPassword())) {
            User user = userOptional.get();
            
            
            session.setAttribute("currentUser", user);

            
            if ("ADMIN".equals(user.getRole())) {
                return "redirect:/admin/dashboard";
            } else {
                return "redirect:/dashboard";
            }
        }

        
        model.addAttribute("error", "Tài khoản hoặc mật khẩu không chính xác!");
        return "login";
    }

    
    @GetMapping("/logout")
    public String handleLogout(HttpSession session) {
        session.invalidate(); 
        return "redirect:/login";
    }
}