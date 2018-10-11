package org.sysu.workflow.crowdsourcingexamplebackend.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sysu.workflow.crowdsourcingexamplebackend.entity.MergedTask;
import org.sysu.workflow.crowdsourcingexamplebackend.entity.VotePageData;
import org.sysu.workflow.crowdsourcingexamplebackend.repository.MergedTaskRepository;

import java.util.ArrayList;
import java.util.List;

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

    public void deleteAll() {
        mergedTaskRepository.deleteAll();
    }

    public List<VotePageData> getVotePageData() {
        List<VotePageData> result = new ArrayList<>();
        List<String> userIds = mergedTaskRepository.findAllUserId();
        for (int i = 0; i < userIds.size(); i++) {
            List<String> contents = mergedTaskRepository.findContentsByUserId(userIds.get(i));
            result.add(new VotePageData(userIds.get(i), contents));
        }
        return result;
    }

}
