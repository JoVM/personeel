package be.vdab.services;

import java.math.BigDecimal;
import java.util.Optional;

import be.vdab.entities.Werknemer;

public interface WerknemerService {
	public Werknemer findByChef(Integer id);

	Optional<Werknemer> findOne(long id);

	void save(Werknemer werknemer);

	void geefOpslag(long id, BigDecimal bedrag);
}
