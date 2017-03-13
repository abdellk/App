package composants;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import modele.Utilisateur;
import ressources.FournisseurDePersistance;
import ressources.MessageDTO;

@Path("service")
public class ServiceCreation {
	
	private String messageJ;
	EntityManager em = null;
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public MessageDTO getDTO(@QueryParam("nom") String nom,
							@QueryParam("prenom") String prenom,
							@QueryParam("pseudo") String pseudo, 
							@QueryParam("email") String email,
							@QueryParam("password") String password) {

		MessageDTO message = new MessageDTO();
		
		if (verifchamp(nom, prenom, pseudo, email, password)){
		
		if (creationprofil( nom,  prenom,  pseudo,  email,  password)){
			
			message.setMessage("Votre profil a bien été créé Monsieur " );
			message.setNomU(nom);
		}
		else message.setMessage(messageJ); 
		
		}
		else { messageJ = "Vous devez remplir tous les champs." ; 
		message.setMessage(messageJ);
		message.setNomU("");
		}
		
			
		return message;
	}
	

	/*
	 * methode de verification de champ non null
	 */
	
	private boolean verifchamp (String nom, String prenom, String pseudo, String email, String password){
			
			boolean statutchamp = true;
			
			//tester avec nom.equals (""), càd champ vide
			
			if ( nom.equals("") ||
				prenom.equals("")||
				pseudo.equals("")||
				email.equals("")||
				password.equals("")){
					 
					statutchamp = false;
			}
			
			return statutchamp;
		}


	private boolean creationprofil(String nom, String prenom, String pseudo, String email, String password) {

		boolean statut = false;
		
		/*
		 * FAIRE UNE VERIFICATION DES CHAMPS NON NULL :
		 * SI UN CHAMP EST NULL, ENVOIE D UN MESSAGE D ERREUR ET DONC PAS DE PERSIST
		 */
												/*	if (foo == null) {
													    // That will work.
													}*/				
		
		try {
			em = FournisseurDePersistance.getInstance().fournir();
			em.getTransaction().begin();
			Query requete = em.createNativeQuery("SELECT * FROM UTILISATEUR WHERE EMAIL_UTILISATEUR = '" + email  
																	+ "'" +"AND PSEUDO_UTILISATEUR = '" + pseudo +"'",Utilisateur.class);
			List <Utilisateur> utilisateur = requete.getResultList();
			
			if  (utilisateur.size() > 0){	
				messageJ = "L'email ou/et le pseudo que vous aviez entré(s) existe(nt) déjà. Voici l'erreur : ";
				
			} else {
				Utilisateur util = new Utilisateur(nom, prenom, pseudo, email, password, new Date() );
				em.persist(util);
				em.getTransaction().commit();
				statut = true;
		}
			
		} catch (Exception e) {
			messageJ = "L'email ou/et le pseudo que vous aviez entré(s) existe(nt) déjà. Voici l'erreur : " +e;
			//em.getTransaction().rollback();  LE REACTIVER PR PLUS TARD PR VOIR CE QUE CELA FAIT
		}
			
		em.close();

		return statut;
		}
	
	
	
}