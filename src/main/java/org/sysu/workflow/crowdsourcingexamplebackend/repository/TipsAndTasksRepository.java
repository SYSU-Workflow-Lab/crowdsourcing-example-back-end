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

    /**
     * 根据阶段和类型获取对应的数据
     *
     * @param stage
     * @param type
     * @return
     */
    TipsAndTasks findByStageAndType(String stage, int type);

    /**
     * 更新数据
     *
     * @param stage
     * @param type
     * @param content
     */
    @Modifying
    @Transactional
    @Query(value = "update tips_and_tasks set content = ?3 where stage = ?1 and type = ?2", nativeQuery = true)
    void updateData(String stage, int type, String content);

    /**
     * 删除全部数据
     */
    @Transactional
    @Modifying
    @Query(value = "delete from tips_and_tasks where true", nativeQuery = true)
    void deleteAll();

}
