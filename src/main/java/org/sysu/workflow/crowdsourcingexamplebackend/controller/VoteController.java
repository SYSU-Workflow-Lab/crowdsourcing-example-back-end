package org.sysu.workflow.crowdsourcingexamplebackend.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.sysu.workflow.crowdsourcingexamplebackend.dao.ElectionDAO;
import org.sysu.workflow.crowdsourcingexamplebackend.dao.SubTaskDAO;
import org.sysu.workflow.crowdsourcingexamplebackend.dao.TipsAndTasksDAO;
import org.sysu.workflow.crowdsourcingexamplebackend.entity.Election;
import org.sysu.workflow.crowdsourcingexamplebackend.entity.FormData;
import org.sysu.workflow.crowdsourcingexamplebackend.entity.VotePageData;

import java.util.List;

/**
 * Created by Skye on 2018/9/30.
 */
@RestController
@RequestMapping("/vote")
public class VoteController {

    @Autowired
    private SubTaskDAO subTaskDAO;

    @Autowired
    private TipsAndTasksDAO tipsAndTasksDAO;

    @Autowired
    private ElectionDAO electionDAO;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping(value = "/{purpose}/tips-and-task")
    public ResponseEntity<?> getTipsAndTask(@PathVariable String purpose) {
        List<String> result = tipsAndTasksDAO.getTipsAndTaskByStage(purpose);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(value = "/vtd/data")
    public ResponseEntity<?> getVoteData() {
        List<VotePageData> result = subTaskDAO.getVoteData();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping(value = "/submit")
    public ResponseEntity<?> submit(@RequestBody FormData vote) {
        String fromId = vote.getUserId();
        electionDAO.deleteIfExist(fromId);
        String targetId = (String) vote.getData();
        electionDAO.save(new Election(fromId, targetId));
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
