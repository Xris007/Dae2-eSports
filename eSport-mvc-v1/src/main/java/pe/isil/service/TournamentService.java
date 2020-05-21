package pe.isil.service;

import org.springframework.stereotype.Service;
import pe.isil.model.Tournament;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TournamentService {

    List<Tournament> tournaments = new ArrayList<>(
            Arrays.asList(
                    new Tournament(1,"Boston Tournament","Perulandia","Grand Bruce Arena")
            )
    );


    public List<Tournament> getAll(){
        return tournaments;
    }

    public void save(Tournament tournament){
        tournaments.add(tournament);
    }

    public void delete(Tournament tournament){
        tournaments.remove(tournament);
    }

    public void update(Tournament tournament){
        Tournament currentTournament = findById(tournament.getId());

        if (currentTournament != null){
            int index = tournaments.indexOf(currentTournament);
            tournament.setId(currentTournament.getId());
            tournaments.set(index, tournament);
        }


    }

    private Tournament findById(Integer id) {
        Tournament tournament = tournaments.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst()
                .orElseGet(null);
        return tournament;
    }
}
