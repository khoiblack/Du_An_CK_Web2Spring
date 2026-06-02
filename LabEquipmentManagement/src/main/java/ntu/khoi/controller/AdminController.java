package ntu.khoi.controller;

import ntu.khoi.entity.Equipment;
import ntu.khoi.entity.LabRoom;
import ntu.khoi.entity.User;
import ntu.khoi.service.EquipmentService;
import ntu.khoi.service.BookingRequestService;
import ntu.khoi.service.LabRoomService;
import ntu.khoi.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private EquipmentService equipmentService;

    @Autowired
    private BookingRequestService bookingRequestService;

    @Autowired
    private LabRoomService labRoomService; 
    @Autowired
    private UserService userService;

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("listEquipment", equipmentService.getAll());
        model.addAttribute("listRequests", bookingRequestService.getAll());
        model.addAttribute("listRooms", labRoomService.getAll());
        model.addAttribute("listStudents", userService.getAllStudents()); 
        
        model.addAttribute("equipment", new Equipment()); 
        model.addAttribute("labRoom", new LabRoom()); 
        model.addAttribute("editUser", new User()); 
        
        return "dashboard_admin"; 
    }

   
    @PostMapping("/equipment/save")
    public String saveEquipment(@ModelAttribute("equipment") Equipment equipment) {
        if (equipment.getId() == null) {
            equipment.setAvailableQuantity(equipment.getTotalQuantity());
        }
        equipmentService.save(equipment);
        return "redirect:/admin/dashboard"; 
    }

    @GetMapping("/equipment/delete/{id}")
    public String deleteEquipment(@PathVariable Integer id) {
        equipmentService.delete(id);
        return "redirect:/admin/dashboard";
    }

    
    @PostMapping("/room/save")
    public String saveRoom(@ModelAttribute("labRoom") LabRoom labRoom) {
        labRoomService.save(labRoom);
        return "redirect:/admin/dashboard"; 
    }

    @GetMapping("/room/delete/{id}")
    public String deleteRoom(@PathVariable Integer id) {
        labRoomService.delete(id);
        return "redirect:/admin/dashboard";
    }

    
    @GetMapping("/request/approve/{id}")
    public String approveRequest(@PathVariable Integer id) {
        bookingRequestService.updateStatus(id, "APPROVED");
        return "redirect:/admin/dashboard";
    }

    @GetMapping("/request/reject/{id}")
    public String rejectRequest(@PathVariable Integer id) {
        bookingRequestService.updateStatus(id, "REJECTED");
        return "redirect:/admin/dashboard";
    }

    @PostMapping("/user/update")
    public String updateUser(@ModelAttribute("editUser") User user) {
        User existingUser = userService.getById(user.getId());
        if (existingUser != null) {
            existingUser.setFullName(user.getFullName());
            existingUser.setStudentId(user.getStudentId());
            existingUser.setStudentClass(user.getStudentClass());
            userService.save(existingUser);
        }
        return "redirect:/admin/dashboard";
    }

    
    @GetMapping("/user/reset-password/{id}")
    public String resetPassword(@PathVariable Integer id) {
        User existingUser = userService.getById(id);
        if (existingUser != null) {
            existingUser.setPassword("123456"); 
            userService.save(existingUser);
        }
        return "redirect:/admin/dashboard?resetSuccess=true";
    }

    
    @GetMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable Integer id) {
        try {
            userService.delete(id);
        } catch (Exception e) {
            
            return "redirect:/admin/dashboard?deleteError=true";
        }
        return "redirect:/admin/dashboard";
    }
    @GetMapping("/user/{id}/history")
    public String getUserHistory(@PathVariable Integer id, Model model) {
        
        model.addAttribute("studentHistory", bookingRequestService.getByUserId(id));
        
        
        return "admin_user_history :: history_content";
    }
}