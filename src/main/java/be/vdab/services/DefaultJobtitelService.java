package be.vdab.services;

import java.util.List;
import java.util.Optional;

import be.vdab.entities.Jobtitel;
import be.vdab.repositories.JobtitelRepository;

@ReadOnlyTransactionalService
public class DefaultJobtitelService implements JobtitelService {

	private final JobtitelRepository jobtitelRepository;

	public DefaultJobtitelService(JobtitelRepository jobtitelRepository) {
		this.jobtitelRepository = jobtitelRepository;
	}

	@Override
	public List<Jobtitel> findAll() {
		return jobtitelRepository.findAll();
	}

	@Override
	public Optional<Jobtitel> findOne(long id) {
		return jobtitelRepository.findOne(id);
	}

}
