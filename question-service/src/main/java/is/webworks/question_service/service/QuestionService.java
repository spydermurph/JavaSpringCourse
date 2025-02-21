package is.webworks.question_service.service;


import is.webworks.question_service.dao.QuestionDao;
import is.webworks.question_service.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {
    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<List<Question>> getAllQuestions() {
        try {
            return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
        } catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Question> getQuestion(Integer id) {
        try{
            Optional<Question> optional = questionDao.findById(id);
            if(optional.isEmpty()) {
                return new ResponseEntity<>(new Question(), HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(optional.get(), HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new Question(), HttpStatus.BAD_REQUEST);

    }

    public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {
        try {
            return new ResponseEntity<>(questionDao.findByCategory(category), HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> addQuestion(Question question) {
        questionDao.save(question);
        return new ResponseEntity<>("success", HttpStatus.CREATED);
    }

    public ResponseEntity<String> updateQuestion(Integer id, Question question) {
        Optional<Question> optional = questionDao.findById(question.getId());
        if(optional.isEmpty()){
            new ResponseEntity<>("not found", HttpStatus.NOT_FOUND);
        }
        Question updateQuestion = optional.get();
        updateQuestion.setQuestionTitle(question.getQuestionTitle());
        questionDao.save(question);
        return new ResponseEntity<>("success", HttpStatus.CREATED);
    }

    public ResponseEntity<String> deleteQuestion(Integer id){
        questionDao.deleteById(id);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }
}
