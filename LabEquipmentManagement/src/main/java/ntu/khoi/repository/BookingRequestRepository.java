package ntu.khoi.repository;

import ntu.khoi.entity.BookingRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.time.LocalDateTime;
import java.util.List;

public interface BookingRequestRepository extends JpaRepository<BookingRequest, Integer> {
    
    List<BookingRequest> findByUserId(Integer userId);

    
    @Query("SELECT COUNT(b) FROM BookingRequest b WHERE b.labRoom.id = :roomId " +
           "AND b.status IN ('PENDING', 'APPROVED') " +
           "AND (b.startTime < :endTime AND b.endTime > :startTime)")
    long countConflictingBookings(@Param("roomId") Integer roomId, 
                                  @Param("startTime") LocalDateTime startTime, 
                                  @Param("endTime") LocalDateTime endTime);
}