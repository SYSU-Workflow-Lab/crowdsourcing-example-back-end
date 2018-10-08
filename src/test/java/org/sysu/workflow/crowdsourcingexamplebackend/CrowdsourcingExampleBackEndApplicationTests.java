package org.sysu.workflow.crowdsourcingexamplebackend;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.sysu.workflow.crowdsourcingexamplebackend.repository.ElectionRepository;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CrowdsourcingExampleBackEndApplicationTests {

    @Autowired
    private ElectionRepository electionRepository;

    @Test
    public void test1() {
        assertThat((String) electionRepository.findTheBestUserId().get(0)[0]).isEqualTo("user_2");
    }

}
