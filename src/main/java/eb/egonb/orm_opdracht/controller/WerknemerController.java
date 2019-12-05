package eb.egonb.orm_opdracht.controller;

import eb.egonb.orm_opdracht.model.Werknemer;
import eb.egonb.orm_opdracht.model.WerknemerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(value = "/werknemers")
public class WerknemerController {

    @Autowired
    WerknemerDAO dao;

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public Iterable<Werknemer> geefAlleWerknemers(){
        return dao.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Optional<Werknemer> zoekOpId(@PathVariable(value = "id") int id){
        return dao.findById(id);
    }

    @RequestMapping(value = "")
    @ResponseBody
    public Iterable<Werknemer> opNaamZoeken(@PathVariable(value = "naam") String naam){
        return dao.zoekBijNaam(naam);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity voegWerknemerToe(@RequestParam(value = "naam") String naam,
                                           @RequestParam(value = "telefoon") String telefoon,
                                           @RequestParam(value = "email") String email){

        Werknemer nWerknemer = new Werknemer();
        nWerknemer.setNaam(naam);
        nWerknemer.setTelefoonNr(telefoon);
        nWerknemer.setEmail(email);

        dao.save(nWerknemer);

        return new ResponseEntity(HttpStatus.OK);
    }

}
