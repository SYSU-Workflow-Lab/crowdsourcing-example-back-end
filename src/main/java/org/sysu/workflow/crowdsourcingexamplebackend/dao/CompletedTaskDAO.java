package org.sysu.workflow.crowdsourcingexamplebackend.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sysu.workflow.crowdsourcingexamplebackend.entity.CompletedTask;
import org.sysu.workflow.crowdsourcingexamplebackend.entity.VotePageData;
import org.sysu.workflow.crowdsourcingexamplebackend.repository.CompletedTaskRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Skye on 2018/10/9.
 */

@Repository
public class CompletedTaskDAO {

    @Autowired
    private CompletedTaskRepository completedTaskRepository;

    /**
     * 存储新数据
     *
     * @param completedTask
     */
    public void save(CompletedTask completedTask) {
        completedTaskRepository.save(completedTask);
    }

    /**
     * 根据提交者id和任务index删除已有的数据
     *
     * @param userId
     * @param index
     */
    public void deleteIfExist(String userId, String index) {
        completedTaskRepository.deleteCompletedTaskByUserIdAndSubTaskIndex(userId, index);
    }

    /**
     * 删除所有数据
     */
    public void deleteAll() {
        completedTaskRepository.deleteAll();
    }

    /**
     * 获取投票页面显示所用数据
     *
     * @param index
     * @return
     */
    public List<VotePageData> getVotePageData(String index) {
        List<VotePageData> result = new ArrayList<>();
        List<CompletedTask> completedTaskList = completedTaskRepository.findCompletedTasksBySubTaskIndex(index);
        for (int i = 0; i < completedTaskList.size(); i++) {
            List<String> contents = new ArrayList<>();
            contents.add(completedTaskList.get(i).getContent());
            result.add(new VotePageData(completedTaskList.get(i).getUserId(), contents));
        }
        return result;
    }

    /**
     * 根据提交者id和所做任务的index获取对应的任务完成结果
     *
     * @param userId
     * @param subTaskId
     * @return
     */
    public String findContentByUserIdAndSubTaskIndex(String userId, String subTaskId) {
        CompletedTask temp = completedTaskRepository.findCompletedTaskByUserIdAndSubTaskIndex(userId, subTaskId);
        if (temp == null) {
            return "No Data";
        } else {
            return temp.getContent();
        }
    }

}
