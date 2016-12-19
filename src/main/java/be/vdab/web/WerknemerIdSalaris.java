package be.vdab.web;

import java.math.BigDecimal;

public interface WerknemerIdSalaris {
	void setId(long id);

	long getId();

	void setSalaris(BigDecimal salaris);

	BigDecimal getSalaris();
}
