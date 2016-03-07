package couche_pres3;


import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import dal.beans.Client;
import dal.services.SpringFactoryClient;

@Named
@SessionScoped
//implement seriazable car sessionscoped
public class AuthenBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String login;
	private String password;
	SpringFactoryClient factclient;
	
	//le client n'est pas un attribut car on va l'utiliser dans autre vue
	//on va l'instancier et le mettre dans la session
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public String connect(){
		
		 factclient=new SpringFactoryClient();
		Client c= factclient.getClientService().authenticate(this.login, this.password);
		
		if(c==null){
			
		System.out.println("nullllllllllllllllllll");
			return null;
		}
			
		else  {
			//ajout le clientBean dans la session
			//le client doit etre de porté session
			//Recupération de facesContext
			FacesContext context=FacesContext.getCurrentInstance();
			//soit on l'ajout dans map
			//ou httpsession
			HttpSession session=(HttpSession) context.getExternalContext().getSession(true);
			session.setAttribute("IdClient", c.getId());
			
		return "Accueil";
	}
	}

}
