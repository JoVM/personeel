package be.vdab.valueobjects;

import java.math.BigDecimal;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

public class OpslagWerknemer {
	@DecimalMin("1")
	@NotNull
	private BigDecimal bedrag;

	public BigDecimal getBedrag() {
		return bedrag;
	}

	public void setBedrag(BigDecimal bedrag) {
		this.bedrag = bedrag;
	}

}
