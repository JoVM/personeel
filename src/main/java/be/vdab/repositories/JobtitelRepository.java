package be.vdab.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import be.vdab.entities.Jobtitel;

public interface JobtitelRepository extends JpaRepository<Jobtitel, Long> {
	Optional<Jobtitel> findOne(long id);
}
