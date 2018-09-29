package org.sysu.workflow.crowdsourcingexamplebackend.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.sysu.workflow.crowdsourcingexamplebackend.dao.SubTaskDAO;
import org.sysu.workflow.crowdsourcingexamplebackend.entity.FormData;
import org.sysu.workflow.crowdsourcingexamplebackend.entity.SubTask;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by Skye on 2018/9/28.
 */
@RestController
@RequestMapping("/task-decomposition")
public class TaskDecompositionController {

    @Autowired
    private SubTaskDAO subTaskDAO;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping(value = "/tips-and-task")
    public ResponseEntity<?> getHotCinemas() {
        List<String> result = new ArrayList<>();
        result.add(" tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips ");
        result.add(" tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks ");
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping(value = "/submit")
    public ResponseEntity<?> submit(@RequestBody FormData tasks) {
        logger.info(tasks.getUserId());
        List<LinkedHashMap<String, String>> data = (ArrayList<LinkedHashMap<String, String>>) tasks.getData();
        for (LinkedHashMap<String, String> i : data) {
            for (String k : i.keySet()) {
                subTaskDAO.save(new SubTask(tasks.getUserId(), i.get(k)));
            }
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
