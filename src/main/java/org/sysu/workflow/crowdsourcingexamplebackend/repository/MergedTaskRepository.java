package org.sysu.workflow.crowdsourcingexamplebackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.sysu.workflow.crowdsourcingexamplebackend.entity.MergedTask;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Skye on 2018/10/10.
 */
public interface MergedTaskRepository extends JpaRepository<MergedTask, Long> {

    @Transactional
    void deleteMergedTasksByUserId(String userId);

    @Query(value = "select user_id from merged_task group by user_id", nativeQuery = true)
    List<String> findAllUserId();

    @Query(value = "select content from merged_task where user_id = ?1", nativeQuery = true)
    List<String> findContentsByUserId(String userId);

}
