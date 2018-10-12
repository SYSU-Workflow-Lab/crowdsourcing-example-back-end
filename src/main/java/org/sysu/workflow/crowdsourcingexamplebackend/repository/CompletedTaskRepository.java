package org.sysu.workflow.crowdsourcingexamplebackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.sysu.workflow.crowdsourcingexamplebackend.entity.CompletedTask;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Skye on 2018/10/9.
 */
public interface CompletedTaskRepository extends JpaRepository<CompletedTask, Long> {

    /**
     * 根据提交者id和子任务index删除对应的任务完成结果
     *
     * @param userId
     * @param subtaskIndex
     */
    @Transactional
    void deleteCompletedTaskByUserIdAndSubTaskIndex(String userId, String subtaskIndex);

    /**
     * 根据子任务index获取任务完成结果的列表
     *
     * @param subtaskIndex
     * @return list of completed task
     */
    List<CompletedTask> findCompletedTasksBySubTaskIndex(String subtaskIndex);

    /**
     * 根据提交者id和所做子任务的index获取对应的任务完成结果
     *
     * @param userId
     * @param subTaskIndex
     * @return a completed task
     */
    CompletedTask findCompletedTaskByUserIdAndSubTaskIndex(String userId, String subTaskIndex);

}
