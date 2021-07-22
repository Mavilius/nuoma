package nuoma;

import java.io.IOException;
import java.util.ArrayList;

import javax.persistence.EntityManagerFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {
	
	@Autowired
	private IrankiaiRepository irankiai_repository; 
	@Autowired
	private KlientaiRepository klientai_repository;
	@Autowired
	private IrankiaiKlientaiRepository irankiai_klientai_repository;
	
	@Autowired 
	EntityManagerFactory factory;	
	
	public SessionFactory sessionFactory() {

		
        if (factory.unwrap(SessionFactory.class) == null) {
            throw new NullPointerException("factory is not a hibernate factory");
        }
        return factory.unwrap(SessionFactory.class);
}	
	
	@RequestMapping(path="/", method={ RequestMethod.GET, RequestMethod.POST })
	public String nuoma(@RequestParam(name="inventoriaus_numeris", required=true, defaultValue="-") String inventoriaus_numeris,
						 @RequestParam(name="pavadinimas", required=true, defaultValue="-") String pavadinimas,
						 @RequestParam(name="tipas", required=true, defaultValue="-") String tipas,
						 @RequestParam(name="pirkimo_data", required=true, defaultValue="-") String pirkimo_data,
						 @RequestParam(name="kaina", required=true, defaultValue="-") String kaina,
						 @RequestParam(name="vardas", required=true, defaultValue="-") String vardas,
						 @RequestParam(name="tipas_kliento", required=true, defaultValue="-") String tipas_kliento,
						 @RequestParam(name="kontaktai", required=true, defaultValue="-") String kontaktai,
						 @RequestParam(name="send", required=true, defaultValue="-") String send,
						 Model model) throws IOException {
		
		ArrayList<String> klaidos = new ArrayList<String>();
		
		if(send != null && send.equals("Siųsti")) {
			
			boolean yra_klaidu = false;
			if(!arPavadinimas(pavadinimas)) {
				yra_klaidu = true;
				klaidos.add("pavadinimas turi buti sudarytas tik is Lotynisku abeceles simboliu");
			}
			if(!yra_klaidu) {
			Irankiai irankiai = new Irankiai(
									inventoriaus_numeris
								   ,pavadinimas
			 					   ,tipas
			 					   ,Integer.parseInt(pirkimo_data)
			 					   ,Integer.parseInt(kaina));
			
			irankiai = irankiai_repository.save(irankiai);		
			
		    Klientai klientai = new Klientai(
									vardas
									,tipas_kliento
									,kontaktai);
			
		    klientai = klientai_repository.save(klientai);
		    
		    return "redirect:klientai?id_kliento=" + irankiai.getId();		
			}
			
		}
		
		
		Iterable<Irankiai> irankiai_visi = irankiai_repository.findAll();
		Iterable<Klientai> klientai_visi = klientai_repository.findAll();
		Iterable<IrankiaiKlientai> irankiai_klientai_visi = irankiai_klientai_repository.findAll();
		
		model.addAttribute("irankiai", irankiai_visi );
		model.addAttribute("klientai", klientai_visi);
		model.addAttribute("irankiai_klientai", irankiai_klientai_visi);
		
		return "nuoma";
	}
	public static boolean arPavadinimas(String pavadinimas) {
		  return pavadinimas.matches("^[a-zA-Z]+$");  
	}
	
	@RequestMapping(path="/sutartys", method={ RequestMethod.GET, RequestMethod.POST })
	public String sutartys(@RequestParam(name="id_irankiai", required=true, defaultValue="-") String id_irankiai,
						 @RequestParam(name="id_klientai", required=true, defaultValue="-") String id_klientai,
						 @RequestParam(name="paemimo_data", required=true, defaultValue="-") String paemimo_data,
						 @RequestParam(name="grazinimo_data", required=true, defaultValue="-") String grazinimo_data,
						 @RequestParam(name="irankio_bukle", required=true, defaultValue="-") String irankio_bukle,
						 Model model) throws IOException {
		
		IrankiaiKlientai irankiai_klientai = new IrankiaiKlientai(
												Integer.parseInt(id_irankiai)
												,Integer.parseInt(id_klientai)
												,Integer.parseInt(paemimo_data)
												,Integer.parseInt(paemimo_data)
												,Integer.parseInt(irankio_bukle));
		
		irankiai_klientai = irankiai_klientai_repository.save(irankiai_klientai);	
		
		Iterable<IrankiaiKlientai> irankiai_klientai_visi = irankiai_klientai_repository.findAll();
		
		model.addAttribute ( "irankiai_klientai", irankiai_klientai_visi );
		
		return "sutartys";	
	}
	
}