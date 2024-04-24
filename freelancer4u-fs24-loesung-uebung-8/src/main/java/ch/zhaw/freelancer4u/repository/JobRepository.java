package ch.zhaw.freelancer4u.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ch.zhaw.freelancer4u.model.Job;
import ch.zhaw.freelancer4u.model.JobType;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

public interface JobRepository extends MongoRepository<Job,String>{
    Page<Job> findByEarningsGreaterThan(Double earnings, Pageable pageable);
Page<Job> findByJobType(JobType jobType, Pageable pageable);
 Page<Job> findByJobTypeAndEarningsGreaterThan(JobType jobType, Double earnings,
Pageable pageable);
}
