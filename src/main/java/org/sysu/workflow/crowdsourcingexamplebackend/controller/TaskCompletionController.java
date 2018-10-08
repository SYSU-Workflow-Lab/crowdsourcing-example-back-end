package org.sysu.workflow.crowdsourcingexamplebackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.sysu.workflow.crowdsourcingexamplebackend.dao.ElectionDAO;
import org.sysu.workflow.crowdsourcingexamplebackend.dao.SubTaskDAO;
import org.sysu.workflow.crowdsourcingexamplebackend.dao.TipsAndTasksDAO;
import org.sysu.workflow.crowdsourcingexamplebackend.entity.FormData;

import java.util.List;

/**
 * Created by Skye on 2018/10/8.
 */
@RestController
@RequestMapping("/api/task-completion")
public class TaskCompletionController {

    @Autowired
    private TipsAndTasksDAO tipsAndTasksDAO;

    @Autowired
    private SubTaskDAO subTaskDAO;

    @Autowired
    private ElectionDAO electionDAO;

    private String targetId;

    @GetMapping(value = "/tips-and-task/{index}")
    public ResponseEntity<?> getTipsAndTask(@PathVariable int index) {
        List<String> result = tipsAndTasksDAO.getTipsAndTaskByStage("tc");
        if (targetId == null || targetId == "") {
            targetId = electionDAO.getTheBestAndClean();
        }
        result.add(subTaskDAO.getSubTaskByUserIdAndIndex(targetId, index));
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping(value = "submit")
    public ResponseEntity<?> submit(@RequestBody FormData solution) {
        String fromId = solution.getUserId();

        // TODO

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
