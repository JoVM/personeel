package be.vdab.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "jobtitels")
public class Jobtitel implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String naam;

	@OneToMany(mappedBy = "jobtitel")
	private Set<Werknemer> werknemers;

	private int versie;

	public long getId() {
		return id;
	}

	public String getNaam() {
		return naam;
	}

	public int getVersie() {
		return versie;
	}

	public Set<Werknemer> getWerknemers() {
		return werknemers;
	}

//	@Override
//	public String toString() {
//		return "Jobtitel [id=" + id + ", naam=" + naam + ", versie=" + versie + "]";
//	}

}
