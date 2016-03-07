package couche_pres3;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.spi.Bean;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

@Named
@RequestScoped
public class TransactionBean {
	
	private Long num;
	private int montant;
	
	public Long getNum() {
		//recuperation de champs num de  beanClient 
		// wthis when we use map
		HttpServletRequest req = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		Long res=Long.parseLong(req.getParameter("IdClient"));
		//in our case we usued httpsession
		
		return res;
		
	}
	public void setNum(Long num) {
		this.num = num;
	}
	public int getMontant() {
		return montant;
	}
	public void setMontant(int montant) {
		this.montant = montant;
	}
	public TransactionBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public String transaction(){
		
		return null;
	}

}
