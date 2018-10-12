package org.sysu.workflow.crowdsourcingexamplebackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.sysu.workflow.crowdsourcingexamplebackend.entity.TipsAndTasks;

import javax.transaction.Transactional;

/**
 * Created by Skye on 2018/9/30.
 */
public interface TipsAndTasksRepository extends JpaRepository<TipsAndTasks, Long> {

    TipsAndTasks findByStageAndType(String stage, int type);

    @Modifying
    @Transactional
    @Query(value = "update tips_and_tasks set content = ?3 where stage = ?1 and type = ?2", nativeQuery = true)
    void updateData(String stage, int type, String content);

}
