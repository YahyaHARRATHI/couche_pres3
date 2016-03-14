package couche_pres3;


import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import dal.services.SpringFactoryCompte;

@Named
//@RequestScoped
@javax.faces.view.ViewScoped
// car partagé par 2 méthodes debiter et 
// on a besion d'intercepteur @postConstruct pour le constructeur transactionbean() 
public class TransactionBean implements Serializable {
	
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
				int res=Integer.parseInt(req.getParameter("numparam"));
				System.out.println("res");
				this.num=res;
				//recuperation de comptes
				// this.num=factComptes.getCompteService().findCompte(res).get(0).getNumero();
				//in our case we usued httpsession
				
	}
	
	
	public String transaction1(){
		
		return null;
	}

	
	// on a besion de l'intercepteur pour vérifier que la transaction < 1000 
	//mais dans ce bean il va etre appeler pour tous les methodes  
	//donc on va le defenir dans un autre class
}
