package com.example.MySQLApi.controller;

import com.example.MySQLApi.dao.PersoaneRepository;
import com.example.MySQLApi.model.Persoane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Optional;

@Controller
@RequestMapping(path = "/api")
public class PersoaneController {
    @Autowired
    private PersoaneRepository persoaneRepository;

    @PostMapping(path = "/addBody")
    public @ResponseBody String addPerson(@Valid @NonNull @RequestBody Persoane persoane) {
        Persoane p = new Persoane(persoane.getNume(), persoane.getPrenume(),persoane.getVarsta());
        persoaneRepository.save(p);
        return "Saved! "+p.getNume()+" "+p.getPrenume()+" "+p.getVarsta();
    }

    @PostMapping(path = "/add")
        public @ResponseBody String addPerson(@RequestParam @NotNull String nume,
                                              @RequestParam @NotNull String prenume,
                                              @RequestParam @NotNull Integer varsta) {
            if(!nume.isBlank() && !prenume.isBlank()) {
                Persoane p = new Persoane(nume, prenume, varsta);
                persoaneRepository.save(p);
                return "Saved! " + p.getNume() + " " + p.getPrenume() + " " + p.getVarsta();
            }else{
                return "Blank fields";
            }
        }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Persoane> getAll(){
        return persoaneRepository.findAll();
    }

    @GetMapping(path = "/find")
    public @ResponseBody Optional<Persoane> getOne(@RequestParam @NotNull Integer id){
        return persoaneRepository.findById(id);
    }

    @PutMapping(path = "/replace")
    public @ResponseBody String replaceUser(@Valid @NotNull @RequestBody Persoane persoana,
                                            @RequestParam @NotNull Integer id){
        Optional<Persoane> p = persoaneRepository.findById(id);
        if(p.isPresent()){
            Persoane pUp = p.get();
            pUp.setNume(persoana.getNume());
            pUp.setPrenume(persoana.getPrenume());
            pUp.setVarsta(persoana.getVarsta());
            persoaneRepository.save(pUp);
            return "Updated";
        }else{
            return "Invalid ID";
        }
    }

    @DeleteMapping(path = "/delete")
    public @ResponseBody String deleteUser(@Valid @NotNull @RequestParam Integer id){
        Optional<Persoane> p = persoaneRepository.findById(id);
        if(p.isPresent()){
            persoaneRepository.deleteById(id);
            return "Deleted!";
        }
        return "Invalid ID";
    }
}
