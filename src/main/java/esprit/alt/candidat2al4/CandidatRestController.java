package esprit.alt.candidat2al4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/candidats")
public class CandidatRestController {


    private String title ="hello from ms candidat 2alt4 version 2";
    @Autowired
    private CandidatService candidatService;
    @GetMapping("/hello")
    public String getTitle() {
        return title;
    }

    @GetMapping
    public List<Candidat> getCandidatList() {
        return candidatService.gelallCandidats();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCandidatById(@PathVariable int id) {
        try {
            Candidat candidat = candidatService.getCandidatById(id);
            return ResponseEntity.ok(candidat);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }


    @PostMapping
    public ResponseEntity<Candidat> createCandidat(@RequestBody Candidat candidat) {
        Candidat created = candidatService.saveCandidat(candidat);
        return ResponseEntity.status(201).body(created);
    }

    @PutMapping
    public Candidat updateCandidat(@RequestBody Candidat candidat) {
        return candidatService.updateCandidat(candidat);
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCandidat(@PathVariable int id) {
        try {
            Candidat deleted = candidatService.deleteCandidat(id);
            return ResponseEntity.ok(deleted);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @GetMapping("/jobs")
    public List<Job> getJobList() {
        return candidatService.getallJob();
    }

    @GetMapping("/jobs/{id}")
    public Job getJob(@PathVariable(value = "id") int id) {
        return candidatService.getjobById(id);
    }
    @GetMapping("/{id}/favorite-jobs")
    public List<Job> getFavoriteJobs(@PathVariable int id) {
        return candidatService.getFavoriteJobs(id);
    }
    @PostMapping("/{id}/favorite-jobs/{jobId}")
    public ResponseEntity<String> saveFavoriteJob(@PathVariable int id, @PathVariable
    int jobId) {
        Job job = candidatService.getjobById(jobId);
        if (job != null) {
            candidatService.saveFavoriteJob(id, jobId);
            return ResponseEntity.status(HttpStatus.OK).body("Job saved as favorite successfully.");
        } else {
            // Gérer le cas où le job n'existe pas
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Job not found with ID: " + jobId);
        }
    }

}
