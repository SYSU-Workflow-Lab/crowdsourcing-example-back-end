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
import org.sysu.workflow.crowdsourcingexamplebackend.entity.CompletedTask;
import org.sysu.workflow.crowdsourcingexamplebackend.entity.Election;
import org.sysu.workflow.crowdsourcingexamplebackend.entity.SubTask;
import org.sysu.workflow.crowdsourcingexamplebackend.entity.TipsAndTasks;
import org.sysu.workflow.crowdsourcingexamplebackend.repository.CompletedTaskRepository;
import org.sysu.workflow.crowdsourcingexamplebackend.repository.ElectionRepository;
import org.sysu.workflow.crowdsourcingexamplebackend.repository.SubTaskRepository;
import org.sysu.workflow.crowdsourcingexamplebackend.repository.TipsAndTasksRepository;

@SpringBootApplication
@Configuration
public class CrowdsourcingExampleBackEndApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(CrowdsourcingExampleBackEndApplication.class);
        app.setWebApplicationType(WebApplicationType.SERVLET);
        app.run(args);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("http://localhost:8080");
            }
        };
    }

    @Bean
    public CommandLineRunner init(TipsAndTasksRepository tipsAndTasksRepository,
                                  SubTaskRepository subTaskRepository,
                                  ElectionRepository electionRepository,
                                  CompletedTaskRepository completedTaskRepository) {
        return args -> {
            tipsAndTasksRepository.save(new TipsAndTasks("td", 0, "0 td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td 0"));
            tipsAndTasksRepository.save(new TipsAndTasks("td", 1, "1 td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td 1"));

            tipsAndTasksRepository.save(new TipsAndTasks("tc", 0, "0 tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc 0"));
            tipsAndTasksRepository.save(new TipsAndTasks("tc", 1, "1 tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc tc 1"));

            tipsAndTasksRepository.save(new TipsAndTasks("tm", 0, "0 tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm 0"));
            tipsAndTasksRepository.save(new TipsAndTasks("tm", 1, "1 tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm tm 1"));

            tipsAndTasksRepository.save(new TipsAndTasks("vtd", 0, "0 vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd 0"));
            tipsAndTasksRepository.save(new TipsAndTasks("vtd", 1, "1 vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd 1"));

            tipsAndTasksRepository.save(new TipsAndTasks("vtc", 0, "0 vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc 0"));
            tipsAndTasksRepository.save(new TipsAndTasks("vtc", 1, "1 vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc vtc 1"));

            subTaskRepository.save(new SubTask("user_1", "user 1 : first step"));
            subTaskRepository.save(new SubTask("user_1", "user 1 : second step"));

            subTaskRepository.save(new SubTask("user_2", "user 2 : first step"));
            subTaskRepository.save(new SubTask("user_2", "user 2 : second step"));
            subTaskRepository.save(new SubTask("user_2", "user 2 : third step"));

            subTaskRepository.save(new SubTask("user_3", "user 3 : first step"));
            subTaskRepository.save(new SubTask("user_3", "user 3 : second step"));
            subTaskRepository.save(new SubTask("user_3", "user 3 : third step"));

//            electionRepository.save(new Election("qwe", "user_2", 0));
//            electionRepository.save(new Election("asd", "user_2", 0));
//            electionRepository.save(new Election("zxc", "user_1", 0));

            completedTaskRepository.save(new CompletedTask("user_1", "user 1 : first solution", "0"));
            completedTaskRepository.save(new CompletedTask("user_1", "user 1 : second solution", "1"));

            completedTaskRepository.save(new CompletedTask("user_2", "user 2 : first solution", "0"));
            completedTaskRepository.save(new CompletedTask("user_2", "user 2 : second solution", "1"));
            completedTaskRepository.save(new CompletedTask("user_2", "user 2 : third solution", "2"));

            completedTaskRepository.save(new CompletedTask("user_3", "user 3 : first solution", "0"));
            completedTaskRepository.save(new CompletedTask("user_3", "user 3 : second solution", "1"));
            completedTaskRepository.save(new CompletedTask("user_3", "user 3 : third solution", "2"));

            electionRepository.save(new Election("qwe", "user_1", "0"));
            electionRepository.save(new Election("asd", "user_2", "0"));
            electionRepository.save(new Election("zxc", "user_1", "0"));

            electionRepository.save(new Election("qwe", "user_1", "1"));
            electionRepository.save(new Election("asd", "user_3", "1"));
            electionRepository.save(new Election("zxc", "user_3", "1"));

            electionRepository.save(new Election("qwe", "user_2", "2"));
            electionRepository.save(new Election("asd", "user_3", "2"));

        };
    }
}
