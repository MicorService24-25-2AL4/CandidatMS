package esprit.alt.candidat2al4;

import java.util.List;

public interface ICandidat {

    public List<Candidat> gelallCandidats();
    public Candidat saveCandidat(Candidat candidat);
    public Candidat deleteCandidat(int id);
    public Candidat updateCandidat(Candidat candidat);
    public Candidat getCandidatById(int id);
}
