package org.sysu.workflow.crowdsourcingexamplebackend.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sysu.workflow.crowdsourcingexamplebackend.entity.BestElection;
import org.sysu.workflow.crowdsourcingexamplebackend.repository.BestElectionRepository;

/**
 * Created by Skye on 2018/10/11.
 */

@Repository
public class BestElectionDAO {

    @Autowired
    private BestElectionRepository bestElectionRepository;

    public void save(BestElection bestElection) {
        bestElectionRepository.save(bestElection);
    }

}
