package org.sysu.workflow.crowdsourcingexamplebackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.sysu.workflow.crowdsourcingexamplebackend.entity.Election;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Skye on 2018/10/8.
 */
public interface ElectionRepository extends JpaRepository<Election, Long> {

    /**
     * 根据提交者id、子任务index和阶段删除对应的投票记录
     *
     * @param fromId
     * @param subTaskIndex
     * @param stage
     */
    @Transactional
    void deleteElectionByFromIdAndSubTaskIndexAndStage(String fromId, String subTaskIndex, String stage);

    /**
     * 删除全部投票数据
     */
    @Transactional
    @Modifying
    @Query(value = "delete from election where true", nativeQuery = true)
    void deleteAll();

    /**
     * 找到某个阶段最佳结果的提交者的id
     *
     * @param stage
     * @return
     */
    @Query(value = "select target_id, count(*) as count from election where stage = ?1 group by target_id order by count desc", nativeQuery = true)
    List<Object[]> findTheBestUserIdByStage(String stage);

    /**
     * 找到某个阶段某个特定子任务index下最佳结果的提交者的id
     *
     * @param subTaskIndex
     * @param stage
     * @return
     */
    @Query(value = "select target_id, count(*) as count from election where sub_task_index = ?1 and stage = ?2 group by target_id order by count desc", nativeQuery = true)
    List<Object[]> findTheBestUserIdBySubTaskIndexAndStage(String subTaskIndex, String stage);

    /**
     * 查看是否为复杂任务
     */
    @Query(value = "select target_id, count(*) as count from election where stage = 'vt' group by target_id order by count desc", nativeQuery = true)
    List<Object[]> getIsComplicated();

}
