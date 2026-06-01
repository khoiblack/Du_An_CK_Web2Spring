package ntu.khoi.controller;

import ntu.khoi.entity.Equipment;
import ntu.khoi.service.EquipmentService;
import ntu.khoi.service.BookingRequestService; // Thêm import
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

    
    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("listEquipment", equipmentService.getAll());
        model.addAttribute("listRequests", bookingRequestService.getAll()); 
        model.addAttribute("equipment", new Equipment()); 
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
}