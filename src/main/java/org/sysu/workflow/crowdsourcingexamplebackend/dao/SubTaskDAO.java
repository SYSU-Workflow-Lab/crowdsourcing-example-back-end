package org.sysu.workflow.crowdsourcingexamplebackend.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sysu.workflow.crowdsourcingexamplebackend.entity.SubTask;
import org.sysu.workflow.crowdsourcingexamplebackend.repository.SubTaskRepository;

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

}
