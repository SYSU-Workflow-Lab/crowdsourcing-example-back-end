package org.sysu.workflow.crowdsourcingexamplebackend.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sysu.workflow.crowdsourcingexamplebackend.entity.CompletedTask;
import org.sysu.workflow.crowdsourcingexamplebackend.repository.CompletedTaskRepository;

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

}
