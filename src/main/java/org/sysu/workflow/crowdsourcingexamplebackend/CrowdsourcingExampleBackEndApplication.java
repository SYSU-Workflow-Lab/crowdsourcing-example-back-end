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
import org.sysu.workflow.crowdsourcingexamplebackend.entity.TipsAndTasks;
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
    public CommandLineRunner init(TipsAndTasksRepository tipsAndTasksRepository) {
        return args -> {
            tipsAndTasksRepository.save(new TipsAndTasks("td", 0, "0 tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips tips 0"));
            tipsAndTasksRepository.save(new TipsAndTasks("td", 1, "1 tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks tasks 1"));
        };
    }
}
