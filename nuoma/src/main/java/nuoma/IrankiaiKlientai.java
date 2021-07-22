package nuoma;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class IrankiaiKlientai {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer Id;
	private Integer id_irankiai;
	private Integer id_klientai;
	private Integer paemimo_data;
	private Integer grazinimo_data;
	private Integer irankio_bukle;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_irankiai",referencedColumnName="id",insertable=false, updatable=false)
	private Irankiai irankiai;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_klientai",referencedColumnName="id",insertable=false, updatable=false)	 
	private Klientai klientai;
	
	public IrankiaiKlientai() {}
	
	public IrankiaiKlientai(Integer id_irankiai, Integer id_klientai, Integer paemimo_data, Integer grazinimo_data, Integer irankio_bukle) {
		this.id_irankiai = id_irankiai;
		this.id_klientai = id_klientai;
		this.paemimo_data = paemimo_data;
		this.grazinimo_data = grazinimo_data;
		this.irankio_bukle = irankio_bukle;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public Integer getId_irankiai() {
		return id_irankiai;
	}

	public void setId_irankiai(Integer id_irankiai) {
		this.id_irankiai = id_irankiai;
	}

	public Integer getId_klientai() {
		return id_klientai;
	}

	public void setId_klientai(Integer id_klientai) {
		this.id_klientai = id_klientai;
	}

	public Integer getPaemimo_data() {
		return paemimo_data;
	}

	public void setPaemimo_data(Integer paemimo_data) {
		this.paemimo_data = paemimo_data;
	}

	public Integer getGrazinimo_data() {
		return grazinimo_data;
	}

	public void setGrazinimo_data(Integer grazinimo_data) {
		this.grazinimo_data = grazinimo_data;
	}

	public Integer getIrankio_bukle() {
		return irankio_bukle;
	}

	public void setIrankio_bukle(Integer irankio_bukle) {
		this.irankio_bukle = irankio_bukle;
	}

	public Irankiai getIrankiai() {
		return irankiai;
	}

	public void setIrankiai(Irankiai irankiai) {
		this.irankiai = irankiai;
	}

	public Klientai getKlientai() {
		return klientai;
	}

	public void setKlientai(Klientai klientai) {
		this.klientai = klientai;
	}
}
