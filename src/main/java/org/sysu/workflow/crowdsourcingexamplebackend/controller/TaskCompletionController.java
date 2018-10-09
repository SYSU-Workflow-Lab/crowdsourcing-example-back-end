package org.sysu.workflow.crowdsourcingexamplebackend.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.sysu.workflow.crowdsourcingexamplebackend.dao.CompletedTaskDAO;
import org.sysu.workflow.crowdsourcingexamplebackend.dao.ElectionDAO;
import org.sysu.workflow.crowdsourcingexamplebackend.dao.SubTaskDAO;
import org.sysu.workflow.crowdsourcingexamplebackend.dao.TipsAndTasksDAO;
import org.sysu.workflow.crowdsourcingexamplebackend.entity.CompletedTask;
import org.sysu.workflow.crowdsourcingexamplebackend.entity.FormData;

import javax.transaction.Transactional;
import java.util.LinkedHashMap;
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
    private CompletedTaskDAO completedTaskDAO;

    @Autowired
    private ElectionDAO electionDAO;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private String targetId;

    @GetMapping(value = "/tips-and-task/{index}")
    public ResponseEntity<?> getTipsAndTask(@PathVariable int index) {
        List<String> result = tipsAndTasksDAO.getTipsAndTaskByStage("tc");
        if (targetId == null || "".equals(targetId)) {
            targetId = electionDAO.getTheBestAndClean();
        }
        result.add(subTaskDAO.getSubTaskByUserIdAndIndex(targetId, index));
        subTaskDAO.setCount(targetId);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping(value = "/submit")
    @Transactional
    public ResponseEntity<?> submit(@RequestBody FormData solution) {
        String fromId = solution.getUserId();

//        logger.info(solution.getData().toString());
        LinkedHashMap<String, String> data = (LinkedHashMap<String, String>) solution.getData();
        String content = data.get("content");
        String index = data.get("index");
//        logger.info(content + " " + index);

        completedTaskDAO.deleteIfExist(fromId, index);
        completedTaskDAO.save(new CompletedTask(fromId, content, index));

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
