package com.example.Tasks.Task.Controllers;

import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;

import org.openapitools.client.api.QuestionControllerApi;
import org.openapitools.client.model.Question;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/questions")
public class GetAPIController {
    QuestionControllerApi api = new QuestionControllerApi(new ApiClient());

    @GetMapping
    public ResponseEntity<List<Question>> getAllQuestions() throws ApiException {
        List<Question> questions = api.getAllQuestions();
        if (questions != null) {
            return new ResponseEntity<>(questions, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
