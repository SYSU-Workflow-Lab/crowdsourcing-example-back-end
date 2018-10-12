package org.sysu.workflow.crowdsourcingexamplebackend.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.sysu.workflow.crowdsourcingexamplebackend.dao.*;
import org.sysu.workflow.crowdsourcingexamplebackend.entity.Election;
import org.sysu.workflow.crowdsourcingexamplebackend.entity.FormData;
import org.sysu.workflow.crowdsourcingexamplebackend.entity.VotePageData;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Skye on 2018/9/30.
 */
@RestController
@RequestMapping("/api/vote")
public class VoteController {

    @Autowired
    private SubTaskDAO subTaskDAO;

    @Autowired
    private CompletedTaskDAO completedTaskDAO;

    @Autowired
    private MergedTaskDAO mergedTaskDAO;

    @Autowired
    private TipsAndTasksDAO tipsAndTasksDAO;

    @Autowired
    private ElectionDAO electionDAO;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 获取指定目的的tips和tasks数据
     *
     * @param purpose
     */
    @GetMapping(value = "/{purpose}/tips-and-task")
    public ResponseEntity<?> getTipsAndTask(@PathVariable String purpose) {
        List<String> result = tipsAndTasksDAO.getTipsAndTaskByStage(purpose);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * 获取任务判别阶段的投票数据
     */
    @GetMapping(value = "/vt/data/*")
    public ResponseEntity<?> getVTData() {
        return new ResponseEntity<>(new ArrayList<VotePageData>(), HttpStatus.OK);
    }

    /**
     * 获取任务分解阶段的投票数据
     */
    @GetMapping(value = "/vtd/data/*")
    public ResponseEntity<?> getVTDData() {
        List<VotePageData> result = subTaskDAO.getVotePageData();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * 获取任务完成阶段的投票数据
     */
    @GetMapping(value = "/vtc/data/{index}")
    public ResponseEntity<?> getVTCData(@PathVariable String index) {
        List<VotePageData> result = completedTaskDAO.getVotePageData(index);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * 获取任务合并阶段的投票数据
     */
    @GetMapping(value = "/vtm/data/*")
    public ResponseEntity<?> getVTMData() {
        List<VotePageData> result = mergedTaskDAO.getVotePageData();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * 接收提交的投票数据
     *
     * @param stage
     * @param index
     * @param vote
     */
    @PostMapping(value = "/submit/{stage}/{index}")
    @Transactional
    public ResponseEntity<?> submit(@PathVariable String stage, @PathVariable String index, @RequestBody FormData vote) {
        String fromId = vote.getUserId();
        electionDAO.deleteIfExist(fromId, index, stage);
        String targetId = (String) vote.getData();
        electionDAO.save(new Election(fromId, targetId, index, stage));
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
