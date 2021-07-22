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
public class Klientai {
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer Id;
	private String vardas;
	private String tipas_kliento;
	private String kontaktai;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="id_irankiai", referencedColumnName="id", insertable=false, updatable=false)
	private List<IrankiaiKlientai> irankiai_klientai; 
	
	public Klientai() {}
	
	public Klientai(String vardas, String tipas_kliento, String kontaktai) {
		this.vardas = vardas;
		this.tipas_kliento = tipas_kliento;
		this.kontaktai = kontaktai;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getVardas() {
		return vardas;
	}

	public void setVardas(String vardas) {
		this.vardas = vardas;
	}

	public String getTipas_kliento() {
		return tipas_kliento;
	}

	public void setTipas_kliento(String tipas_kliento) {
		this.tipas_kliento = tipas_kliento;
	}

	public String getKontaktai() {
		return kontaktai;
	}

	public void setKontaktai(String kontaktai) {
		this.kontaktai = kontaktai;
	}

	public List<IrankiaiKlientai> getIrankiai_klientai() {
		return irankiai_klientai;
	}

	public void setIrankiai_klientai(List<IrankiaiKlientai> irankiai_klientai) {
		this.irankiai_klientai = irankiai_klientai;
	}		
}
