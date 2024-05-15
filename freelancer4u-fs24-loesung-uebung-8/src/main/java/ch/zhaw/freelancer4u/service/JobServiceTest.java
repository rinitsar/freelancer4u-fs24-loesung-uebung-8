package ch.zhaw.freelancer4u.service;

import ch.zhaw.freelancer4u.model.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class JobServiceTest {

    @Autowired
    private JobService jobService;

    private Job createdJob;

    @Test
    @Order
    public void createJobTest() {
        // Implement the test to create a job
    }

    @Test
    @Order
    public void listJobsTest() {
        // Implement the test to list all jobs and check if the created job is present
    }

    @Test
    @Order
    public void deleteJobTest() {
        // Implement the test to delete the created job
    }
}