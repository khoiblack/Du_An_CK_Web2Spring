package ntu.khoi.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import ntu.khoi.entity.User;
import ntu.khoi.repository.UserRepository;
import ntu.khoi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    
    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

   
    
    @GetMapping("/login")
    public String showLoginPage() {
        return "login"; 
    }

    @PostMapping("/login")
    public String handleLogin(@RequestParam String username, 
                              @RequestParam String password, 
                              HttpServletRequest request, 
                              Model model) {
        User user = userService.login(username, password);
        
        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("currentUser", user);
            
            if ("ADMIN".equals(user.getRole())) {
                return "redirect:/admin/dashboard";
            } else {
                return "redirect:/student/home";
            }
        }
        
        model.addAttribute("error", "Tài khoản hoặc mật khẩu không chính xác!");
        return "login";
    }

    @GetMapping("/logout")
    public String handleLogout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate(); 
        }
        return "redirect:/login";
    }

    

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("newUser", new User());
        return "register"; 
    }

    @PostMapping("/register/save")
    public String processRegister(@ModelAttribute("newUser") User user, Model model) {
        
        User existingUser = userRepository.findByUsername(user.getUsername());
        if (existingUser != null) {
            model.addAttribute("error", "Tên đăng nhập này đã có người sử dụng!");
            return "register";
        }

        
        user.setRole("STUDENT");
        userRepository.save(user);

        return "redirect:/login?registerSuccess=true";
    }
}