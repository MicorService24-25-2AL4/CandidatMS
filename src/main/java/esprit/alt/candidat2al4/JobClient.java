package esprit.alt.candidat2al4;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(name = "JobALT4")
public interface JobClient {
    @RequestMapping("/jobs")
    public List<Job> getJobs();
    @RequestMapping("/jobs/{id}")
    public Job getJob(@PathVariable(value = "id") int id);
}
