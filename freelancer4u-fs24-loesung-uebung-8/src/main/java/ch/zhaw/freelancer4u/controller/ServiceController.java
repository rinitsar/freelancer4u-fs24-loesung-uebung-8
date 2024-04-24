package ch.zhaw.freelancer4u.controller;

import java.util.Optional;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ch.zhaw.freelancer4u.model.Job;
import ch.zhaw.freelancer4u.model.JobStateChangeDTO;
import ch.zhaw.freelancer4u.service.JobService;
import ch.zhaw.freelancer4u.service.RoleService;

@RestController
@RequestMapping("/api/service")
public class ServiceController {
    
    @Autowired
    RoleService roleService;

    @PutMapping("/assignjob")
    public ResponseEntity<Job> assignJob(
     @RequestBody JobStateChangeDTO changeS,
     @AuthenticationPrincipal Jwt jwt) {
    if (!roleService.hasRole("admin", jwt)) {
    return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }
    
    return null;
    }
 

    @PutMapping("/completejob")
    public ResponseEntity<Job> completeJob(
        @RequestBody JobStateChangeDTO changeS,
        @AuthenticationPrincipal Jwt jwt) {
       if (!roleService.hasRole("admin", jwt)) {
       return new ResponseEntity<>(HttpStatus.FORBIDDEN);
       }
       //...
    return null;
       }

    @PutMapping("/me/assignjob")
    public ResponseEntity<Job> assignToMe(@RequestParam String jobId,
     @AuthenticationPrincipal Jwt jwt) {
    String userEmail = jwt.getClaimAsString("email");
    JobService jobService = new JobService(); // Initialize jobService
    Optional<Job> job = jobService.assignJob(jobId, userEmail);
    if (job.isPresent()) {
    return new ResponseEntity<>(job.get(), HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }


@PutMapping("/me/completejob")
public ResponseEntity<Job> completeJob(@RequestParam String jobId, @AuthenticationPrincipal Jwt jwt) {
    String userEmail = jwt.getClaimAsString("email");
    JobService jobService = new JobService(); // Initialize jobService
    Optional<Job> job = jobService.completeJob(jobId, userEmail);
    if (job.isPresent()) {
        return new ResponseEntity<>(job.get(), HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
}

}