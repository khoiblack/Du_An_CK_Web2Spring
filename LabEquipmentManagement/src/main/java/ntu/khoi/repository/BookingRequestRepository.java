package ntu.khoi.repository;
import ntu.khoi.entity.BookingRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BookingRequestRepository extends JpaRepository<BookingRequest, Integer> {
    List<BookingRequest> findByUserId(Integer userId); 
}