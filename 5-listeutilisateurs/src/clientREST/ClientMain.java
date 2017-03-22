package clientREST;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import outils.ListeUtilisateurDTO;
import outils.UtilisateurDTO;

public class ClientMain {


	public static void main(String[] args){
		
		Client client = ClientBuilder.newClient();
		WebTarget cible = client.target(UriBuilder.fromPath("http://172.17.0.4:8080/4-listeutilisateurs"));
		WebTarget ciblefinale = cible.path("listeutil");
		ListeUtilisateurDTO dtoliste = ciblefinale.request(MediaType.APPLICATION_XML).get(ListeUtilisateurDTO.class);
		for(UtilisateurDTO iter: dtoliste.getListedto())
			System.out.println(iter.getNom()
								+iter.getPrenom()
								+" | "+iter.getPseudo()
								+" | "+iter.getEmail()
								+" | "+iter.getPassword());
	}

}
