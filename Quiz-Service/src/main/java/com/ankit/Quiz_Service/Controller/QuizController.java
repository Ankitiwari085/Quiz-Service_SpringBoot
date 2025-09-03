package com.ankit.Quiz_Service.Controller;

import com.ankit.Quiz_Service.Model.QuestionWrapper;
import com.ankit.Quiz_Service.Model.QuizDTO;
import com.ankit.Quiz_Service.Model.Response;
import com.ankit.Quiz_Service.Service.QuizService;
import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    QuizService quizService ;


    @PostMapping("/create")
    public ResponseEntity<String> createQuiz(@RequestBody QuizDTO quizDto){
        return  quizService.createQuiz(quizDto.getCategory(), quizDto.getNumQuestion(), quizDto.getTitle());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Integer id){

        return quizService.getQuizQuestions(id);
    }

    @PostMapping("/submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id , List<Response> responses){
        return quizService.calculateResult(id,responses);

    }
}
