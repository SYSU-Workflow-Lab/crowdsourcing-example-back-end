package org.sysu.workflow.crowdsourcingexamplebackend.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sysu.workflow.crowdsourcingexamplebackend.entity.CompletedTask;
import org.sysu.workflow.crowdsourcingexamplebackend.entity.VotePageData;
import org.sysu.workflow.crowdsourcingexamplebackend.repository.CompletedTaskRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Skye on 2018/10/9.
 */

@Repository
public class CompletedTaskDAO {

    @Autowired
    private CompletedTaskRepository completedTaskRepository;

    public void save(CompletedTask completedTask) {
        completedTaskRepository.save(completedTask);
    }

    public void deleteIfExist(String userId, String index) {
        completedTaskRepository.deleteCompletedTaskByUserIdAndSubTaskIndex(userId, index);
    }

    public void deleteAll() {
        completedTaskRepository.deleteAll();
    }

    public List<VotePageData> getVotePageData(String index) {
        List<VotePageData> result = new ArrayList<>();
        List<CompletedTask> completedTaskList = completedTaskRepository.findCompletedTasksBySubTaskIndex(index);
        for (int i = 0; i < completedTaskList.size(); i++) {
            List<String> contents = new ArrayList<>();
            contents.add(completedTaskList.get(i).getContent());
            result.add(new VotePageData(completedTaskList.get(i).getUserId(), contents));
        }
        return result;
    }

    public String findContentByUserIdAndSubTaskIndex(String userId, String subTaskId) {
        return completedTaskRepository.findCompletedTaskByUserIdAndSubTaskIndex(userId, subTaskId).getContent();
    }

}
