package org.sysu.workflow.crowdsourcingexamplebackend;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.sysu.workflow.crowdsourcingexamplebackend.entity.*;
import org.sysu.workflow.crowdsourcingexamplebackend.repository.*;

@SpringBootApplication
@Configuration
public class CrowdsourcingExampleBackEndApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(CrowdsourcingExampleBackEndApplication.class);
        app.setWebApplicationType(WebApplicationType.SERVLET);
        app.run(args);
    }

    /**
     * 初始化数据
     */
    @Bean
    public CommandLineRunner init(TipsAndTasksRepository tipsAndTasksRepository,
                                  SubTaskRepository subTaskRepository,
                                  ElectionRepository electionRepository,
                                  CompletedTaskRepository completedTaskRepository,
                                  MergedTaskRepository mergedTaskRepository) {
        return args -> {
            tipsAndTasksRepository.deleteAll();

            tipsAndTasksRepository.save(new TipsAndTasks("td", 0, "任务分解"));
            tipsAndTasksRepository.save(new TipsAndTasks("td", 1, "根据您的思考，分解原始任务为多个子任务。"));

            tipsAndTasksRepository.save(new TipsAndTasks("tc", 0, "完成子任务"));
            tipsAndTasksRepository.save(new TipsAndTasks("tc", 1, "根据您的思考，完成子任务。"));

            tipsAndTasksRepository.save(new TipsAndTasks("tm", 0, "合并完成的子任务结果"));
            tipsAndTasksRepository.save(new TipsAndTasks("tm", 1, "根据您的思考，合并完成的子任务结果。"));

            tipsAndTasksRepository.save(new TipsAndTasks("vt", 0, "选举是否为困难任务"));
            tipsAndTasksRepository.save(new TipsAndTasks("vt", 1, "本任务是撰写论文的众包任务。根据您的思考，判断原始任务是否为困难任务。"));

            tipsAndTasksRepository.save(new TipsAndTasks("vtd", 0, "对任务分解的结果投票"));
            tipsAndTasksRepository.save(new TipsAndTasks("vtd", 1, "根据您的思考，对任务分解的结果进行投票，选择您认为最合适的任务分解结果。"));

            tipsAndTasksRepository.save(new TipsAndTasks("vtc", 0, "对完成的子任务投票"));
            tipsAndTasksRepository.save(new TipsAndTasks("vtc", 1, "根据您的思考，对完成的子任务结果投票，选择您认为最合适的子任务结果。"));

            tipsAndTasksRepository.save(new TipsAndTasks("vtm", 0, "对合并子任务的最终结果投票"));
            tipsAndTasksRepository.save(new TipsAndTasks("vtm", 1, "根据您的思考，对合并子任务的最终结果投票，选择您认为最合适的最终结果"));

//            electionRepository.save(new Election("qwe", "Simple", "0", "vt"));
//            electionRepository.save(new Election("asd", "Complicated", "0", "vt"));
//            electionRepository.save(new Election("zxc", "Complicated", "0", "vt"));
//
//            subTaskRepository.save(new SubTask("user_1", "user 1 : first step"));
//            subTaskRepository.save(new SubTask("user_1", "user 1 : second step"));
//
//            subTaskRepository.save(new SubTask("user_2", "user 2 : first step"));
//            subTaskRepository.save(new SubTask("user_2", "user 2 : second step"));
//            subTaskRepository.save(new SubTask("user_2", "user 2 : third step"));
//
//            subTaskRepository.save(new SubTask("user_3", "user 3 : first step"));
//            subTaskRepository.save(new SubTask("user_3", "user 3 : second step"));
//            subTaskRepository.save(new SubTask("user_3", "user 3 : third step"));
//
//            electionRepository.save(new Election("qwe", "user_2", "0", "vtd"));
//            electionRepository.save(new Election("asd", "user_2", "0", "vtd"));
//            electionRepository.save(new Election("zxc", "user_1", "0", "vtd"));
//
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
//
//            electionRepository.save(new Election("qwe", "user_1", "0", "vtc"));
//            electionRepository.save(new Election("asd", "user_2", "0", "vtc"));
//            electionRepository.save(new Election("zxc", "user_1", "0", "vtc"));
//
//            electionRepository.save(new Election("qwe", "user_1", "1", "vtc"));
//            electionRepository.save(new Election("asd", "user_3", "1", "vtc"));
//            electionRepository.save(new Election("zxc", "user_3", "1", "vtc"));
//
//            electionRepository.save(new Election("qwe", "user_2", "2", "vtc"));
//            electionRepository.save(new Election("asd", "user_3", "2", "vtc"));
//
//            mergedTaskRepository.save(new MergedTask("user_1", "user1:\r\nuser 1 : first solution\r\nuser 3 : second solution\r\nuser 2 : third solution"));
//            mergedTaskRepository.save(new MergedTask("user_2", "user2:\r\nuser 1 : first solution\r\nuser 3 : second solution\r\nuser 2 : third solution"));
//            mergedTaskRepository.save(new MergedTask("user_3", "user3:\r\nuser 1 : first solution\r\nuser 3 : second solution\r\nuser 2 : third solution"));
//
//            electionRepository.save(new Election("qwe", "user_2", "0", "vtm"));
//            electionRepository.save(new Election("asd", "user_2", "0", "vtm"));
//            electionRepository.save(new Election("zxc", "user_1", "0", "vtm"));

        };
    }
}
