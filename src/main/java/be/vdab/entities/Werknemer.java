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
import javax.persistence.Version;

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

	@Version
	private int versie;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "jobtitelid")
	private Jobtitel jobtitel;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "chefid")
	private Werknemer chef;
	@OneToMany(mappedBy = "chef")
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

	public Werknemer getChef() {
		return chef;
	}

	public Set<Werknemer> getWerknemers() {
		return werknemers;
	}

	public Jobtitel getJobtitel() {
		return jobtitel;
	}

	public void geefOpslag(BigDecimal opslag) {
		BigDecimal salaris = this.getSalaris();
		salaris = salaris.add(opslag);
		setSalaris(salaris);
	}

	void setSalaris(BigDecimal salaris) {
		if (salaris.equals(BigDecimal.ZERO) || salaris.signum() == -1) {
			throw new IllegalArgumentException("salaris mag niet gelijk aan nul of negatief zijn.");
		}
		this.salaris = salaris;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((familienaam == null) ? 0 : familienaam.hashCode());
		result = prime * result + ((salaris == null) ? 0 : salaris.hashCode());
		result = prime * result + ((voornaam == null) ? 0 : voornaam.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Werknemer other = (Werknemer) obj;
		if (familienaam == null) {
			if (other.familienaam != null)
				return false;
		} else if (!familienaam.equals(other.familienaam))
			return false;
		if (salaris == null) {
			if (other.salaris != null)
				return false;
		} else if (!salaris.equals(other.salaris))
			return false;
		if (voornaam == null) {
			if (other.voornaam != null)
				return false;
		} else if (!voornaam.equals(other.voornaam))
			return false;
		return true;
	}

	// @Override
	// public String toString() {
	// return "Werknemer [id=" + id + ", voornaam=" + voornaam + ",
	// familienaam=" + familienaam + ", email=" + email
	// + ", salaris=" + salaris + ", versie=" + versie + ", chef=" + chef + ",
	// werknemers=" + werknemers + "]";
	// }

}
