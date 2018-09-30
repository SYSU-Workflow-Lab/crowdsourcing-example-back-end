package org.sysu.workflow.crowdsourcingexamplebackend.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sysu.workflow.crowdsourcingexamplebackend.entity.TipsAndTasks;
import org.sysu.workflow.crowdsourcingexamplebackend.repository.TipsAndTasksRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Skye on 2018/9/30.
 */
@Repository
public class TipsAndTasksDAO {

    @Autowired
    private TipsAndTasksRepository tipsAndTasksRepository;

    public List<String> getTipsAndTaskByStage(String stage) {
        List<String> result = new ArrayList<>();
        result.add(tipsAndTasksRepository.findByStageAndType(stage, 0).getContent());
        result.add(tipsAndTasksRepository.findByStageAndType(stage, 1).getContent());
        return result;
    }

}
