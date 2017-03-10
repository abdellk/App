package composants;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import ressources.ListeUtilisateurDTO;
import ressources.UtilisateurDTO;

@ManagedBean(name = "listeuser")
@RequestScoped
public class ListeutilisateursGUI {
	
	private List<UtilisateurDTO> listeUtilisateurs = new ArrayList<>();

	@PostConstruct
	public void controler() {
		Client client = ClientBuilder.newClient();											
		WebTarget cible = client.target(UriBuilder.fromPath("http://tomcatauthentificateur:8080/5-listeutilisateurs/"));
		WebTarget ciblefinale = cible.path("listeutil");
		ListeUtilisateurDTO dtoliste = ciblefinale.request(MediaType.APPLICATION_XML).get(ListeUtilisateurDTO.class);
		listeUtilisateurs = dtoliste.getListedto();
	}

	public List<UtilisateurDTO> getListeUtilisateurs() {
		return listeUtilisateurs;
	}

	public void setListeUtilisateurs(List<UtilisateurDTO> listeUtilisateurs) {
		this.listeUtilisateurs = listeUtilisateurs;
	}

	public ListeutilisateursGUI() {
		super();
	}
	
	

}
