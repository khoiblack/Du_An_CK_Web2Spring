package ntu.khoi.controller;

import jakarta.servlet.http.HttpSession;
import ntu.khoi.entity.BookingRequest;
import ntu.khoi.entity.User;
import ntu.khoi.service.BookingRequestService;
import ntu.khoi.service.EquipmentService;
import ntu.khoi.service.LabRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private BookingRequestService bookingRequestService;

    @Autowired
    private EquipmentService equipmentService;

    @Autowired
    private LabRoomService labRoomService;

    
    @GetMapping("/home")
    public String studentHome(HttpSession session, Model model) {
        User currentUser = (User) session.getAttribute("currentUser");
        
        
        model.addAttribute("listEquipment", equipmentService.getAll());
        model.addAttribute("listRooms", labRoomService.getAll());
        model.addAttribute("myBookings", bookingRequestService.getByUserId(currentUser.getId()));
        model.addAttribute("newBooking", new BookingRequest());
        
        return "student_home"; 
    }

    
    @PostMapping("/booking/save")
    public String saveBooking(@ModelAttribute("newBooking") BookingRequest bookingRequest,
                              @RequestParam(required = false) Integer roomId,
                              @RequestParam(required = false) Integer equipmentId,
                              HttpSession session) {
        User currentUser = (User) session.getAttribute("currentUser");
        
       
        bookingRequest.setUser(currentUser);
        bookingRequest.setStatus("PENDING"); 
        
        
        if (roomId != null && roomId > 0) {
            bookingRequest.setLabRoom(labRoomService.getById(roomId));
        }
        if (equipmentId != null && equipmentId > 0) {
            bookingRequest.setEquipment(equipmentService.getById(equipmentId));
        }
        
        bookingRequestService.save(bookingRequest);
        return "redirect:/student/home";
    }
}