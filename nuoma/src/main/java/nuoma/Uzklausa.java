package nuoma;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

public class Uzklausa {
protected Session em;
	
	public Uzklausa() {}
	
	public Uzklausa(  Session em  ) {
		    this.em = em;
	}
	
	 @SuppressWarnings("unchecked")
	 public List<Uzklausa> nuomaRange( String nuo, String iki ) {
		
		  			
		 
		  	String top_nuoma =
		  				
		  			"SELECT "
		  			+ " `vardas`,`pavadinimas`,`irankio_bukle"		  					
		  			+ " FROM `irankiai_klientai` "
		  			+ " LEFT JOIN `klientai` ON (irankiai_klientai.id_klientai = klientai.id)"
		  			+ " LEFT JOIN `irankiai` ON (irankiai_klientai.id_irankiai = irankiai.id)"		  			
		  			+ " WHERE "		  			
		  			+ " 1 "
		  			+ " ORDER BY irarnkiai_kleintai. DESC"
		  			
		  			;
		  	
		    Query query = em.createNativeQuery ( top_nuoma );
		    return (List<Uzklausa>) query.getResultList();
	  	
	 }
}