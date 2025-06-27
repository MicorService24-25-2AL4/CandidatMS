package esprit.alt.candidat2al4;

import org.springframework.beans.factory.annotation.Autowired;
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

}
