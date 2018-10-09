package org.sysu.workflow.crowdsourcingexamplebackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.sysu.workflow.crowdsourcingexamplebackend.entity.CompletedTask;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Skye on 2018/10/9.
 */
public interface CompletedTaskRepository extends JpaRepository<CompletedTask, Long> {

    @Transactional
    void deleteCompletedTaskByUserIdAndSubTaskIndex(String userId, String subtaskIndex);

    List<CompletedTask> findCompletedTasksBySubTaskIndex(String subtaskIndex);

}
