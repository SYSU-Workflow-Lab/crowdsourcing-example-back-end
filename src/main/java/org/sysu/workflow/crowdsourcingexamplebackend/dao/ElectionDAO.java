package org.sysu.workflow.crowdsourcingexamplebackend.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sysu.workflow.crowdsourcingexamplebackend.entity.BestElection;
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

    @Autowired
    private BestElectionDAO bestElectionDAO;

    public void save(Election election) {
        electionRepository.save(election);
    }

    public void deleteIfExist(String userId, String index, String stage) {
        electionRepository.deleteElectionByFromIdAndSubTaskIndexAndStage(userId, index, stage);
    }

    public void deleteAll() {
        electionRepository.deleteAll();
    }

    public String getTheBest(String stage) {
        String targetId = "";
        try {
            targetId = (String) electionRepository.findTheBestUserIdByStage(stage).get(0)[0];
            bestElectionDAO.save(new BestElection(stage, "0", targetId));
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        return targetId;
    }

    public List<String> getTheBests(String stage) {
        List<String> bests = new ArrayList<>();
        try {
            int count = subTaskDAO.getCount();
            for (int i = 0; i < count; i++) {
                String bestId = (String) electionRepository.findTheBestUserIdBySubTaskIndexAndStage(i + "", stage).get(0)[0];
                bests.add(bestId);
                bestElectionDAO.save(new BestElection(stage, i + "", bestId));
            }
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        return bests;
    }

    public String getIsComplicated() {
        return (String) electionRepository.getIsComplicated().get(0)[0];
    }

}
