package ntu.khoi.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "test_results")
public class TestResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "exam_id")
    private Exam exam;

    @Column(nullable = false)
    private Integer score;

    @Column(name = "correct_listening")
    private Integer correctListening;

    @Column(name = "correct_reading")
    private Integer correctReading;

    @Column(name = "test_date", insertable = false, updatable = false)
    private LocalDateTime testDate;

    
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
    public Exam getExam() { return exam; }
    public void setExam(Exam exam) { this.exam = exam; }
    public Integer getScore() { return score; }
    public void setScore(Integer score) { this.score = score; }
    public Integer getCorrectListening() { return correctListening; }
    public void setCorrectListening(Integer correctListening) { this.correctListening = correctListening; }
    public Integer getCorrectReading() { return correctReading; }
    public void setCorrectReading(Integer correctReading) { this.correctReading = correctReading; }
    public LocalDateTime getTestDate() { return testDate; }
    public void setTestDate(LocalDateTime testDate) { this.testDate = testDate; }
}