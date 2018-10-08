package org.sysu.workflow.crowdsourcingexamplebackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.sysu.workflow.crowdsourcingexamplebackend.entity.Election;

import javax.transaction.Transactional;

/**
 * Created by Skye on 2018/10/8.
 */
public interface ElectionRepository extends JpaRepository<Election, Long> {

    @Transactional
    void deleteElectionByFromId(String fromId);

}
