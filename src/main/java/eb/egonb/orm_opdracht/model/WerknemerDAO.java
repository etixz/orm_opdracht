package eb.egonb.orm_opdracht.model;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface WerknemerDAO extends CrudRepository<Werknemer, Integer> {

    @Query(value = "select w from Werknemer w where w.naam = :naam")
    Iterable<Werknemer> zoekBijNaam(String naam);
}
