package org.sysu.workflow.crowdsourcingexamplebackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.sysu.workflow.crowdsourcingexamplebackend.entity.SubTask;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Skye on 2018/9/29.
 */
public interface SubTaskRepository extends JpaRepository<SubTask, Long> {

    @Transactional
    void deleteSubTasksByUserId(String userId);

    @Query(value = "select user_id from sub_task group by user_id", nativeQuery = true)
    List<String> findAllUserId();

    @Query(value = "select content from sub_task where user_id = ?1", nativeQuery = true)
    List<String> findContentsByUserId(String userId);

}
