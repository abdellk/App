package composants;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import modele.Utilisateur;
import outils.ListeUtilisateurDTO;
import outils.UtilisateurDTO;
import ressources.FournisseurDePersistance;

@Path("listeutil")
public class ServiceListeUtilisateur {
	
	ListeUtilisateurDTO listeDTO; 
		
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public ListeUtilisateurDTO getDTO() {
		listeDTO = new ListeUtilisateurDTO();
		peuplementListe();
		return listeDTO;		
	}
	
	private void peuplementListe() {
	
		EntityManager em = null;
	
		try {
				em = FournisseurDePersistance.getInstance().fournir();
				em.getTransaction().begin();
				Query requete = em.createNativeQuery("SELECT * FROM UTILISATEUR", Utilisateur.class);
				List<Utilisateur> users = requete.getResultList();
				for(Utilisateur iter : users){
					listeDTO.getListedto().add(new UtilisateurDTO(iter.getNom_utilisateur(), 
																	iter.getPrenom_utilisateur(), 
																	iter.getPseudo_utilisateur(), 
																	iter.getEmail_utilisateur(), 
																	iter.getPassword_utilisateur())); 
				}
				
				em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
		finally {
			try {
					em.close();
				} catch (Exception e) {e.printStackTrace();
			}			
		}
	}
}