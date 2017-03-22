package service;

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

@Path("serviceauth")
public class ServiceAuthentification {
	
	private String messageJournal;
	private String nom;
	private int idutil;
	//private String role;
		
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public MessageDTO getDTO(@QueryParam("email") String email, 
						@QueryParam("password") String password) { 
		
		MessageDTO message = new MessageDTO();
		
		if(authentifier(email, password)) {
			message.setBienvenue("Bienvenue Monsieur " + nom);
			message.setVerif(true);
			message.setIdutil(idutil);// avant ça, je dois faire une requete pr recuperer son ID !
									// dans le if (!utilisateur.getPassword ...), je passe dans le else et ici je recup 
									// l'ID de l'utilisateur 
									// finalement pas besoin de ce qu'il y au dessus, faut juste faire un 
									// idutil = utilisateur.getId_utilisateur();
			//message.setRole("Votre role est: " +role);
		}
		else{
			message.setBienvenue(messageJournal);
			message.setVerif(false);}
		
		return message;		
	}
	
	private boolean authentifier(String email, String password) {
		boolean statut = false;
		EntityManager em = null;
		try {
				em = FournisseurDePersistance.getInstance().fournir();
				em.getTransaction().begin();
				Query requete = em.createNativeQuery("SELECT * FROM UTILISATEUR WHERE EMAIL_UTILISATEUR = ?", Utilisateur.class);
				requete.setParameter(1, email);
				Utilisateur utilisateur = (Utilisateur) requete.getSingleResult();
				nom = utilisateur.getNom_utilisateur();
				
			//	role = utilisateur.getRole().getRole();
			//	messageJournal = email +"|" + nom +"|";
				if(!utilisateur.getPassword_utilisateur().equals(password)) {
					messageJournal += "mauvais password";
				}
				else {
					idutil = utilisateur.getId_utilisateur();
						messageJournal += "succes";
						statut = true;
				}
				em.getTransaction().commit();
		} catch (Exception e) {
			messageJournal = email + " est un utilisateur inconnu. Erreur :" + e;
			em.getTransaction().rollback();
		}
		finally {
			try {
					em.close();
				//	journaliser();
			} catch (Exception e) {e.printStackTrace();
			}			
		}
		return statut;
	}
	
	
}
