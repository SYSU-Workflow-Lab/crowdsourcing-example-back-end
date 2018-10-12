package org.sysu.workflow.crowdsourcingexamplebackend.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sysu.workflow.crowdsourcingexamplebackend.entity.MergedTask;
import org.sysu.workflow.crowdsourcingexamplebackend.entity.VotePageData;
import org.sysu.workflow.crowdsourcingexamplebackend.repository.MergedTaskRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Skye on 2018/10/10.
 */
@Repository
public class MergedTaskDAO {

    @Autowired
    private MergedTaskRepository mergedTaskRepository;

    /**
     * 存储新数据
     *
     * @param mergedTask
     */
    public void save(MergedTask mergedTask) {
        mergedTaskRepository.save(mergedTask);
    }

    /**
     * 根据提交者id删除已有的数据
     *
     * @param userId
     */
    public void deleteIfExist(String userId) {
        mergedTaskRepository.deleteMergedTasksByUserId(userId);
    }

    /**
     * 删除所有数据
     */
    public void deleteAll() {
        mergedTaskRepository.deleteAll();
    }

    /**
     * 获取投票页面显示所用数据
     *
     * @return
     */
    public List<VotePageData> getVotePageData() {
        List<VotePageData> result = new ArrayList<>();
        List<String> userIds = mergedTaskRepository.findAllUserId();
        for (int i = 0; i < userIds.size(); i++) {
            List<String> contents = mergedTaskRepository.findContentsByUserId(userIds.get(i));
            result.add(new VotePageData(userIds.get(i), contents));
        }
        return result;
    }

    /**
     * 根据提交者id获取对应的提交内容
     *
     * @param userId
     * @return
     */
    public String findContentByUserId(String userId) {
        return mergedTaskRepository.findContentsByUserId(userId).get(0);
    }

}
