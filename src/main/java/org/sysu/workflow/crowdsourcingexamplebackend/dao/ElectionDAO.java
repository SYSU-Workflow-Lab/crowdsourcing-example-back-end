package org.sysu.workflow.crowdsourcingexamplebackend.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sysu.workflow.crowdsourcingexamplebackend.entity.Election;
import org.sysu.workflow.crowdsourcingexamplebackend.repository.ElectionRepository;

/**
 * Created by Skye on 2018/10/8.
 */

@Repository
public class ElectionDAO {

    @Autowired
    private ElectionRepository electionRepository;

    public void save(Election election) {
        electionRepository.save(election);
    }

    public void deleteIfExist(String userId) {
        electionRepository.deleteElectionByFromId(userId);
    }

}
