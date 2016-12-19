package be.vdab.services;

import java.math.BigDecimal;
import java.util.Optional;

import be.vdab.entities.Werknemer;
import be.vdab.repositories.WerknemerRepository;

@ReadOnlyTransactionalService
public class DefaultWerknemerService implements WerknemerService {

	private final WerknemerRepository werknemerRepository;

	DefaultWerknemerService(WerknemerRepository werknemerRepository) {
		this.werknemerRepository = werknemerRepository;
	}

	@Override
	public Werknemer findByChef(Integer id) {
		return werknemerRepository.findByChef(id);
	}

	@Override
	public Optional<Werknemer> findOne(long id) {
		return werknemerRepository.findOne(id);
	}

	@ModifyingTransactionalServiceMethod
	@Override
	public void save(Werknemer werknemer) {
		werknemerRepository.save(werknemer);

	}

	@ModifyingTransactionalServiceMethod
	@Override
	public void geefOpslag(long id, BigDecimal bedrag) {
		Werknemer werknemerOpslag = findOne(id).get();
		werknemerOpslag.geefOpslag(bedrag);
		save(werknemerOpslag);

	}

}
