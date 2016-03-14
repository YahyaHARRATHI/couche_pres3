package couche_pres3;


import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;


import dal.services.SpringFactoryCompte;

@ManagedBean
//@RequestScoped
@ViewScoped// car partagé par 2 méthodes debiter et 
// on a besion d'intercepteur @postConstruct pour le constructeur transactionbean() 
public class TransactionBean implements Serializable {
	@ManagedProperty(value="#{param.numparam}")
	private String parm;
	private int num;
	private int montant;
	
	   
	public String getParm() {
		return parm;
	}
	public void setParm(String parm) {
		this.parm = parm;
	}
	public  TransactionBean(){
		this.num=Integer.parseInt(parm);
		
	}
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
	/*
	public TransactionBean() {
		
		//recuperation de champs num de  beanClient 
				// wthis when we use map
				HttpServletRequest req = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
				int res=Integer.parseInt(req.getParameter("numparam"));
				this.num=res;
				//recuperation de comptes
				// this.num=factComptes.getCompteService().findCompte(res).get(0).getNumero();
				//in our case we usued httpsession
				
	}
	
	*/
	public String transaction1(){
		
		return null;
	}

	
	// on a besion de l'intercepteur pour vérifier que la transaction < 1000 
	//mais dans ce bean il va etre appeler pour tous les methodes  
	//donc on va le defenir dans un autre class
}
