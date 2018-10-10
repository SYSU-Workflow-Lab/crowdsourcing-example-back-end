package org.sysu.workflow.crowdsourcingexamplebackend.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sysu.workflow.crowdsourcingexamplebackend.entity.MergedTask;
import org.sysu.workflow.crowdsourcingexamplebackend.repository.MergedTaskRepository;

/**
 * Created by Skye on 2018/10/10.
 */
@Repository
public class MergedTaskDAO {

    @Autowired
    private MergedTaskRepository mergedTaskRepository;

    public void save(MergedTask mergedTask) {
        mergedTaskRepository.save(mergedTask);
    }

    public void deleteIfExist(String userId) {
        mergedTaskRepository.deleteMergedTasksByUserId(userId);
    }

}
