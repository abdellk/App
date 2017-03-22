package composants;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import util.SessionUtils;

import ressources.MessageDTO;

@ManagedBean(name="controleur")
@RequestScoped
public class AccueilGUI implements Serializable{

	private String email;
	private String password;
	private String message;
	private String nom;
	private long idutil;
	private String idautre;
	private String idsession;
	private boolean connecter;
	private static final long serialVersionUID = 1094801825228386363L;

	
	public AccueilGUI() {
		super();
	}
	
	public String authentifier(){
		
		Client client = ClientBuilder.newClient();
		WebTarget cible = client.target(UriBuilder.fromPath("http://tomcatservices:8080/4-authentification")); 
		WebTarget ciblefinale = cible.path("serviceauth");
		MessageDTO dto = ciblefinale.queryParam("email", email)
									.queryParam("password", password)
									.request(MediaType.APPLICATION_XML).get(MessageDTO.class);
				
							if (dto.isVerif()){
								connecter = true;
								email = dto.getEmail();
								HttpSession session = SessionUtils.getSession();
								idutil =dto.getIdutil();
								session.setAttribute("email", email);
								session.setAttribute("userid", idutil);
								message = "Voici l'email: "+(String) session.getAttribute("email");
								idsession = "Voici l'id de l'utilisateur: "+(Long) session.getAttribute("userid");
								idautre = "Voici l'id de la session: "+(String) session.getId();
								message += idsession + idautre;
								
										return "accueil.xhtml";
							}
								connecter = false;
								message = dto.getBienvenue() + ".";

								FacesContext.getCurrentInstance().addMessage(
									null,
									new FacesMessage(FacesMessage.SEVERITY_WARN,
											message,
											"Please enter correct username and Password"));
								return "authentification.xhtml";
							
									// ici, stocker le id avec un "id = dto.getId()"; de ce genre là
	}
	
	/* A REUTILISER PLUS TARD
	private boolean login(String email){
		MessageDTO dto = new MessageDTO();
		dto.setEmail(email);
		if (dto.getEmail().equals("")) return false;
		
		return true;
		
	}*/
	
	public String logout() {
		connecter = false;
		HttpSession session = SessionUtils.getSession();
		session.invalidate();
		return "authentification.xhtml";
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public long getIdutil() {
		return idutil;
	}

	public void setIdutil(long idutil) {
		this.idutil = idutil;
	}

	public String getIdsession() {
		return idsession;
	}

	public void setIdsession(String idsession) {
		this.idsession = idsession;
	}

	public String getIdautre() {
		return idautre;
	}

	public void setIdautre(String idautre) {
		this.idautre = idautre;
	}

	public boolean isConnecter() {
		return connecter;
	}

	public void setConnecter(boolean connecter) {
		this.connecter = connecter;
	}

}