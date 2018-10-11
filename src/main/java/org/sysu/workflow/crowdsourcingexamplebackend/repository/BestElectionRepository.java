package org.sysu.workflow.crowdsourcingexamplebackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.sysu.workflow.crowdsourcingexamplebackend.entity.BestElection;

/**
 * Created by Skye on 2018/10/11.
 */
public interface BestElectionRepository extends JpaRepository<BestElection, Long> {
}
