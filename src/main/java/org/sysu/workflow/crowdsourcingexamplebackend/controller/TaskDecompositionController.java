package org.sysu.workflow.crowdsourcingexamplebackend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Skye on 2018/9/28.
 */
@RestController
@RequestMapping("/task-decomposition")
public class TaskDecompositionController {

    @GetMapping(value = "/tips-and-task")
    public ResponseEntity<?> getHotCinemas() {
        List<String> result = new ArrayList<>();
        result.add(" tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips ");
        result.add(" tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks ");
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
