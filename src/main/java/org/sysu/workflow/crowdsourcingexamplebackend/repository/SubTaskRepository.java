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

    /**
     * 根据提交者id删除对应的记录
     *
     * @param userId
     */
    @Transactional
    void deleteSubTasksByUserId(String userId);

    /**
     * 获取所有的提交者的id
     */
    @Query(value = "select user_id from sub_task group by user_id", nativeQuery = true)
    List<String> findAllUserId();

    /**
     * 根据提交者id获取对应的提交内容列表
     *
     * @param userId
     * @return
     */
    @Query(value = "select content from sub_task where user_id = ?1", nativeQuery = true)
    List<String> findContentsByUserId(String userId);

    /**
     * 根据提交者id获取对应提交内容的子内容个数
     *
     * @param userId
     * @return
     */
    @Query(value = "select count(*) from sub_task where user_id = ?1", nativeQuery = true)
    int getCountByUserId(String userId);

}
