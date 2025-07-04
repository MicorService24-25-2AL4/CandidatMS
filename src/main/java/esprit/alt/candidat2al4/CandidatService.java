package esprit.alt.candidat2al4;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CandidatService implements ICandidat {
    @Autowired
    private RepositoryCandidat repoCandidat;

    @Autowired
    private JobClient jobClient;
    @Override
    public List<Candidat> gelallCandidats(){
        return repoCandidat.findAll();
    }


    @Override
    public Candidat saveCandidat(Candidat candidat) {
        return repoCandidat.save(candidat);
    }



    @Override
    public Candidat deleteCandidat(int id) {
        Optional<Candidat> candidatOptional = repoCandidat.findById(id);

        if (candidatOptional.isPresent()) {
            Candidat candidat = candidatOptional.get();
            repoCandidat.delete(candidat);
            return candidat;
        } else {
            throw new IllegalArgumentException("Candidat with id " + id + " not found.");
        }
    }

    @Override
    public Candidat updateCandidat(Candidat candidat) {
        if (repoCandidat.existsById(candidat.getId())) {
            return repoCandidat.save(candidat);  // Save the updated Candidat, ID remains unchanged
        } else {
            throw new IllegalArgumentException("Candidat with id " + candidat.getId() + " not found.");
        }
    }

    @Override
    public Candidat getCandidatById(int id) {
        Optional<Candidat> candidatOptional = repoCandidat.findById(id);
        return candidatOptional.orElseThrow(() -> new IllegalArgumentException("Candidat with id " + id + " not found."));
    }

    public List<Job> getallJob(){
        return jobClient.getJobs();
    }
    public Job getjobById(int id){
        return jobClient.getJob(id);
    }
    public List<Job> getFavoriteJobs(int candidateId) {
        Candidat candidate = repoCandidat.findById(candidateId).get();
        return candidate.getFavoriteJobs().stream()
                .map(jobClient::getJob)
                .collect(Collectors.toList());
    }
    public void saveFavoriteJob(int candidateId, int jobId) {
        Candidat candidate = repoCandidat.findById(candidateId).get();
        candidate.getFavoriteJobs().add(jobId);
        repoCandidat.save(candidate);
    }

}
