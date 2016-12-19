package be.vdab.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import be.vdab.entities.Werknemer;

public interface WerknemerRepository extends JpaRepository<Werknemer, Long> {
	public Werknemer findByChef(Integer id);

	Optional<Werknemer> findOne(long id);
}
