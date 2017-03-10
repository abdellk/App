package composants;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import ressources.MessageDTO;

@ManagedBean(name="createur")
@RequestScoped
public class CreationProfilGUI {

	private String nom;
	private String prenom;
	private String pseudo;	
	private String email;
	private String password;
	private String message;

	
	
	public CreationProfilGUI() {
		super();
	}

	public void addUtilisateur (){
		Client client = ClientBuilder.newClient();		
		WebTarget cible = client.target(UriBuilder.fromPath("http://172.17.0.5:8080/5-creationprofil/"));
		WebTarget ciblefinale = cible.path("service");
		
		MessageDTO dto = ciblefinale.queryParam("nom",nom)
									.queryParam("prenom", prenom)
									.queryParam("pseudo",pseudo)
									.queryParam("email", email)
									.queryParam("password", password)
					
					.request(MediaType.APPLICATION_XML).get(MessageDTO.class);
		
		message =  dto.getMessage() + dto.getNomU();
		
		
	}
	
	//************************************** GETTERS ET SETTERS ******************************************************


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

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
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
	
	
	


	
}