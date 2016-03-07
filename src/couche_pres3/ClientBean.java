package couche_pres3;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

import dal.beans.Client;
import dal.beans.Compte;
import dal.services.SpringFactoryClient;

@Named
@RequestScoped
public class ClientBean {
	private Logger logger;
	private Long num;
	private String nom;
	private String prenom ;
	
	private Collection<Compte> comptes;
	//pas la peine car depuis d'un jar  //pas distribu�
	
	SpringFactoryClient factclient;
	
	
	
	public Collection<Compte> getComptes() {
		return comptes;
	}
	public void setComptes(Collection<Compte> comptes) {
		this.comptes = comptes;
	}
	public void setComptes(List<Compte> comptes) {
		this.comptes = comptes;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	
	
	public String listComptes(){
		  
		factclient=new SpringFactoryClient();
		List<Client> client= new ArrayList<Client>();
		client=factclient.getClientService().findClient(nom, prenom);
		Client res=client.get(1);
		/*for (Iterator iterator = client.iterator(); iterator.hasNext();) {
			Client client2 = (Client) iterator.next();
			this.comptes=client2.getComptes();
			
		}
		*/
		this.comptes=res.getComptes();
		return null;
		
	}
	
	
	public Long getNum() {
		return num;
	}
	public void setNum(Long num) {
		this.num = num;
	}
	
	/*
	
	@AroundInvoke
	private Object logMethod(InvocationContext ic) throws Exception {
		logger.entering(ic.getTarget().toString(), ic.getMethod().getName());
		 try {
			return ic.proceed();
		} finally  {
			logger.exiting(ic.getTarget().toString(), ic.getMethod().getName());
		}
		 
		 
	}
	*/
	

}