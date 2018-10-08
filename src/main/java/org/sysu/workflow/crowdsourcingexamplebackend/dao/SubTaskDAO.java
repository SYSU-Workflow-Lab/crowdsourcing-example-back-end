package org.sysu.workflow.crowdsourcingexamplebackend.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sysu.workflow.crowdsourcingexamplebackend.entity.SubTask;
import org.sysu.workflow.crowdsourcingexamplebackend.entity.VotePageData;
import org.sysu.workflow.crowdsourcingexamplebackend.repository.SubTaskRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Skye on 2018/9/29.
 */
@Repository
public class SubTaskDAO {

    @Autowired
    private SubTaskRepository subTaskRepository;

    public void save(SubTask subTask) {
        subTaskRepository.save(subTask);
    }

    public void deleteIfExist(String userId) {
        subTaskRepository.deleteSubTasksByUserId(userId);
    }

    public List<VotePageData> getVoteData() {
        List<VotePageData> result = new ArrayList<>();
        List<String> userIds = subTaskRepository.findAllUserId();
        for (int i = 0; i < userIds.size(); i++) {
            List<String> contents = subTaskRepository.findContentsByUserId(userIds.get(i));
            result.add(new VotePageData(userIds.get(i), contents));
        }
        return result;
    }

}
