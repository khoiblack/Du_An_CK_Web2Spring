package ntu.khoi.configs;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ntu.khoi.models.User;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class SecurityInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        User currentUser = (User) session.getAttribute("currentUser");

        
        if (currentUser == null) {
            response.sendRedirect("/login");
            return false;
        }

        
        String uri = request.getRequestURI();
        if (uri.startsWith("/admin") && !"ADMIN".equals(currentUser.getRole())) {
            response.sendRedirect("/dashboard");
            return false;
        }

        return true; 
    }
}