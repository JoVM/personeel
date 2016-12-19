package be.vdab.web;

import java.io.Serializable;
import java.math.BigDecimal;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class WerknemerIdSalarisImpl implements WerknemerIdSalaris, Serializable {
	private static final long serialVersionUID = 1L;

	private long id;
	private BigDecimal salaris;

	@Override
	public void setId(long id) {
		this.id = id;

	}

	@Override
	public long getId() {
		return id;
	}

	@Override
	public void setSalaris(BigDecimal salaris) {
		this.salaris = salaris;

	}

	@Override
	public BigDecimal getSalaris() {
		return salaris;
	}

}
