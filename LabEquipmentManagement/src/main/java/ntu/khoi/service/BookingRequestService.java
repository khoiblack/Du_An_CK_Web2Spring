package ntu.khoi.service;

import ntu.khoi.entity.BookingRequest;
import ntu.khoi.entity.Equipment;
import ntu.khoi.repository.BookingRequestRepository;
import ntu.khoi.repository.EquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BookingRequestService {

    @Autowired
    private BookingRequestRepository bookingRequestRepository;

    @Autowired
    private EquipmentRepository equipmentRepository;

    public List<BookingRequest> getByUserId(Integer userId) {
        return bookingRequestRepository.findByUserId(userId);
    }

    public void save(BookingRequest request) {
        bookingRequestRepository.save(request);
    }

    
    public List<BookingRequest> getAll() {
        return bookingRequestRepository.findAll();
    }

    
    public void updateStatus(Integer requestId, String status) {
        BookingRequest request = bookingRequestRepository.findById(requestId).orElse(null);
        if (request != null) {
            request.setStatus(status);
            
            
            if ("APPROVED".equals(status) && request.getEquipment() != null) {
                Equipment eq = request.getEquipment();
                int newAvailable = eq.getAvailableQuantity() - request.getQuantity();
                eq.setAvailableQuantity(Math.max(0, newAvailable)); 
                equipmentRepository.save(eq);
            }
            
            bookingRequestRepository.save(request);
        }
    }

    public boolean isRoomAvailable(Integer roomId, LocalDateTime startTime, LocalDateTime endTime) {
        long conflictCount = bookingRequestRepository.countConflictingBookings(roomId, startTime, endTime);
        return conflictCount == 0; 
    }
}