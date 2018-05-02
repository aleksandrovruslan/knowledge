package com.aleksandrov.Knowledge.services.Quiz;

import com.aleksandrov.Knowledge.exceptions.Quiz.QuizNotFoudException;
import com.aleksandrov.Knowledge.models.Quiz;
import com.aleksandrov.Knowledge.repositories.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuizServiceImpl implements QuizService {
    @Autowired
    private QuizRepository quizRepository;

    @Override
    public Quiz getQuiz(long id) {
        return findQuiz(id);
    }

    @Override
    public Quiz saveQuiz(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    @Override
    public void deleteQuiz(long id) {
        findQuiz(id);
        quizRepository.deleteById(id);
    }

    @Override
    public Quiz edit(Quiz quiz) {
        findQuiz(quiz.getId());
        return quizRepository.save(quiz);
    }

    @Override
    public List<Quiz> getQuizzes() {
        List<Quiz> quizzes = new ArrayList<>();
        quizRepository.findAll().forEach(quiz -> quizzes.add(quiz));
        return quizzes;
    }

    private Quiz findQuiz(long id) {
        return quizRepository.findById(id).orElseThrow(() ->
                new QuizNotFoudException("Quiz id " + id + " not found."));
    }
}