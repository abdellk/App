package clientREST;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import modele.Utilisateur;

public class ClientMain {


	public static void main(String[] args){
		
		/* String nom = null ;
		 String prenom = null;
		 String pseudo = null;			**** je remets actif ici après avoir tester avec des champs non null
		 String email = null;
		 String password = null;
		 String message = null;*/
		
		 String nom = null ;//= "Vidal";  test le 9 mars 2017 à 17h29 pr voir la verification des champs non vides avec le service
		 String prenom = "Fabrice";
		 String pseudo = "Doppio";
		 String email = "fabricevidal@test.fr";
		 String password = "vfd";
		 String message;
				
		Client client = ClientBuilder.newClient();		
		WebTarget cible = client.target(UriBuilder.fromPath("http://172.17.0.5:8080/creationprofiltestmain/"));
		WebTarget ciblefinale = cible.path("service");
		System.out.println("ok");
		
		Utilisateur util = ciblefinale.queryParam("nom",nom)
									.queryParam("prenom", prenom)
									.queryParam("pseudo",pseudo)
									.queryParam("email", email)
									.queryParam("password", password)
					
					.request(MediaType.APPLICATION_XML).get(Utilisateur.class);
		
		/*Utilisateur util = new Utilisateur(nom, prenom, pseudo, email, password);

		Response reponse = ciblefinale
							.request(MediaType.APPLICATION_XML)
							.post(Entity.xml(util));
		
		System.out.println(reponse);
		*/
		
	
			
			System.out.println("ok 2");
			message = "Vous venez de créez votre profil Monsieur " +util.getNom()+ ".";
			System.out.println(message + util.getNom()
										+util.getPrenom()
										+util.getPseudo()
										+util.getEmail()
										+util.getPassword());
			
	
	}

}
