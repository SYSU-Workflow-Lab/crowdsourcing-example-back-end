package org.sysu.workflow.crowdsourcingexamplebackend.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sysu.workflow.crowdsourcingexamplebackend.entity.Election;
import org.sysu.workflow.crowdsourcingexamplebackend.repository.ElectionRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Skye on 2018/10/8.
 */

@Repository
public class ElectionDAO {

    @Autowired
    private ElectionRepository electionRepository;

    @Autowired
    private SubTaskDAO subTaskDAO;

    public void save(Election election) {
        electionRepository.save(election);
    }

    public void deleteIfExist(String userId, String index) {
        electionRepository.deleteElectionByFromIdAndSubTaskIndex(userId, index);
    }

    public String getTheBestAndClean() {
        String targetId = "";
        try {
            targetId = (String) electionRepository.findTheBestUserId().get(0)[0];
            electionRepository.deleteAll();
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        return targetId;
    }

    public List<String> getTheBestsAndClean() {
        List<String> bests = new ArrayList<>();
        try {
            int count = subTaskDAO.getCount();
            for (int i = 0; i < count; i++) {
                bests.add((String) electionRepository.findTheBestUserIdBySubTaskIndex(i + "").get(0)[0]);
            }
            electionRepository.deleteAll();
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        return bests;
    }

}
