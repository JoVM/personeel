package be.vdab.services;

import java.util.List;
import java.util.Optional;

import be.vdab.entities.Jobtitel;

public interface JobtitelService {
	List<Jobtitel> findAll();

	Optional<Jobtitel> findOne(long id);
}
