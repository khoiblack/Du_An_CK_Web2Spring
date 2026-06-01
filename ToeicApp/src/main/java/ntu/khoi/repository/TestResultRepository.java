package ntu.khoi.repository;

import ntu.khoi.models.TestResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestResultRepository extends JpaRepository<TestResult, Integer> {
    
    List<TestResult> findByUserIdOrderByTestDateDesc(Integer userId);
}