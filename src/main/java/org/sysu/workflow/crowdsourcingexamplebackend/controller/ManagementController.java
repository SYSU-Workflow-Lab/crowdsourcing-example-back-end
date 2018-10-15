package org.sysu.workflow.crowdsourcingexamplebackend.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.sysu.workflow.crowdsourcingexamplebackend.dao.*;
import org.sysu.workflow.crowdsourcingexamplebackend.entity.TipsAndTasks;
import org.sysu.workflow.crowdsourcingexamplebackend.entity.VotePageData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Skye on 2018/10/11.
 */
@RestController
@RequestMapping("/api/management")
public class ManagementController {

    @Autowired
    private SubTaskDAO subTaskDAO;

    @Autowired
    private ElectionDAO electionDAO;

    @Autowired
    private CompletedTaskDAO completedTaskDAO;

    @Autowired
    private MergedTaskDAO mergedTaskDAO;

    @Autowired
    private TipsAndTasksDAO tipsAndTasksDAO;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 清空数据
     */
    @GetMapping(value = "/reset")
    public ResponseEntity<?> reset() {
        subTaskDAO.deleteAll();
        subTaskDAO.setCount("-1");
        electionDAO.deleteAll();
        completedTaskDAO.deleteAll();
        mergedTaskDAO.deleteAll();
        return new ResponseEntity(HttpStatus.OK);
    }

    /**
     * 获取所有的tips和tasks数据
     */
    @GetMapping(value = "/tips-and-tasks")
    public ResponseEntity<?> getTipsAndTasks() {
        return new ResponseEntity<>(tipsAndTasksDAO.getAll(), HttpStatus.OK);
    }

    /**
     * 获取投票结果相关数据
     */
    @GetMapping(value = "/data")
    public ResponseEntity<?> getBestContent() {
        Map<String, List<VotePageData>> result = new HashMap<>();

        // is task complicated
        List<VotePageData> listVPD1 = new ArrayList<>();
        List<String> listS1 = new ArrayList<>();
        try {
            listS1.add(electionDAO.getIsComplicated());
        } catch (Exception e) {
            e.printStackTrace();
        }
        listVPD1.add(new VotePageData("no one", listS1));
        result.put("task", listVPD1);

        // best subtask
        List<VotePageData> listVPD2 = new ArrayList<>();
        String targetId = electionDAO.getTheBest("vtd");
        if ("".equals(targetId)) {
            listVPD2.add(new VotePageData("No Data", new ArrayList<>()));
        } else {
            subTaskDAO.setCount(targetId);
            listVPD2.add(new VotePageData(targetId, subTaskDAO.getSubTaskByUserId(targetId)));
        }
        result.put("subtask", listVPD2);

        // best completed task
        List<VotePageData> listVPD3 = new ArrayList<>();
        List<String> targetIds = electionDAO.getTheBests("vtc");
        if (targetIds.isEmpty()) {
            listVPD3.add(new VotePageData("No Data", new ArrayList<>()));
        } else {
            for (int i = 0; i < targetIds.size(); i++) {
                List<String> temp = new ArrayList<>();
                if ("".equals(targetIds.get(i))) {
                    listVPD3.add(new VotePageData("No Data", temp));
                } else {
                    temp.add(completedTaskDAO.findContentByUserIdAndSubTaskIndex(targetIds.get(i), i + ""));
                    listVPD3.add(new VotePageData(targetIds.get(i), temp));
                }
            }
        }
        result.put("completedtask", listVPD3);

        // best merged task
        List<VotePageData> listVPD4 = new ArrayList<>();
        List<String> listS4 = new ArrayList<>();
        targetId = electionDAO.getTheBest("vtm");
        if ("".equals(targetId)) {
            listVPD4.add(new VotePageData("No Data", listS4));
        } else {
            listS4.add(mergedTaskDAO.findContentByUserId(targetId));
            listVPD4.add(new VotePageData(targetId, listS4));
        }
        result.put("mergedtask", listVPD4);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * 更新指定的tips或tasks数据
     */
    @PostMapping(value = "/update/tips-and-tasks")
    public ResponseEntity<?> updateTipsAndTask(@RequestBody TipsAndTasks data) {
        tipsAndTasksDAO.updateData(data);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * 获取每个阶段的投票总数
     */
    @GetMapping(value = "/counts")
    public ResponseEntity<?> getCounts() {
        List<Integer> result = new ArrayList<>();
        result.add(electionDAO.getCountOfStage("vtd"));
        result.add(electionDAO.getCountOfStage("vtc"));
        result.add(electionDAO.getCountOfStage("vtm"));

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
