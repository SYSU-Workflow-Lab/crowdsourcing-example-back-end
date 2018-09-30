package org.sysu.workflow.crowdsourcingexamplebackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.sysu.workflow.crowdsourcingexamplebackend.entity.SubTask;

import javax.transaction.Transactional;

/**
 * Created by Skye on 2018/9/29.
 */
public interface SubTaskRepository extends JpaRepository<SubTask, Long> {

    @Transactional
    void deleteSubTasksByUserId(String userId);

}
