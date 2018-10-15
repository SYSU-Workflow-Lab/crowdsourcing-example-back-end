package org.sysu.workflow.crowdsourcingexamplebackend.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sysu.workflow.crowdsourcingexamplebackend.entity.Election;
import org.sysu.workflow.crowdsourcingexamplebackend.repository.ElectionRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Skye on 2018/10/8.
 */

@Repository
public class ElectionDAO {

    @Autowired
    private ElectionRepository electionRepository;

    @Autowired
    private SubTaskDAO subTaskDAO;

    /**
     * 存储新数据
     *
     * @param election
     */
    public void save(Election election) {
        electionRepository.save(election);
    }

    /**
     * 根据提交者id、任务index和阶段删除已有的数据
     *
     * @param userId
     * @param index
     * @param stage
     */
    public void deleteIfExist(String userId, String index, String stage) {
        electionRepository.deleteElectionByFromIdAndSubTaskIndexAndStage(userId, index, stage);
    }

    /**
     * 删除所有数据
     */
    public void deleteAll() {
        electionRepository.deleteAll();
    }

    /**
     * 获取得票最多的提交者id
     *
     * @param stage
     * @return
     */
    public String getTheBest(String stage) {
        String targetId = "";
        List<Object[]> temp = electionRepository.findTheBestUserIdByStage(stage);
        if (!temp.isEmpty() && temp.get(0).length != 0) {
            targetId = (String) temp.get(0)[0];
        }
        return targetId;
    }

    /**
     * 获取得票最多的提交者id列表
     *
     * @param stage
     * @return
     */
    public List<String> getTheBests(String stage) {
        List<String> bests = new ArrayList<>();
        int count = subTaskDAO.getCount();
        for (int i = 0; i < count; i++) {
            List<Object[]> temp = electionRepository.findTheBestUserIdBySubTaskIndexAndStage(i + "", stage);
            if (!temp.isEmpty() && temp.get(0).length != 0) {
                bests.add((String) temp.get(0)[0]);
            } else {
                bests.add("");
            }
        }
        return bests;
    }

    /**
     * 获取任务是否为复杂任务
     *
     * @return
     */
    public String getIsComplicated() {
        String result = "No Data";
        List<Object[]> temp = electionRepository.getIsComplicated();
        if (!temp.isEmpty() && temp.get(0).length != 0) {
            result = (String) temp.get(0)[0];
        }
        return result;
    }

    /**
     * 获取某个阶段的投票总数
     *
     * @param stage
     */
    public int getCountOfStage(String stage) {
        return electionRepository.getCountOfStage(stage);
    }

}
