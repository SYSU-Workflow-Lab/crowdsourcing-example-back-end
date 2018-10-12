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

    private int count;

    public void save(SubTask subTask) {
        subTaskRepository.save(subTask);
    }

    public void deleteIfExist(String userId) {
        subTaskRepository.deleteSubTasksByUserId(userId);
    }

    public void deleteAll() {
        subTaskRepository.deleteAll();
    }

    public List<VotePageData> getVotePageData() {
        List<VotePageData> result = new ArrayList<>();
        List<String> userIds = subTaskRepository.findAllUserId();
        for (int i = 0; i < userIds.size(); i++) {
            List<String> contents = subTaskRepository.findContentsByUserId(userIds.get(i));
            result.add(new VotePageData(userIds.get(i), contents));
        }
        return result;
    }

    public List<String> getSubTaskByUserId(String userId) {
        return subTaskRepository.findContentsByUserId(userId);
    }

    public String getSubTaskByUserIdAndIndex(String userId, int index) {
        List<String> contents = subTaskRepository.findContentsByUserId(userId);
        return contents.get(index);
    }

    public int getCount() {
        return count;
    }

    public void setCount(String targetId) {
        count = subTaskRepository.getCountByUserId(targetId);
    }
}
