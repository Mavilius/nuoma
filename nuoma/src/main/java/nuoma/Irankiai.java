package nuoma;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Irankiai {
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer Id;
	private String inventoriaus_numeris;
	private String pavadinimas;
	private String tipas;
	private Integer pirkimo_data;
	private Integer kaina;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="id_klientai", referencedColumnName="id", insertable=false, updatable=false)
	private List<IrankiaiKlientai> irankiai_klientai; 
	
	public Irankiai() {}
	
	public Irankiai(String inventoriaus_numeris, String pavadinimas, String tipas, Integer pirkimo_data, Integer kaina) {
		this.inventoriaus_numeris = inventoriaus_numeris;
		this.pavadinimas = pavadinimas;
		this.tipas = tipas;
		this.pirkimo_data = pirkimo_data;
		this.kaina = kaina;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getInventoriaus_numeris() {
		return inventoriaus_numeris;
	}

	public void setInventoriaus_numeris(String inventoriaus_numeris) {
		this.inventoriaus_numeris = inventoriaus_numeris;
	}

	public String getPavadinimas() {
		return pavadinimas;
	}

	public void setPavadinimas(String pavadinimas) {
		this.pavadinimas = pavadinimas;
	}

	public String getTipas() {
		return tipas;
	}

	public void setTipas(String tipas) {
		this.tipas = tipas;
	}

	public Integer getPirkimo_data() {
		return pirkimo_data;
	}

	public void setPirkimo_data(Integer pirkimo_data) {
		this.pirkimo_data = pirkimo_data;
	}

	public Integer getKaina() {
		return kaina;
	}

	public void setKaina(Integer kaina) {
		this.kaina = kaina;
	}

	public List<IrankiaiKlientai> getIrankiai_klientai() {
		return irankiai_klientai;
	}

	public void setIrankiai_klientai(List<IrankiaiKlientai> irankiai_klientai) {
		this.irankiai_klientai = irankiai_klientai;
	}
	
	
}
