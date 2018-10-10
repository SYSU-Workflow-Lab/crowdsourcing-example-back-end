package org.sysu.workflow.crowdsourcingexamplebackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.sysu.workflow.crowdsourcingexamplebackend.entity.MergedTask;

import javax.transaction.Transactional;

/**
 * Created by Skye on 2018/10/10.
 */
public interface MergedTaskRepository extends JpaRepository<MergedTask, Long> {

    @Transactional
    void deleteMergedTasksByUserId(String userId);

}
