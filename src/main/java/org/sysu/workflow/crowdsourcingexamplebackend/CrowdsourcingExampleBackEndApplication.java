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
import org.sysu.workflow.crowdsourcingexamplebackend.entity.SubTask;
import org.sysu.workflow.crowdsourcingexamplebackend.entity.TipsAndTasks;
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
    public CommandLineRunner init(TipsAndTasksRepository tipsAndTasksRepository, SubTaskRepository subTaskRepository) {
        return args -> {
            tipsAndTasksRepository.save(new TipsAndTasks("td", 0, "0 td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td 0"));
            tipsAndTasksRepository.save(new TipsAndTasks("td", 1, "1 td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td td 1"));

            tipsAndTasksRepository.save(new TipsAndTasks("vtd", 0, "0 vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd 0"));
            tipsAndTasksRepository.save(new TipsAndTasks("vtd", 1, "1 vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd vtd 1"));

            subTaskRepository.save(new SubTask("user_1", "user 1 : first step"));
            subTaskRepository.save(new SubTask("user_1", "user 1 : second step"));

            subTaskRepository.save(new SubTask("user_2", "user 2 : first step"));
            subTaskRepository.save(new SubTask("user_2", "user 2 : second step"));
            subTaskRepository.save(new SubTask("user_2", "user 2 : third step"));

            subTaskRepository.save(new SubTask("user_3", "user 3 : first step"));
            subTaskRepository.save(new SubTask("user_3", "user 3 : second step"));
            subTaskRepository.save(new SubTask("user_3", "user 3 : third step"));

        };
    }
}
