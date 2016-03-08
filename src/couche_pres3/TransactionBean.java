package couche_pres3;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.spi.Bean;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import dal.services.SpringFactoryCompte;

@Named
@RequestScoped
public class TransactionBean {
	
	private int num;
	private int montant;
	SpringFactoryCompte factComptes = new SpringFactoryCompte();
	
	public int getNum() {
		
		
		return num;
		
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getMontant() {
		return montant;
	}
	public void setMontant(int montant) {
		this.montant = montant;
	}
	public TransactionBean() {
		
		//recuperation de champs num de  beanClient 
				// wthis when we use map
				HttpServletRequest req = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
				System.out.println(req.getParameter("c"));
				
				//recuperation de comptes
				// this.num=factComptes.getCompteService().findCompte(res).get(0).getNumero();
				//in our case we usued httpsession
				
	}
	
	
	public String transaction(){
		
		return null;
	}

}
