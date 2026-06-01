package ntu.khoi.controller;

import ntu.khoi.entity.Equipment;
import ntu.khoi.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private EquipmentService equipmentService;

    // 1. READ: Hiển thị trang quản lý thiết bị (Đã đổi đường dẫn return)
    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("listEquipment", equipmentService.getAll());
        model.addAttribute("equipment", new Equipment()); 
        
        // ĐỔI TỪ "admin/dashboard" THÀNH "dashboard_admin"
        return "dashboard_admin"; 
    }

    // 2. CREATE & UPDATE: Xử lý lưu form Thêm/Sửa
    @PostMapping("/equipment/save")
    public String saveEquipment(@ModelAttribute("equipment") Equipment equipment) {
        if (equipment.getId() == null) {
            equipment.setAvailableQuantity(equipment.getTotalQuantity());
        }
        equipmentService.save(equipment);
        return "redirect:/admin/dashboard"; 
    }

    // 3. DELETE: Xử lý xóa thiết bị
    @GetMapping("/equipment/delete/{id}")
    public String deleteEquipment(@PathVariable Integer id) {
        equipmentService.delete(id);
        return "redirect:/admin/dashboard";
    }
}