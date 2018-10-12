package org.sysu.workflow.crowdsourcingexamplebackend.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sysu.workflow.crowdsourcingexamplebackend.entity.SubTask;
import org.sysu.workflow.crowdsourcingexamplebackend.entity.VotePageData;
import org.sysu.workflow.crowdsourcingexamplebackend.repository.SubTaskRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Skye on 2018/9/29.
 */
@Repository
public class SubTaskDAO {

    @Autowired
    private SubTaskRepository subTaskRepository;

    private int count;

    /**
     * 存储新数据
     *
     * @param subTask
     */
    public void save(SubTask subTask) {
        subTaskRepository.save(subTask);
    }

    /**
     * 根据提交者id删除已有的数据
     *
     * @param userId
     */
    public void deleteIfExist(String userId) {
        subTaskRepository.deleteSubTasksByUserId(userId);
    }

    /**
     * 删除所有数据
     */
    public void deleteAll() {
        subTaskRepository.deleteAll();
    }

    /**
     * 获取投票页面显示所用数据
     *
     * @return
     */
    public List<VotePageData> getVotePageData() {
        List<VotePageData> result = new ArrayList<>();
        List<String> userIds = subTaskRepository.findAllUserId();
        for (int i = 0; i < userIds.size(); i++) {
            List<String> contents = subTaskRepository.findContentsByUserId(userIds.get(i));
            result.add(new VotePageData(userIds.get(i), contents));
        }
        return result;
    }

    /**
     * 根据提交者id获取对应的提交内容列表
     *
     * @param userId
     * @return
     */
    public List<String> getSubTaskByUserId(String userId) {
        return subTaskRepository.findContentsByUserId(userId);
    }

    /**
     * 根据提交者id和子任务index获取对应的提交内容
     *
     * @param userId
     * @param index
     * @return
     */
    public String getSubTaskByUserIdAndIndex(String userId, int index) {
        List<String> contents = subTaskRepository.findContentsByUserId(userId);
        return contents.get(index);
    }

    /**
     * 获取子任务个数
     */
    public int getCount() {
        return count;
    }

    /**
     * 设置子任务个数
     *
     * @param targetId
     */
    public void setCount(String targetId) {
        count = subTaskRepository.getCountByUserId(targetId);
    }
}
