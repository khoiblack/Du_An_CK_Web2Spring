package ntu.khoi.controllers;

import jakarta.servlet.http.HttpSession;
import ntu.khoi.models.Exam;
import ntu.khoi.models.Question;
import ntu.khoi.models.TestResult;
import ntu.khoi.models.User;
import ntu.khoi.repository.ExamRepository;
import ntu.khoi.repository.QuestionRepository;
import ntu.khoi.repository.TestResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
public class ExamController {

    @Autowired
    private ExamRepository examRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private TestResultRepository testResultRepository; 

    
    @GetMapping("/dashboard")
    public String showDashboard(HttpSession session, Model model) {
        User user = (User) session.getAttribute("currentUser");
        model.addAttribute("user", user);
        model.addAttribute("exams", examRepository.findAll());
        return "dashboard";
    }

    
    @GetMapping("/lam-bai/{id}")
    public String takeExam(@PathVariable("id") Integer examId, HttpSession session, Model model) {
        Optional<Exam> examOpt = examRepository.findById(examId);
        if (examOpt.isEmpty()) return "redirect:/dashboard";

        model.addAttribute("exam", examOpt.get());
        model.addAttribute("questions", questionRepository.findByExamId(examId));
        return "exam"; 
    }

    
    @PostMapping("/submit-exam")
    public String submitExam(@RequestParam Map<String, String> formData, HttpSession session, Model model) {
        User user = (User) session.getAttribute("currentUser");
        
        
        Integer examId = Integer.parseInt(formData.get("examId"));
        Exam exam = examRepository.findById(examId).orElse(null);
        List<Question> questions = questionRepository.findByExamId(examId);

        int correctListening = 0;
        int correctReading = 0;

        
        for (Question q : questions) {
            
            String submittedAnswer = formData.get("question_" + q.getId());
            
           
            if (submittedAnswer != null && submittedAnswer.equals(q.getCorrectAnswer())) {
                
                if (q.getPart() <= 4) {
                    correctListening++;
                } else {
                    correctReading++;
                }
            }
        }

        
        int totalScore = (correctListening + correctReading) * 5;

        
        TestResult result = new TestResult();
        result.setUser(user);
        result.setExam(exam);
        result.setCorrectListening(correctListening);
        result.setCorrectReading(correctReading);
        result.setScore(totalScore);
        
        testResultRepository.save(result);

       
        model.addAttribute("result", result);
        model.addAttribute("totalQuestions", questions.size());
        
        return "result"; 
    }
}