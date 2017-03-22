package composants;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import ressources.MessageDTO;

@ManagedBean(name="controleur")
@RequestScoped
public class AuthentificationGUI {

	private String email;
	private String password;
	private String message;

    
	public AuthentificationGUI() {
		super();
	}
	
    FacesContext context = FacesContext.getCurrentInstance();

	
	public void controler() {
		
		Client client = ClientBuilder.newClient();
		WebTarget cible = client.target(UriBuilder.fromPath("http://tomcatservices:8080/4-authentification-test")); 
		WebTarget ciblefinale = cible.path("serviceauth");
		MessageDTO dto = ciblefinale.queryParam("email", email)
									.queryParam("password", password)
									.request(MediaType.APPLICATION_XML).get(MessageDTO.class);
									message = dto.getBienvenue() + ".";
		
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