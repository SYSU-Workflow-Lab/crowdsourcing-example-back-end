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

    /**
     * 根据提交者id删除合并的任务
     *
     * @param userId
     */
    @Transactional
    void deleteMergedTasksByUserId(String userId);

    /**
     * 获取所有的提交者的id
     */
    @Query(value = "select user_id from merged_task group by user_id", nativeQuery = true)
    List<String> findAllUserId();

    /**
     * 根据提交者id获取对应的提交内容
     *
     * @param userId
     * @return
     */
    @Query(value = "select content from merged_task where user_id = ?1", nativeQuery = true)
    List<String> findContentsByUserId(String userId);

}
