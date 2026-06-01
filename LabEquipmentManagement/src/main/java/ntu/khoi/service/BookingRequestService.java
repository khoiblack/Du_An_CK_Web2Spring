package ntu.khoi.service;

import ntu.khoi.entity.BookingRequest;
import ntu.khoi.repository.BookingRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookingRequestService {

    @Autowired
    private BookingRequestRepository bookingRequestRepository;

    
    public List<BookingRequest> getByUserId(Integer userId) {
        return bookingRequestRepository.findByUserId(userId);
    }

    
    public void save(BookingRequest request) {
        bookingRequestRepository.save(request);
    }
}