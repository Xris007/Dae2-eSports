package pe.isil.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pe.isil.model.Tournament;
import pe.isil.service.TournamentService;

import java.util.List;

@Controller
public class TournamentController {
    final TournamentService tournamentService;

    public TournamentController(TournamentService tournamentService){
        this.tournamentService = tournamentService;
    }

    @GetMapping("/tournament")
    public String getTournament(Model model){
        List<Tournament> tournaments = tournamentService.getAll();
        model.addAttribute("tournaments", tournaments);
        return "tournament";
    }

}
