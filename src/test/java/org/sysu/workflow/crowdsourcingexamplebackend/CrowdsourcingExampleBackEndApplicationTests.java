package org.sysu.workflow.crowdsourcingexamplebackend;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.sysu.workflow.crowdsourcingexamplebackend.entity.Election;
import org.sysu.workflow.crowdsourcingexamplebackend.entity.SubTask;
import org.sysu.workflow.crowdsourcingexamplebackend.repository.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CrowdsourcingExampleBackEndApplicationTests {

    @Autowired
    TipsAndTasksRepository tipsAndTasksRepository;

    @Autowired
    SubTaskRepository subTaskRepository;

    @Autowired
    ElectionRepository electionRepository;

    @Autowired
    CompletedTaskRepository completedTaskRepository;

    @Autowired
    MergedTaskRepository mergedTaskRepository;

    @Before
    public void dataInit() {
        subTaskRepository.save(new SubTask("user_1", "user 1 : first step"));
        subTaskRepository.save(new SubTask("user_1", "user 1 : second step"));

        subTaskRepository.save(new SubTask("user_2", "user 2 : first step"));
        subTaskRepository.save(new SubTask("user_2", "user 2 : second step"));
        subTaskRepository.save(new SubTask("user_2", "user 2 : third step"));

        subTaskRepository.save(new SubTask("user_3", "user 3 : first step"));
        subTaskRepository.save(new SubTask("user_3", "user 3 : second step"));
        subTaskRepository.save(new SubTask("user_3", "user 3 : third step"));
        subTaskRepository.save(new SubTask("user_3", "user 3 : forth step"));


        electionRepository.save(new Election("qwe", "user_2", "0", "vtd"));
        electionRepository.save(new Election("asd", "user_2", "0", "vtd"));
        electionRepository.save(new Election("zxc", "user_1", "0", "vtd"));

//            completedTaskRepository.save(new CompletedTask("user_1", "user 1 : first solution", "0"));
//            completedTaskRepository.save(new CompletedTask("user_1", "user 1 : second solution", "1"));
//
//            completedTaskRepository.save(new CompletedTask("user_2", "user 2 : first solution", "0"));
//            completedTaskRepository.save(new CompletedTask("user_2", "user 2 : second solution", "1"));
//            completedTaskRepository.save(new CompletedTask("user_2", "user 2 : third solution", "2"));
//
//            completedTaskRepository.save(new CompletedTask("user_3", "user 3 : first solution", "0"));
//            completedTaskRepository.save(new CompletedTask("user_3", "user 3 : second solution", "1"));
//            completedTaskRepository.save(new CompletedTask("user_3", "user 3 : third solution", "2"));

//            electionRepository.save(new Election("qwe", "user_1", "0"));
//            electionRepository.save(new Election("asd", "user_2", "0"));
//            electionRepository.save(new Election("zxc", "user_1", "0"));
//
//            electionRepository.save(new Election("qwe", "user_1", "1"));
//            electionRepository.save(new Election("asd", "user_3", "1"));
//            electionRepository.save(new Election("zxc", "user_3", "1"));
//
//            electionRepository.save(new Election("qwe", "user_2", "2"));
//            electionRepository.save(new Election("asd", "user_3", "2"));

//            mergedTaskRepository.save(new MergedTask("user_1", "user 1 : first solution\nuser 3 : second solution\nuser 2 : third solution"));
//            mergedTaskRepository.save(new MergedTask("user_2", "user 1 : first solution\tuser 3 : second solution\tuser 2 : third solution"));
//            mergedTaskRepository.save(new MergedTask("user_3", "user 1 : first solution.user 3 : second solution.user 2 : third solution"));
    }

    @Test
    public void test1() {

        System.out.println(electionRepository.findTheBestUserIdByStage("vtd").get(0)[0]);

    }

}
