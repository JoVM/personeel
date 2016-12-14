package be.vdab.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "werknemers")
public class Werknemer implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String voornaam;
	private String familienaam;
	private String email;
	private BigDecimal salaris;
	private int versie;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "chefid")
	private Werknemer werknemer;
	@OneToMany(mappedBy = "werknemer")
	private Set<Werknemer> werknemers;

	public long getId() {
		return id;
	}

	public String getVoornaam() {
		return voornaam;
	}

	public String getFamilienaam() {
		return familienaam;
	}

	public String getEmail() {
		return email;
	}

	public BigDecimal getSalaris() {
		return salaris;
	}

	public int getVersie() {
		return versie;
	}

	public Werknemer getWerknemer() {
		return werknemer;
	}

	public Set<Werknemer> getWerknemers() {
		return werknemers;
	}

}
