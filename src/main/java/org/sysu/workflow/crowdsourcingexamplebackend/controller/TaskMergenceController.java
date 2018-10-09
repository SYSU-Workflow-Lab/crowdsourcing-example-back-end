package org.sysu.workflow.crowdsourcingexamplebackend.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.sysu.workflow.crowdsourcingexamplebackend.dao.CompletedTaskDAO;
import org.sysu.workflow.crowdsourcingexamplebackend.dao.ElectionDAO;
import org.sysu.workflow.crowdsourcingexamplebackend.dao.TipsAndTasksDAO;

import java.util.List;

/**
 * Created by Skye on 2018/10/9.
 */
@Controller
@RequestMapping("/api/task-mergence")
public class TaskMergenceController {

    @Autowired
    private TipsAndTasksDAO tipsAndTasksDAO;

    @Autowired
    private ElectionDAO electionDAO;

    @Autowired
    private CompletedTaskDAO completedTaskDAO;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private List<String> targetIds;

    @GetMapping(value = "/tips-and-task")
    public ResponseEntity<?> getTipsAndTask() {
        List<String> result = tipsAndTasksDAO.getTipsAndTaskByStage("tm");
        if (targetIds == null || targetIds.isEmpty()) {
            targetIds = electionDAO.getTheBestsAndClean();
        }
        for (int i = 0; i < targetIds.size(); i++) {
            result.add(completedTaskDAO.findContentByUserIdAndSubTaskIndex(targetIds.get(i), i + ""));
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
